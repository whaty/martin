FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-cloud-gateway

WORKDIR /martin-cloud-gateway

EXPOSE 9527

ADD ./target/martin-cloud-gateway.jar ./

