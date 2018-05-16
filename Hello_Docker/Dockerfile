FROM alpine:3.7
MAINTAINER Artem Karnov

RUN apk add --update \
    python3 \
    python3-dev \
    py-pip \
    build-base \
    openjdk8-jre \
  && pip install virtualenv \
&& rm -rf /var/cache/apk/*

RUN mkdir /var/lib/app
WORKDIR /var/lib/app

COPY HelloJava.class /var/lib/app
COPY HelloPython.py /var/lib/app

CMD java HelloJava && python HelloPython.py
