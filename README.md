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
  - Spring Security

## Testing

Used TDD (Test Driven Development).

Unit tests are available in the `src/test` directory.

## Usage

Once the application is running, you can access the API endpoints using tools like cURL, Postman, or your favorite web browser. 
Make sure to replace `localhost:8080` with the appropriate hostname and port if running the application on a different server.

## Endpoints

The following endpoints are available:

- `GET /cashcards/{requestedId}`: Retrieves a specific cash card by ID.
- `POST /cashcards`: Creates a new cash card.
- `GET /cashcards`: Retrieves all cash cards by owner.
- `PUT /cashcards/{requestedId}`: Updates an existing cash card.
- `DELETE /cashcards/{id}`: Deletes a cash card by ID.

## Developments
1) Generated the Spring Boot codebase that will be used for Family Cash Card API by using Spring Initializr.
2) Used TDD to test a JSON data contract and JSON deserialization for the Cash Card service.
3) Created first Family Cash Card REST endpoint: a GET that returns a CashCard of a certain ID using test driven development.
4) Refactored the way the Family Cash Card API manage its data. Spring Data is now creating an in-memory H2 database and loading it with test data.
5) Added POST endpoint to create and save a new CashCard to the database using Spring Data and implementing the HTTP POST specification.
6) Added a GET endpoint for a list implementing pagination and sorting with default behavior.
7) Configured Spring Security Basic Authentication and RBAC-based Authorization to ensure that only authenticated, authorized users have access to the API.
8) Updated Repository to support filtering by the owner and used in Controller to enhance security by ensuring only the correct Cash Card owner can create and own Cash Cards.
9) Added a PUT endpoint that allows an authenticated, authorized owner to update their Cash Card. 
10) Refactored the Controller code without changing its functionality.
11) Added a DELETE endpoint by implementing a hard delete which doesn't reveal information about existing records to unauthorized users.