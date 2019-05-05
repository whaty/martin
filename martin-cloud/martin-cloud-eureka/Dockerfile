FROM anapsix/alpine-java:8_server-jre_unlimited

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /martin-cloud-eureka

WORKDIR /martin-cloud-eureka

EXPOSE 9500

ADD ./martin-cloud/martin-cloud-eureka/target/martin-cloud-eureka.jar ./

ADD ./wait-for-it.sh /usr/local/bin

CMD java -Djava.security.egd=file:/dev/./urandom -jar -Xms128m -Xmx256m -XX:PermSize=128m -XX:MaxPermSize=256m martin-cloud-eureka.jar
