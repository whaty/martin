import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './DeptUserColumns';

class DeptUser  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/DeptUser/DeptUserModal'
      title='系统用户部门关系"'
      content=''
      url='/system/deptUser/'
    />;
  }
}

export default DeptUser ;
