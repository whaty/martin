import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './OperationColumns';

class Operation  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/Operation/OperationModal'
      title='系统操作"'
      content=''
      url='/system/operation/'
    />;
  }
}

export default Operation ;
