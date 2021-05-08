FROM openjdk:8-jre-alpine
RUN apk --update add curl busybox-extras
ENV TZ=Asia/Shanghai
#此处必加，否则，在验证token时会用于该服务所在jvm与鉴权服务所在jvm时区不一致导致token过期，后面一条命令将java时区设置为Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /home
COPY ./target/web-0.0.1.jar /home

ENTRYPOINT java $JAVA_OPTS -jar /home/web-0.0.1.jar
