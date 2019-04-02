FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-cloud-gateway

WORKDIR /martin-cloud-gateway

EXPOSE 9527

ADD ./martin-cloud/martin-cloud-gateway/target/martin-cloud-gateway.jar ./

ADD ./dockerize /usr/local/bin

ENTRYPOINT dockerize -wait http://martin-cloud-config:9501

CMD && java -Djava.security.egd=file:/dev/./urandom -jar martin-cloud-gateway.jar
