FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-sentinel

WORKDIR /martin-sentinel

EXPOSE 8080

ADD ./sentinel-dashboard-1.8.0.jar ./

ENTRYPOINT ["java","-jar","sentinel-dashboard-1.8.0.jar"]