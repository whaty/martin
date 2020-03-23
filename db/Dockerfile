FROM mysql:5.7

MAINTAINER martin(liangcan.jxjy.edu@gmail.com)

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

COPY ./db/1schema.sql /docker-entrypoint-initdb.d

COPY ./db/2martin.sql /docker-entrypoint-initdb.d

COPY ./db/3martin_ac.sql /docker-entrypoint-initdb.d

COPY ./db/4martin_zipkin.sql /docker-entrypoint-initdb.d

COPY ./db/5nacos_config.sql /docker-entrypoint-initdb.d
