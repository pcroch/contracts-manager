[![Coverage](.github/badges/jacoco.svg)](https://github.com/pcroch/spring-security/actions/workflows/jacoco_badge.yml) [![Coverage](.github/badges/branches.svg)](https://github.com/pcroch/spring-security/actions/workflows/jacoco_badge.yml)

[![.github/workflows/maven.yml](https://github.com/pcroch/spring-security/actions/workflows/build.yml/badge.svg)](https://github.com/pcroch/spring-security/actions/workflows/build.yml)

# Description

This is a default project to have a fast start when I want to develop something on spring boot

Postgres is the db that is run locally in addition with flyway. To run the pipeline, h2 is used

# Initial Set-up

## Postgres

*If not installed check : https://wiki.archlinux.org/title/PostgreSQL*

## Log to postgres:

    sudo -i -u postgres

## Create admin user name admin:

    createuser --interactive 

## Create a db in Postgres with the following command:
    
    createdb db-template

## Check db:

    psql -d db-template

### Spring Boot

## Build the app

    mvn clean install

## Run the app

    mvn spring-boot:run

## Changing the port

In case of conflict with a port you can change the default port 8080 to the desire one in the respecting yml file

### How to fetch:

## Dummy Endpoint:

    curl http://localhost:8080/v1/pingController/ping

## Should respond:

    pingController Ping

# Others

### Getting the application tree

*with depth limit and with files*

    tree -L 5 /path-to-project/IdeaProjects/spring-boot-template/src

*without depth limit and without files*

    tree -d  /path-to-project/IdeaProjects/spring-boot-template/src

## with <u>tree -d</u> we  will have

```
├── main
│   ├── java
│   │   └── api
│   │       └── mywebapp
│   │           ├── commun
│   │           ├── config
│   │           ├── controller
│   │           │   ├── template
│   │           │   │   ├── v1
│   │           │   │   └── v2
│   │           │   └── template2
│   │           │       ├── v1
│   │           │       └── v2
│   │           ├── domain
│   │           ├── dto
│   │           │   ├── template
│   │           │   │   ├── v1
│   │           │   │   └── v2
│   │           │   └── template2
│   │           │       ├── v1
│   │           │       └── v2
│   │           ├── exception
│   │           ├── mapper
│   │           ├── repository
│   │           ├── service
│   │           │   └── impl
│   │           └── utils
│   └── resources
│       └── db 
│           └── migration
└── test
    └── java
        └── api
            └── mywebapp
                ├── commun
                ├── config
                ├── controller
                │   ├── template
                │   │   ├── v1
                │   │   └── v2
                │   └── template2
                │       ├── v1
                │       └── v2
                ├── domain
                ├── dto
                │   ├── template
                │   │   ├── v1
                │   │   └── v2
                │   └── template2
                │       ├── v1
                │       └── v2
                ├── exception
                ├── mapper
                ├── repository
                ├── service
                │   └── impl
                └── utils


```
