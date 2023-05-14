# Sum of primes upto 10 million

This is a Spring Boot Java based application that calculates the sum of all prime numbers up to 10 million. 

## Requirements

This is a standard Maven project, so just run `mvn clean install` and the project will be compiled and the tests will run.

To build and run this application, you will need:

- Java JDK 17
- Maven 3

## Getting Started

To get started with this application, clone the repository to your local machine:

```
git clone https://github.com/reesharammohan/sum-of-primes
```

Build the project:

```
mvn clean install
```

From the project base directory you can run `mvn spring-boot:run` or you can run from the IDE which will start the application on `http://localhost:8080`

## Usage

Once the application is running, you can access it using your web browser or a tool like Postman. The project is configured with swagger and can be accessed using `http://localhost:8080/swagger-ui.html`

### Endpoint

The endpoint 'GET/sumOfPrimes' takes an input and returns the sum of all prime numbers. Values up to 10 million can be entered. The response will be in JSON format:

```
{
  "message": "Sum Value calculated successfully!",
  "result": 3682913
}
```
