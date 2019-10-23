import React, { PureComponent } from 'react'
import { Form, Input, InputNumber, Modal as AntModal } from 'antd'

const FormItem = Form.Item

const formItemLayout = {
  labelCol: {
    span: 6,
  },
  wrapperCol: {
    span: 14,
  },
}
@Form.create()
class Modal extends PureComponent {
  handleOk = () => {
  const { item = {}, onOk, form } = this.props
const { validateFields, getFieldsValue } = form

validateFields(errors => {
  if (errors) {
    return
  }
  const data = {
...getFieldsValue(),
        key: item.key,
}
onOk(data);
})
}


render() {
  const { item = {}, onOk,title, form, ...modalProps } = this.props
  const { getFieldDecorator } = form

  return (
          <AntModal title={title} {...modalProps} onOk={this.handleOk}>
            <Form  layout="horizontal">
              <FormItem {...formItemLayout}>
                {getFieldDecorator('id', {
                  initialValue: item.id,
                })(<Input type='hidden' />)}
              </FormItem>
                            <FormItem label='部门名称' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('name', {
                    initialValue: item.name,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='排序' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('sort', {
                    initialValue: item.sort,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('parentId', {
                    initialValue: item.parentId,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='所属租户' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('tenantId', {
                    initialValue: item.tenantId,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='删除标识（0-正常,1-删除）' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('delFlag', {
                    initialValue: item.delFlag,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='创建时间' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('createTime', {
                    initialValue: item.createTime,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='更新时间' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('updateTime', {
                    initialValue: item.updateTime,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='创建人' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('creator', {
                    initialValue: item.creator,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='修改人' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('updater', {
                    initialValue: item.updater,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>

            </Form>
          </AntModal>
  )
}
}


export default Modal

