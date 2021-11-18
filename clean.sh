#!/bin/bash
echo Cleaning containers and images...
docker rm $(docker ps -a -f status=exited -q)
docker rm $(docker ps -a -f status=created -q)
docker rmi $(docker images -a)
