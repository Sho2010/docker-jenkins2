FROM jenkinsci/jenkins:2.13

MAINTAINER Sho2010 "sho20100@gmail.com"

COPY plugins.txt /usr/share/jenkins/plugins.txt
COPY custom.groovy /usr/share/jenkins/ref/init.groovy.d/custom.groovy

RUN /usr/local/bin/plugins.sh /usr/share/jenkins/plugins.txt

