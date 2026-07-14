# SauceDemo Automation Testing Framework

## Overview

This project is an end-to-end automation testing framework developed using Java, Selenium WebDriver, TestNG, and Maven following the Page Object Model (POM) design pattern.

The framework automates the complete purchase workflow of the SauceDemo web application and demonstrates industry-standard automation testing practices.

---

## Features

- Login Automation
- Product Selection
- Shopping Cart Validation
- Checkout Automation
- Order Confirmation Verification
- Return to Products Navigation
- Page Object Model (POM)
- Driver Factory Pattern
- Base Test Class
- Configurable Test Data using `config.properties`
- Explicit Waits
- Screenshot Capture on Test Failure
- Extent HTML Reports
- Maven Build Management
- TestNG Framework

---

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Extent Reports
- Git
- GitHub

---

## Project Structure

```text
SauceDemoAutomationFramework
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── config
│   │   │   │     ConfigReader.java
│   │   │   │
│   │   │   ├── pages
│   │   │   │     LoginPage.java
│   │   │   │     ProductsPage.java
│   │   │   │     CartPage.java
│   │   │   │     CheckoutPage.java
│   │   │   │     CheckoutCompletePage.java
│   │   │   │
│   │   │   └── utils
│   │   │         DriverFactory.java
│   │   │         WaitUtil.java
│   │   │         ScreenshotUtil.java
│   │   │         ExtentManager.java
│   │   │
│   │   └── resources
│   │         config.properties
│   │
│   └── test
│       ├── java
│       │   ├── base
│       │   │     BaseTest.java
│       │   │
│       │   └── tests
│       │         LoginTest.java
│       │         PurchaseTest.java
│       │
│       └── resources
│
├── reports
├── screenshots
├── pom.xml
├── testng.xml
└── README.md
```

---

## Test Scenarios

### Login Test

- Launch browser
- Navigate to SauceDemo
- Login using valid credentials
- Verify successful login

### End-to-End Purchase Test

- Login
- Add products to cart
- Open shopping cart
- Proceed to checkout
- Enter customer information
- Complete purchase
- Verify successful order
- Return to products page

---

## Framework Design

The framework follows the Page Object Model (POM) design pattern.

### Page Classes

- LoginPage
- ProductsPage
- CartPage
- CheckoutPage
- CheckoutCompletePage

### Utility Classes

- DriverFactory
- ConfigReader
- WaitUtil
- ScreenshotUtil
- ExtentManager

### Base Class

- BaseTest

---

## Reporting

The framework generates HTML reports using Extent Reports.

Report location:

```text
reports/ExtentReport.html
```

The report contains:

- Test execution status
- Execution details
- Exception stack traces
- Screenshot attachment for failed tests

---

## Screenshot on Failure

Whenever a test fails:

- A screenshot is captured automatically.
- The screenshot is attached to the Extent Report.
- Screenshots are stored in:

```text
screenshots/
```

---

## Configuration

Application configuration is managed through:

```text
src/main/resources/config.properties
```

Example:

```properties
url=https://www.saucedemo.com
username=standard_user
password=secret_sauce
browser=chrome
firstname=Robin
lastname=Rosario
zipcode=560001
```

---

## Running the Project

Clone the repository:

```bash
git clone https://github.com/<your-username>/SauceDemo-Automation-Framework.git
```

Navigate to the project directory:

```bash
cd SauceDemo-Automation-Framework
```

Execute all test cases:

```bash
mvn clean test
```

---

## Future Enhancements

- Cross-browser testing
- Parallel test execution
- Data-driven testing using Excel
- Jenkins CI/CD integration
- Docker support
- Allure reporting
- GitHub Actions

---

## Author

Robin V Rosario

Automation Testing Framework developed using Java, Selenium WebDriver, TestNG, Maven, and Extent Reports.