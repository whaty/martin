FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-biz-system

WORKDIR /martin-biz-system

EXPOSE 9404

ADD ./target/martin-biz-system.jar ./

