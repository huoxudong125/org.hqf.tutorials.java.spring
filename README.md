# Spring Boot Examples

This project is a collection of examples demonstrating various features and functionalities of the Spring Framework and Spring Boot. Each module focuses on a specific concept or technology.

## Modules

This project contains the following modules:

*   **`aop`**: Demonstrates Aspect-Oriented Programming (AOP) concepts in Spring, such as defining advice (before, after, around) and pointcuts.
*   **`basic`**: Intended for basic Spring framework examples (currently a placeholder or work in progress).
*   **`el`**: Shows examples of using the Spring Expression Language (SpEL) for bean definition and dynamic value injection.
*   **`jdbc`**: Provides examples of using Spring JDBC for database interactions, including `JdbcTemplate` and data source configuration.
*   **`multi-datasource`**: Illustrates how to configure and use multiple data sources within a single Spring application.
*   **`spring-cachable`**: Demonstrates Spring's caching abstraction, allowing integration with various caching providers.
*   **`transaction`**: Contains examples of declarative transaction management in Spring using `@Transactional` annotation.

## How to Run

Each module in this project is a standard Maven project. To run any of the examples:

1.  Navigate to the root directory of the specific module (e.g., `cd aop`).
2.  Build the project using Maven:
    ```bash
    mvn clean install
    ```
3.  Once built, you can run the main application class from your IDE or use Maven Spring Boot plugin if applicable (for Spring Boot applications):
    ```bash
    mvn spring-boot:run
    ```
    (Note: Not all modules may be Spring Boot applications; some might be plain Java applications or libraries. Check the module's structure and `pom.xml` for specific run instructions if needed.)

Ensure you have Java (JDK) and Maven installed on your system.

## Contributing

Contributions are welcome! If you have an example to add or an improvement to an existing one, please follow these general steps:

1.  **Fork** the repository.
2.  Create a new **branch** for your feature or bug fix.
3.  Make your **changes**.
4.  **Test** your changes thoroughly.
5.  Submit a **Pull Request** with a clear description of your changes.
