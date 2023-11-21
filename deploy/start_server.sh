echo "Server deploy starts!"
set -e
while getopts "n:" opt; do
  case "$opt" in
  n) name="$OPTARG" ;;
  esac
done

if [ -z "$name" ]; then
  echo "ERROR! Please input the version number for package. E.g.: 3.0.0"
  exit
fi

sysctl_start() {
  systemctl is-active --quiet "$1"
  code=$?
  if [ "$code" == 0 ]; then
    echo "$1 is active."
    return 0
  else
    echo "$1 is inactive. Will start $1."
    systemctl start redis
    echo "Start $1 is done."
    return 1
  fi
}

# Start server
pid=$(ps -ef | grep main | grep -v grep | awk '{print $2}')
echo "Start checking $pid aliveness."
while [[ -n $pid ]]; do
  kill "$pid"
  echo "Killing succeeded!"
  echo "$pid is alive. Will recheck after 3s."
  sleep 3
  pid=$(ps -ef | grep main | grep -v grep | awk '{print $2}')
done
echo "$pid was dead!"
sleep 2 # In case the port is not fully released.
echo "Start launching server."
rm be.log
nohup java -Dfile.encoding=UTF-8 -jar "$name".jar --spring.profiles.active=prod >>be.log 2>&1 &
echo $! >nohup_pid.txt
sleep 2
# track the log file
tail -fn0 be.log |
  while read line; do
    echo $line
    if [ "$line" = "Let's go! TEAM!" ]; then
      echo "Java server launching was successful!"
      pkill -P $$ tail
      break
    fi
  done
echo "Deploy was successful. Congrats!"
