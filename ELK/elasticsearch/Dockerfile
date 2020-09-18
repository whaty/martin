FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /elasticsearch

WORKDIR /elasticsearch

EXPOSE 9200

ADD ./elasticsearch-6.6.2.tar.gz ./

ADD ./wait-for-it.sh /usr/local/bin
