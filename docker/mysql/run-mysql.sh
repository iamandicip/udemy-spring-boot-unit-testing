#!/bin/bash 
docker pull mysql:8.0 && 
docker run --name udemy-tdd-mysql \
-e MYSQL_ROOT_PASSWORD=example \
-e MYSQL_DATABASE=luv2code \
-e MYSQL_USER=luv2code \
-e MYSQL_PASSWORD=test \
-p 3306:3306 \
-v $HOME/Dev/mysql-data:/var/lib/mysql \
mysql:8.0
