FROM kibana:7.4.2

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN rm -f /usr/share/kibana/config/kibana.yml

ADD ./kibana/config/ /usr/share/kibana/config/

CMD sh bin/kibana
