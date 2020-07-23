FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-biz-auth

WORKDIR /martin-biz-auth

EXPOSE 9400

ADD ./target/martin-biz-auth.jar ./

