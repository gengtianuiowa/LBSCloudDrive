import FileBrowserTitle from "@/components/fileBrowser/FileBrowserTitle";
import FileTable from "@/components/uploadFiles/FileTable";

const DocsPage = () => {
  return (
    <div className={"flex flex-col justify-center items-center"}>
      <FileBrowserTitle/>
      <div className={"w-full"}>
        <FileTable/></div>
    </div>
  );
};

export default DocsPage;
