#!/bin/bash
set -e

imageTag=$1
if [ -z "$1" ]
  then
    echo No image tag provided. latest will be used
    imageTag=latest
fi

repositoryName=096497308740.dkr.ecr.us-east-2.amazonaws.com/app
imageFullName=$repositoryName:$imageTag

echo [App STARTING] building $imageFullName...

echo [App] creating jar...
(exec "${BASH_SOURCE%/*}/../gradlew" bootJar --no-daemon)

echo [App] creating docker image...
docker build -t $imageFullName ${BASH_SOURCE%/*}

echo [App FINISHED] image has been built
