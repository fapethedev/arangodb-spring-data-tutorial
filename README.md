# ArangoDB Spring Data Tutorial

The course link on ArangoDB University: https://university.arangodb.com/courses/spring-data-tutorial/

In this demo we explain the basic usage of Spring Data ArangoDB with all its key features. The dataset in this demo consists of Game of Thrones characters and locations from the first season. So if you haven’t watched it yet, be aware that there will be spoilers. Our apologies for that.

## Overview

### What you will learn:

- How to set up a demo
- How to perform CRUD operations
- How to search for documents using the query by example API provided by Spring Data
- How to use custom methods in repository interfaces to perform AQL queries without the need of writing them on our own
- How to perform self-written AQL queries within repository interfaces
- How to run geo-spatial queries

### What you need:

- Java 17 or later
- SpringBoot 3.x.x or later
- Maven 3.x or later

#### Maven dependencies

I recommend you to use the latest version of ArangoDB dependencies.
The x.x.x label will serve as placeholder for the latest version.
You could see the versions use for this repository and the one from the course in the pom.xml 

```xml

<dependencies>
    
    <!-- -->
    <dependency>
        <groupId>com.arangodb</groupId>
        <artifactId>arangodb-spring-data</artifactId>
        <version>4.2.0</version>
    </dependency>
    <dependency>
        <groupId>com.arangodb</groupId>
        <artifactId>arangodb-spring-boot-starter</artifactId>
        <version>3.3-0</version>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>

```

After you add the dependencies run the following commands: 

```maven

maven dependency:resolve

```

## WHOAMI

ABIOLA FATIGBA on [LinkedIn](https://linkedin.com/in/abiola-fatigba-a0532a27b) and on [GitHub](https://github.com/fapethedev)

## LICENSE

This project is licensed under the MIT