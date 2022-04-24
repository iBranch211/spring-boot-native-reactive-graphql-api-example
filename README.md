# Spring Boot Kotlin Native Reactive Graphql Based API with JWT Authentication

Spring Boot Kotlin Native Reactive Graphql Based API Example with JWT Authentication

<img src="https://github.com/susimsek/spring-boot-native-reactive-graphql-api-example/blob/main/images/introduction.png" alt="Spring Boot Kotlin Native Reactive Graphql Based API Example with JWT Authentication" width="100%" height="100%"/> 

# Graphql
GraphQL is a query language and server-side runtime for application programming interfaces (APIs) that prioritizes giving clients exactly the data they request and no more.
GraphQL is designed to make APIs fast, flexible, and developer-friendly. 
It can even be deployed within an integrated development environment (IDE) known as GraphiQL. 
As an alternative to REST, GraphQL lets developers construct requests that pull data from multiple data sources in a single API call.

# Development

Before you can build this project, you must install and configure the following dependencies on your machine.

## Prerequisites for Backend

* Java 17
* GraalVM CE 22(only required for native image build)
* Maven 3.x
* Mongodb

### Run the app

You can run the spring boot app by typing the following command

```sh
mvn spring-boot:run
```

You can build native the spring boot app by typing the following command

```sh
mvn -Pnative -DskipTests package
```

# Sonar

## Code Quality For Backend

You can test code quality locally via sonarqube by typing the following command

```sh
mvn -Psonar initialize sonar:sonar

# Docker

### Native Image Build

The docker image of native application can be built as follows:

```sh
mvn -Prod spring-boot:build-image
```

## Deployment with Docker Compose

You can start native graphql api (accessible on http://localhost:9090/graphiql) with

```sh
 ./deploy.sh -d
```

You can uninstall native graphql api  the following bash command

```sh
 ./deploy.sh -d -r
```

## Deployment Kubernetes with Helm

You can deploy native graphql api by running the following bash command

```sh
 ./deploy.sh -k
```

You can uninstall native graphql api the following bash command

```sh
 ./deploy.sh -k -r
```

You can upgrade native reactive Graphql api (if you have made any changes to the generated manifests) by running the following bash command

```sh
 ./deploy.sh -u
```

The Native Reactive Graphql API can be accessed with ingress from the link below.  
http://spring-native-reactive-graphql-api.susimsek.github.io/graphiql

## Deployment Kubernetes with Helm and Istio

You can deploy native graphql api with istio support by running the following bash command

```sh
 ./deploy.sh -k -i
```

You can uninstall native graphql api the following bash command

```sh
 ./deploy.sh -k -i -r
```

The Native Reactive Graphql API can be accessed with ingress from the link below.  
http://spring-native-reactive-graphql-api.susimsek.github.io/graphiql

# Used Technologies

* Java 17
* Kotlin
* GraalVM
* Mongodb
* Graphql
* GraphiQL
* Docker
* Upx
* Kubernetes
* Helm
* Istio
* Jenkins
* Sonarqube
* Spring Web Flux
* Spring Native
* Spring Graphql
* Spring Security
* Spring Validation
* Spring Actuator
* Jjwt (Jwt Authentication)
* Mapstruct
* Dev tools(dev environment)
