FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-extension-generator

WORKDIR /martin-extension-generator

EXPOSE 9600

ADD ./martin-extension/martin-extension-generator/target/martin-extension-generator.jar ./

RUN mkdir -p /opt/agent/

ADD ./agent/agent8.4.0.tar.gz /opt/agent/

ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar martin-extension-generator.jar
