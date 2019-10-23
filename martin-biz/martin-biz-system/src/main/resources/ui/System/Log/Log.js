import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './LogColumns';

class Log  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/Log/LogModal'
      title='系统日志"'
      content=''
      url='/system/log/'
    />;
  }
}

export default Log ;
