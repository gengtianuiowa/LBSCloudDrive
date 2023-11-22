import React from 'react';
import { InboxOutlined } from '@ant-design/icons';
import type { UploadProps } from 'antd';
import { message, Typography, Upload } from 'antd';
import UploadTitle from "@/components/uploadFiles/UploadTitle";
import axios from "axios";

const { Dragger } = Upload;
const props: UploadProps = {
  name: 'file',
  multiple: true,
  action: async (file) => {
    console.log(file.name);
    let res = await axios.post("/api/upload", { name: file.name });
    message.success(`File upload was successful! File location: ${res.data.data}`);
    return "success";
  },
  method: "POST",
  onChange(info) {
    const { status } = info.file;
    if (status !== 'uploading') {
      console.log(info.file, info.fileList);
    }
    if (status === 'error') {
      message.error(`${info.file.name} file upload failed.`);
    }
  },
  onDrop(e) {
    console.log('Dropped files', e.dataTransfer.files);
  },
};

const App: React.FC = () => (
  <div className={"flex flex-col justify-center items-center"}>
    <div className={"mb-2"}>
      <UploadTitle/>
    </div>
    <div className={"w-full"}>
      <Dragger {...props}>
        <p className="ant-upload-drag-icon">
          <InboxOutlined/>
        </p>
        <p className="ant-upload-text">Click or drag file to this area to upload</p>
        <p className="ant-upload-hint">
          Support for a single or bulk upload. Strictly prohibited from uploading company data or other
          banned files.
        </p>
      </Dragger>
    </div>
  </div>
);

export default App;