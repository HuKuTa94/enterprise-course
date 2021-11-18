#!/bin/bash
set -e

imageTag=$1
if [ -z "$1" ]
  then
    echo No image tag provided. latest will be used
    imageTag=latest
fi
repositoryName=app
imageFullName=$repositoryName:$imageTag

echo [App STARTING] pushing image $imageFullName...

echo [App] pushing image...
docker push $imageFullName

echo [App FINISHED] image $imageFullName pushed
