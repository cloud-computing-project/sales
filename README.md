# RSO: Sales microservice

## Prerequisites

```bash
docker run -d --name sales -e POSTGRES_USER=dbuser -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=order -p 5433:5432 postgres:latest
```

## Run application in Docker

```bash
docker run -p 8083:8083 bozen/sales
```

## Travis status 
[![Build Status](https://travis-ci.org/cloud-computing-project/products.svg?branch=master)](https://travis-ci.org/cloud-computing-project/products)