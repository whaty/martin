import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './UserRoleColumns';

class UserRole  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/UserRole/UserRoleModal'
      title='系统用户角色关系"'
      content=''
      url='/system/userRole/'
    />;
  }
}

export default UserRole ;
