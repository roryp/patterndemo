# Realiable Web App Demo

## Description

This project is a Java-based web application that provides a RESTful API for managing products. It uses Spring Boot for the backend, and includes features such as retrieving a product by its ID.

The project also includes automated tests using JUnit and Mockito, ensuring the reliability and correctness of the application.

To manage the cache, the project employs various patterns such as cache-aside. The cache is implemented using the Caffeine library.

For improving the system's reliability, the project uses resiliency patterns such as circuit breaker.


## Installation

1. Clone the repository:

```bash
git clone https://github.com/roryp/patterndemo.git
```

2. Navigate to the project directory:

```bash
cd your-repo-name
```

3. Install dependencies:

```bash
mvn clean install
```

## Usage

```bash
mvn spring-boot:run
```

You can then access the API at http://localhost:8080.


## Running the tests

To run the automated tests for this system, use the following command:

```bash
mvn test
```

