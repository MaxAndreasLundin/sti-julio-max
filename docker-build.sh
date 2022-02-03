#!/usr/bin/env bash

./mvnw clean install
docker build -t stijm .
