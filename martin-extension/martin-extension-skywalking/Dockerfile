FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-extension-skywalking

WORKDIR /martin-extension-skywalking

EXPOSE 9602

ADD ./martin-extension/martin-extension-skywalking/target/martin-extension-skywalking.jar ./


