FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-biz-resource

WORKDIR /martin-biz-resource

EXPOSE 9401

ADD ./target/martin-biz-resource.jar ./

