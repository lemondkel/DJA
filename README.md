# DJA

> User performance aggregation web service after 'Baekjoon' user submission crawl using spring-batch.

This web service was developed to calculate how much algorithms have been studied for coding baby birds.

It doesn't mean much, but I made it because I thought it would be fun to check if my friend studied or not.

# Settings
Default Project Database Port 1522 - Oracle
Web Application Server Port - 8085

# How it works

```bash
|____common          # Project Common
|____config          # Spring Config
|____ctrl            # Controller
|____entity          # DB Table Entity
|____job             # Spring Batch
|____repo            # DB Table Repository
|____service         # Service
|SBApplication.java  # SpringBoot Application Main
```

# Getting started

```bash
# maven build
$ mvn clean package

# servce
$ java -jar target/**.war
```