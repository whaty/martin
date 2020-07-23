FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-biz-sso

WORKDIR /martin-biz-sso

EXPOSE 9402

ADD ./target/martin-biz-sso.jar ./

