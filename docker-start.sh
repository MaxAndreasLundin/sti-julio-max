#!/usr/bin/env bash

docker run --rm -p 8080:8080 -e DB_HOST=host.docker.internal --name stijm stijm