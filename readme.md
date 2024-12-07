# E-commerce Application

This is a Spring Boot-based e-commerce application that provides user registration, user activation, and event handling using Kafka as a part of OOAD final project. Below is the information to effectively run this application.

## Features

- User registration
- User activation via OTP
- Event handling with Kafka
- Integration with PostgreSQL database

## Technologies Used

- Spring Boot
- Spring Data JPA
- Spring Kafka
- PostgreSQL
- H2 (for testing)
- Docker
- Maven
- Postman

## Getting Started

### Prerequisites

- Java 17
- Maven
- Docker
- Postman

### Running the Application

1. **Clone the repository:**

   ```sh
   git clone https://github.com/v370r/ecommerce.git
   cd ecommerce


2. **Turn on Docker:**
    ```sh
    docker-compose up -d
    ```
    **Turns On:**
        Postgre,
        ZooKeeper,
        Kafka
    This should look like below
    ![docker](assets\dockerImage.png)

3. **Run Ecommerce Application:**
        Use this [link](https://www.geeksforgeeks.org/how-to-run-spring-boot-application/) to run typical spring boo application.
        Run [this](src/main/java/com/vijay/ecommerce/EcommerceApplication.java) using preferred IDE.

4. **API EndPoints:**
    - Add Product:

    ```sh
    curl --location 'http://localhost:8080/api/products' \
    --header 'Content-Type: application/json' \
    --data '{
        "name": "Sample Product2",
        "description": "This is a sample product.",
        "price": 19.99
    }'
    ```

    - Get Products

    ```sh
    curl --location 'http://localhost:8080/api/products'
    ```

    - EDA:
        - Create User:

        ```sh
        curl --location 'http://localhost:8080/api/users/register' \
        --header 'Content-Type: application/json' \
        --data-raw '{
        "username": "surya1",
        "email": "testuser@example.com",
        "password": "password123"
        }
        '
        ```

        - Activate User:

        ```sh
        curl --location --request POST 'http://localhost:8080/api/users/activate?userId=22&otp=461966' \
        --data ''
        ```

        This opt for a particular user is create once user registers and can be seen in logs.

        ```
        Generated OTP 494677 for user testuser@example.com
        ```

5.  **Common Debugging Issues:**
    - If activationg is failing even with correct otp use kafka off set explorer to see how much lag is present in kafka

     ![offset](assets\offsetExplorer.png)

### License

This project is licensed under the MIT License.