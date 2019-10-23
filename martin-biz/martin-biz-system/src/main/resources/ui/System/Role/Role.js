import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './RoleColumns';

class Role  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/Role/RoleModal'
      title='系统角色"'
      content=''
      url='/system/role/'
    />;
  }
}

export default Role ;
