import React, {Component} from 'react';
import MartinCRUD from "@/components/MartinCRUD";
import columns from './FileColumns';

class File  extends Component {

  render() {
    return <MartinCRUD
      columns={columns}
      modalPath='System/File/FileModal'
      title='系统操作"'
      content=''
      url='/system/file/'
    />;
  }
}

export default File ;
