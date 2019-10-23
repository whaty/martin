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
                            <FormItem label='用户名' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('username', {
                    initialValue: item.username,
                    rules: [
                      {
                        required: true,
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='密码' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('pwd', {
                    initialValue: item.pwd,
                    rules: [
                      {
                        required: true,
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='随机盐' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('salt', {
                    initialValue: item.salt,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='年纪' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('age', {
                    initialValue: item.age,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='头像' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('avatar', {
                    initialValue: item.avatar,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='邮箱' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('email', {
                    initialValue: item.email,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='签名' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('signature', {
                    initialValue: item.signature,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='头衔' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('title', {
                    initialValue: item.title,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='分类' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('classification', {
                    initialValue: item.classification,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='地址' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('address', {
                    initialValue: item.address,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='电话' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('phone', {
                    initialValue: item.phone,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='部门ID' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('deptId', {
                    initialValue: item.deptId,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='微信openid' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('wxOpenid', {
                    initialValue: item.wxOpenid,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='QQ openid' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('qqOpenid', {
                    initialValue: item.qqOpenid,
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
                        required: true,
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='0-正常，9-锁定' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('lockFlag', {
                    initialValue: item.lockFlag,
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
                <FormItem label='修改时间' hasFeedback {...formItemLayout}>
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

