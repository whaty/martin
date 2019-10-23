import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './DictColumns';

class Dict  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/Dict/DictModal'
      title='系统字典"'
      content=''
      url='/system/dict/'
    />;
  }
}

export default Dict ;
