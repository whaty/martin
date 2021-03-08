FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-extension-monitor

WORKDIR /martin-extension-monitor

EXPOSE 9601

ADD ./martin-extension/martin-extension-monitor/target/martin-extension-monitor.jar ./


