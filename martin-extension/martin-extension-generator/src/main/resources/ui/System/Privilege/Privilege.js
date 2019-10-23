import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './PrivilegeColumns';

class Privilege  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/Privilege/PrivilegeModal'
      title='系统权限"'
      content=''
      url='/system/privilege/'
    />;
  }
}

export default Privilege ;
