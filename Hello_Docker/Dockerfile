FROM ubuntu:16.04
MAINTAINER Artem Karnov

ENV DEBIAN_FRONTEND noninteractive
ENV LANG=en_US.UTF-8

RUN apt-get update && \
  apt-get upgrade -y && \
  apt-get install -q -y openjdk-8-jdk python3-pip libsnappy-dev language-pack-en supervisor

RUN pip3 install --upgrade pip requests

RUN mkdir /var/lib/app
WORKDIR /var/lib/app

COPY HelloJava.class /var/lib/app
COPY HelloPython.py /var/lib/app

CMD ["java", "HelloJava"]
CMD ["python", "HelloPython.py"]
