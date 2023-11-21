import React from 'react';
import { Typography } from 'antd';
import Style from './index.less';

export default () => {
  return (
    <Typography.Paragraph className={Style.CenterText}>
      大家好，我是Alex，是一个喜欢编程的程序员。
    </Typography.Paragraph>
  );
};
