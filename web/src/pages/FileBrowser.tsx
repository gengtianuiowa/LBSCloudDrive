import FileBrowserTitle from "@/components/fileBrowser/FileBrowserTitle";
import FileTable from "@/components/uploadFiles/FileTable";

const DocsPage = () => {
  return (
    <div className={"flex flex-col justify-center items-center"}>
      <FileBrowserTitle/>
      <FileTable/>
    </div>
  );
};

export default DocsPage;
