import React from 'react';
import { message, Space, Table, Tag } from 'antd';
import { ProTable } from "@ant-design/pro-table";
import type { ProColumns } from '@ant-design/pro-components';
import axios from "axios";

interface DataType {
  key: string;
  name: string;
  location: string;
  size: number;
  uploadTime: Date;
}

const columns: ProColumns<DataType>[] = [
  {
    title: 'name',
    dataIndex: 'name',
    key: 'name',
    render: (text: any) => <a>{text}</a>,
    align: 'center'
  },
  {
    title: 'location',
    dataIndex: 'location',
    key: 'location',
    align: 'center'
  },
  {
    title: 'size(Bytes)',
    dataIndex: 'size',
    key: 'size',
    align: 'center'
  },
  {
    title: 'upload time',
    key: 'uploadTime',
    dataIndex: 'uploadTime',
    valueType: "dateTime",
    align: 'center'
  },
  {
    title: 'Action',
    key: 'action',
    render: (_, record: any) => (
      <Space size="middle">
        <a>Download</a>
        <a onClick={async () => {
          let res = await axios.get(`/api/file/delete?id=${record.id}`);
          if (res.data.data === 1) {
            message.success('Delete was successful!');
          } else {
            message.error('Delete failed!');
          }
        }}>Delete</a>
      </Space>
    ),
    align: 'center'
  },
];
// const data: DataType[] = [
//   {
//     key: '1',
//     name: 'samplefile1.txt',
//     location: "Victoria",
//     size: 1,
//     uploadTime: new Date(),
//   },
//   {
//     key: '2',
//     name: 'samplefile2.txt',
//     location: "Victoria",
//     size: 2.0,
//     uploadTime: new Date(),
//   },
//   {
//     key: '3',
//     name: 'samplefile3.txt',
//     location: "Vancouver",
//     size: 3.555,
//     uploadTime: new Date(),
//   },
// ];

const App: React.FC = () => {
  return <ProTable headerTitle="All Files" columns={columns} search={false} request={async () => {
    let res = await axios.get("/api/file/get/all");
    return res.data;
  }}/>;
};

export default App;