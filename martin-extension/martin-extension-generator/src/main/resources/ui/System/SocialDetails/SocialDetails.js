import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './SocialDetailsColumns';

class SocialDetails  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/SocialDetails/SocialDetailsModal'
      title='系统社交账号"'
      content=''
      url='/system/socialDetails/'
    />;
  }
}

export default SocialDetails ;
