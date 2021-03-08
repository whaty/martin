FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-biz-swagger

WORKDIR /martin-biz-swagger

EXPOSE 9403

ADD ./martin-biz/martin-biz-swagger/target/martin-biz-swagger.jar ./


