FROM nginx:latest

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ADD ./ui/martin-ui.tar.gz /usr/share/nginx/html

ADD ./ui/conf/nginx.conf /etc/nginx/nginx.conf

ADD ./ui/conf/default.conf /etc/nginx/conf.d/default.conf

