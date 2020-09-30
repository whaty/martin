FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-cloud-nacos

WORKDIR /martin-cloud-nacos

EXPOSE 8848
EXPOSE 6666

ADD ./nacos ./

