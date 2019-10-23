import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './MenuColumns';

class Menu  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/Menu/MenuModal'
      title='系统菜单"'
      content=''
      url='/system/menu/'
    />;
  }
}

export default Menu ;
