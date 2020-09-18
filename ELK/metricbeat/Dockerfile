FROM elastic/metricbeat:7.4.2

ADD ./metricbeat/metricbeat.yml /usr/share/metricbeat/metricbeat.yml

USER root

RUN chown root:metricbeat /usr/share/metricbeat/metricbeat.yml

USER metricbeat
