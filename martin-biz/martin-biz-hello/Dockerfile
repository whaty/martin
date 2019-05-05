FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-biz-hello

WORKDIR /martin-biz-hello

EXPOSE 9600

ADD ./martin-biz/martin-biz-hello/target/martin-biz-hello.jar ./

ADD ./wait-for-it.sh /usr/local/bin
