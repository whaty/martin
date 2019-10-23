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
                            <FormItem label='角色名称' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('roleName', {
                    initialValue: item.roleName,
                    rules: [
                      {
                        required: true,
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='角色编码' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('roleCode', {
                    initialValue: item.roleCode,
                    rules: [
                      {
                        required: true,
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='角色描述' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('roleDesc', {
                    initialValue: item.roleDesc,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='数据权限类型' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('dsType', {
                    initialValue: item.dsType,
                    rules: [
                      {
                        required: true,
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='数据权限范围' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('dsScope', {
                    initialValue: item.dsScope,
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
                        required: true,
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

