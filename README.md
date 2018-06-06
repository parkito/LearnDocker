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