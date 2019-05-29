FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-biz-auth-sso

WORKDIR /martin-biz-auth-sso

EXPOSE 9402

ADD ./martin-biz/martin-biz-auth-sso/target/martin-biz-auth-sso.jar ./

ADD ./wait-for-it.sh /usr/local/bin
