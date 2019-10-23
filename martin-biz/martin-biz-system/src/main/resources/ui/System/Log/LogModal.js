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
                            <FormItem label='日志类型' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('type', {
                    initialValue: item.type,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='日志标题' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('title', {
                    initialValue: item.title,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='服务ID' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('serviceId', {
                    initialValue: item.serviceId,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='创建者' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('createBy', {
                    initialValue: item.createBy,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='操作IP地址' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('remoteAddr', {
                    initialValue: item.remoteAddr,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='用户代理' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('userAgent', {
                    initialValue: item.userAgent,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='请求URI' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('requestUri', {
                    initialValue: item.requestUri,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='操作方式' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('method', {
                    initialValue: item.method,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='操作提交的数据' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('params', {
                    initialValue: item.params,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='执行时间' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('time', {
                    initialValue: item.time,
                    rules: [
                      {
                      },
                    ],
                  })(<Input />)}
                </FormItem>
                <FormItem label='异常信息' hasFeedback {...formItemLayout}>
                  {getFieldDecorator('exception', {
                    initialValue: item.exception,
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

