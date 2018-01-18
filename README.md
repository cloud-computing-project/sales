# RSO: Sales microservice

## Prerequisites

```bash
docker run -d --name sales -e POSTGRES_USER=dbuser -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=order -p 5433:5432 postgres:latest
```

## Run application in Docker

```bash
docker run -p 8091:8091 bozen/sales
```

## Travis status 
[![Build Status](https://travis-ci.org/cloud-computing-project/sales.svg?branch=master)](https://travis-ci.org/cloud-computing-project/sales)


## Metrics

[Prometheus Operator](https://coreos.com/operators/prometheus/docs/latest/user-guides/getting-started.html)