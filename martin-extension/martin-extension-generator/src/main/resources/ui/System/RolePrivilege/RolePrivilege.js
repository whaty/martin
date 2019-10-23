import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './RolePrivilegeColumns';

class RolePrivilege  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/RolePrivilege/RolePrivilegeModal'
      title='系统角色权限关系"'
      content=''
      url='/system/rolePrivilege/'
    />;
  }
}

export default RolePrivilege ;
