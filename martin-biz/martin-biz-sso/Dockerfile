FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-biz-sso

WORKDIR /martin-biz-sso

EXPOSE 9402

ADD ./martin-biz/martin-biz-sso/target/martin-biz-sso.jar ./

RUN mkdir -p /opt/agent/

ADD ./agent/agent8.4.0.tar.gz /opt/agent/

ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar martin-biz-sso.jar
