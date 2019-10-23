import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './DeptRoleColumns';

class DeptRole  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/DeptRole/DeptRoleModal'
      title='系统部门角色关系"'
      content=''
      url='/system/deptRole/'
    />;
  }
}

export default DeptRole ;
