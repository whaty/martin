FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-sentinel

WORKDIR /martin-sentinel

EXPOSE 9604

ADD ./sentinel/sentinel-dashboard-1.8.0.jar ./

ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar sentinel-dashboard-1.8.0.jar
