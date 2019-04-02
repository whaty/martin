FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-cloud-eureka

WORKDIR /martin-cloud-eureka

EXPOSE 9500

ADD ./martin-cloud/martin-cloud-eureka/target/martin-cloud-eureka.jar ./

ADD ./dockerize /usr/local/bin/dockerize

CMD java -Djava.security.egd=file:/dev/./urandom -jar martin-cloud-eureka.jar
