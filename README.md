# Repository for docker lecture in T-Systems java school

Lecture and practice exercises give overview of docker tech stack

## Docker basic

Oerview of docker architecture and basics

## Docker file system and networking

Oerview UFS and networking interface

## Docker image building

Creating docker images


# Tasks

## Before you start
Perform this steps. It'll save time during practice

**1)** Clone repository on your PC

```bash
 git clone https://github.com/parkito/LearnDocker
 ```

**2)** Pull next images on your PC

```bash
 docker pull parkito/hellodocker
 docker pull parkito/layer-server
 docker pull parkito/layer-client
 ```
 
## Commands for hello docker chapter

```bash
docker run docker/whalesay                 // run container from Image. If there is not image on local PC it will be downloaded 

docker run -it ubuntu bash                 // run container in interactive mode (using bash-sehll)

ls /var                                    // using bash-shell of ubuntu container

docker attach ContainerID                  // attache to interactive mode of running container

docker run -d ubuntu apt update            // run container in detach mode

docker ps                                  // observe running containers

docker ps -a                               // observe all containers

docker images                              // observe all local images

docker rm ContainerID                      // delete container

docker rmi ubuntu                          // delete image
 ```
 
 ## Commands for docker layers and networking chapter
 
 ```bash

docker network create myntw                // create new network
 
 docker run -it -p 2141:2141 --name u1  parkito/ubuntu-with-ping bash  // run container with u1 name with exposed 2141 port 
 docker run -it -p 2142:2142 --name u2  parkito/ubuntu-with-ping bash
 
 docker run -it -p 2141:2141 --name u1 --link u2  parkito/ubuntu-with-ping bash    // run container and link it to another
 docker run -it -p 2142:2142 --name u2  parkito/ubuntu-with-ping bash
 
 docker run -it -p 2141:2141 --name u1 --net=myntw parkito/ubuntu-with-ping bash   // run container with myntw network
 docker run -it -p 2142:2142 --name u2 --net=myntw parkito/ubuntu-with-ping bash
 
 docker run -it -v C:\Users\akarnov\Downloads\:/my -p 2142:2142 ubuntu bash    // run container with mounted volume 
 
                          //image inspections
 
 docker history ubuntu     
 docker inspect ubuntu
 
 docker diff ContainerId
 docker inspect ContainerId
  ```
  
 ## Commands for dockerfile chapter
 
  ```bash
 mvn clean package docker:build     //using docker maven plugin
 
 
  // Dockerfile example
 
 FROM openjdk:8-jre-alpine
 RUN mkdir /var/lib/user-service
 COPY /target/user-1.0.jar /var/lib/user-service
 WORKDIR /var/lib/user-service
 EXPOSE 2144
 CMD ["java", "-jar", "user-1.0.jar"] 
   ```