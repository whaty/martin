FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-cloud-config

WORKDIR /martin-cloud-config

EXPOSE 9501

ADD ./martin-cloud/martin-cloud-config/target/martin-cloud-config.jar ./

ADD ./wait-for-it.sh /usr/local/bin
