FROM logstash:7.4.2

MAINTAINER liangcan.jxjy.edu@gmail.com

RUN rm -f /usr/share/logstash/pipeline/logstash.conf

ADD ./logstash/pipeline/ /usr/share/logstash/pipeline/

ADD ./logstash/config/ /usr/share/logstash/config/

CMD sh bin/logstash -f /usr/share/logstash/config/logstash-martin.conf
