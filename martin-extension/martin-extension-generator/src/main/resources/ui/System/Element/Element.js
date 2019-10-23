import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './ElementColumns';

class Element  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/Element/ElementModal'
      title='系统页面元素"'
      content=''
      url='/system/element/'
    />;
  }
}

export default Element ;
