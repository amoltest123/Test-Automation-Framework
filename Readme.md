
# Test Automation Framework

This project is a Java-based Test Automation Framework designed using industry-standard automation testing practices. The framework supports UI test automation, data-driven testing, cloud execution, parallel execution capabilities, detailed reporting, and centralized logging.

The framework is built with maintainability, scalability, and reusability in mind, making it suitable for enterprise-level test automation projects.


## 🚀 About Me
Hi, My Name is Amol Latthe and I have 4.5 Years of experience in Automation Testing using technologies like Selenium WebDriver, RestAssured.

My major experties in Java Programming Language.


## Author
- Amol Latthe
- [@amoltest123](https://github.com/amoltest123)
- EmailAddress: amollattheict@gmail.com


## Tech Stack

**Programming Language:** Java 11



## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/amoltest123)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/amol-latthe-4a5712287/)



## Prerequisites

Before running the framework, ensure the following are installed:

- Software              Version
- **Java**                     11
- **Maven**                   3.8+
- Download Link: https://maven.apache.org/download.cgi


## Features


- Selenium WebDriver based UI automation framework.
- Built using Java 11 and TestNG.
- Data-Driven Testing support using:
  - CSV files (OpenCSV)
  - JSON files (Gson)
  - Excel files (Apache POI)
- Dynamic test data generation using Java Faker.
- Cross-browser execution support.
- Local and LambdaTest cloud execution support.
- Headless browser execution for faster test runs.
- Parameterized execution through Maven CLI.
- Extent Reports integration for detailed HTML reporting.
- Log4j integration for centralized logging.
- Reusable Page Object Model (POM) design.
- Easy configuration management.
- CI/CD ready execution using Maven commands.
- Scalable and maintainable framework architecture.
- Supports parallel execution through TestNG.
- Environment-independent execution.

## Technologies Used

### Core Technologies
- Java 11
- Selenium WebDriver
- TestNG
- Maven

### Data-Driven Testing
- OpenCSV
- Gson
- Apache POI

### Reporting & Logging
- Extent Reports
- Log4j

### Test Data Management
- Java Faker

### Cloud Testing
- LambdaTest

### Framework Design
- Page Object Model (POM)
- Utility-Based Reusable Components

### Version Control
- Git


        
## Installation & Setup

### Prerequisites

Ensure the following software is installed:

- Java 11 or higher
- Maven 3.8+
- Git
- Chrome / Firefox browser

Verify installations:

```bash
java -version
mvn -version
git --version
```

---

### Clone the Repository

```bash
git clone https://github.com/amoltest123/Test-Automation-Framework.git
cd Test-Automation-Framework
```

### Install Dependencies

Maven will automatically download all required dependencies from the `pom.xml`.

```bash
mvn clean install
```

---

### Running Test on LambdaTest:

```bash
    mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X
```

### Running Test on Chrome browser on local machine in headless mode:

```bash
    mvn test -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X
```


## Reports and Logs

The framework generates detailed execution reports and logs to help analyze test results and troubleshoot failures.

## Extent Reports

After every test execution, an HTML report is automatically generated.

**Location:**

```text
reports.html
```

### Report Highlights

- Overall execution summary
- Pass/Fail/Skip statistics
- Individual test execution results
- Execution start and end time
- Test duration
- Step-level execution details
- Exception and error details for failed tests
- Browser and execution environment information

### Viewing the Report

Open the generated `reports.html` file in any web browser to review the execution results.

---

## Log4j Logs

The framework uses Log4j for capturing execution logs throughout the test lifecycle.

**Location:**

```text
logs/
```

### Logged Information

- Framework initialization
- Browser launch and closure
- Test execution flow
- Test start and completion status
- Configuration details
- Warning and error messages
- Exception stack traces

### Sample Log Entries

```text
INFO  - Browser launched successfully: Chrome
INFO  - Starting test: LoginTest
INFO  - User logged in successfully
ERROR - Login validation failed
INFO  - Test execution completed
```

---

## Benefits

- Easy identification of failed test scenarios
- Faster root cause analysis
- Improved debugging and troubleshooting
- Detailed execution history for test runs
- Better visibility into framework behavior

## GitHub Actions Integration

The framework is integrated with **GitHub Actions** to enable automated test execution and continuous validation.

### Scheduled Execution
- Tests are automatically executed every day at **11:30 PM IST** through a scheduled GitHub Actions workflow.
- This helps ensure the application is regularly validated without manual intervention.

### Report Publishing
- After each execution, the generated Extent Report is automatically archived and published to the **`gh-pages`** branch.
- This allows reports to be accessed directly from the GitHub Pages site.

### View Latest Report
The latest test execution report can be viewed here:

🔗 https://amoltest123.github.io/Test-Automation-Framework/report.html

### Benefits
- Automated daily test execution
- Continuous regression validation
- Easy access to execution reports
- No local setup required for report viewing
- Supports CI/CD best practices
