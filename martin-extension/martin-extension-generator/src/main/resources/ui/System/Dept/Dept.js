import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './DeptColumns';

class Dept  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/Dept/DeptModal'
      title='系统部门"'
      content=''
      url='/system/dept/'
    />;
  }
}

export default Dept ;
