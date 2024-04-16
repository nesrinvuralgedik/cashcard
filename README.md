# Family Cash Card API

## Description
A RESTful API with Spring Boot for a Family Cash Card application to manage allowance for their kids. It's very similar to a gift card.

## Prerequisites
Before running this application, ensure that you have the following prerequisites installed:

- Java JDK 17 or later
- Gradle - Groovy

## Features
It is built with Gradle and includes the following dependencies:
  - Spring Web
  - Spring Data JDBC
  - H2 Database 

## Testing
Unit tests are available in the `src/test` directory.

## Usage

Once the application is running, you can access the API endpoints using tools like cURL, Postman, or your favorite web browser. 
Make sure to replace `localhost:8080` with the appropriate hostname and port if running the application on a different server.

## Endpoints

The following endpoints are available:

- `GET /cashcards/{requestedId}`: Retrieves a specific cash card by ID.

## Developments
1) Generated the Spring Boot codebase that will be used for Family Cash Card API by using Spring Initializr.
2) Used TDD to test a JSON data contract and JSON deserialization for the Cash Card service.
3) Created first Family Cash Card REST endpoint: a GET that returns a CashCard of a certain ID using test driven development.
4) Refactored the way the Family Cash Card API manage its data. Spring Data is now creating an in-memory H2 database and loading it with test data.