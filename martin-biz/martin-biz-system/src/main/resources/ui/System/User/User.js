import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './UserColumns';

class User  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/User/UserModal'
      title='系统用户"'
      content=''
      url='/system/user/'
    />;
  }
}

export default User ;
