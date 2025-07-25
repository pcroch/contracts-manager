[![Coverage](.github/badges/jacoco.svg)](https://github.com/pcroch/spring-security/actions/workflows/jacoco_badge.yml)

[![.github/workflows/maven.yml](https://github.com/pcroch/spring-security/actions/workflows/build.yml/badge.svg)](https://github.com/pcroch/spring-security/actions/workflows/build.yml)

# Description


# Initial Set-up

## H2

you can connect via: http://localhost:8080/h2-console/

Using those settings: 

    org.h2.Driver

    jdbc:h2:file:./contact_manager_db 

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

    tree -L 5 /path-to-project/IdeaProjects/contact-manager/src

*without depth limit and without files*

    tree -d  /path-to-project/IdeaProjects/contact-manager/src
