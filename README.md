Here's a README file for your project, explaining its purpose and highlighting how SOLID principles are applied throughout the code.

---

# Atid Store Automation Tests

## Overview

This project consists of automated tests for the Atid Store website using Selenium WebDriver and JUnit 5. The tests simulate user interactions such as browsing products, adding items to the cart, and completing the checkout process. The goal is to ensure the website functions correctly and meets user expectations.

## Project Structure

The project is organized into several packages:

- **pages**: Contains classes representing different pages of the Atid Store, encapsulating page-specific actions and elements.
- **utils**: Contains utility classes for browser management and logging.
- **lifeCycle**: Manages the test lifecycle and logging of test results.
- **tests**: Contains the main test class that orchestrates the test execution.

## Installation

1. Clone the repository.
2. Ensure you have Java and Maven installed.
3. Open the project in your favorite IDE.
4. Install the necessary dependencies by running `mvn install`.

## Running Tests

To execute the tests, run the following command in your terminal:

```bash
mvn test
```

## SOLID Principles

The project adheres to the SOLID principles, which promote good software design and maintainability. Here’s how they are reflected in the code:

### 1. **Single Responsibility Principle (SRP)**

Each class in the project has a single responsibility:

- **Page Classes**: Each page class (e.g., `StoreHomePage`, `ProductPage`) is responsible for interacting with specific elements and actions on that page.
- **DriverChrome**: Manages browser-related operations, allowing for easier modifications and testing without affecting other parts of the application.

### 2. **Open/Closed Principle (OCP)**

The design allows for easy extension without modifying existing code:

- Adding new pages or functionalities can be done by creating new classes that extend existing interfaces (e.g., `BasicBrowser` or `WindowManagement`), rather than altering existing code.

### 3. **Liskov Substitution Principle (LSP)**

The project uses interfaces effectively:

- Interfaces like `BasicBrowser` and `WindowManagement` ensure that any class implementing these interfaces can be used interchangeably without altering the expected behavior.

### 4. **Interface Segregation Principle (ISP)**

Interfaces are designed to be specific to the needs of the classes implementing them:

- The `BasicBrowser` interface provides only the necessary methods for browser operations, avoiding bloated interfaces that require implementing unused methods.

### 5. **Dependency Inversion Principle (DIP)**

High-level modules do not depend on low-level modules but rather on abstractions:

- The test classes depend on abstractions (interfaces) rather than concrete implementations (e.g., `WebDriver`). This allows for more flexible and testable code.

## Conclusion

The Atid Store automation tests provide a robust framework for verifying the functionality of the website. By adhering to the SOLID principles, the code is modular, maintainable, and adaptable to changes in the website or testing requirements.

---
