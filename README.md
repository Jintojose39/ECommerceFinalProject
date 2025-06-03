# 🛒 E-Commerce Application Testing Framework

## 📌 Project Overview

This project demonstrates end-to-end testing for an **e-commerce web application**, automating various user flows using **Selenium WebDriver** and the **TestNG** framework. The project integrates with **Jenkins** for CI/CD, uses **Log4j** for logging, and generates **ExtentReports** for rich test reporting.

---

## 🗂️ Project Structure

# Project documentation

EcommerceMasterFinalProject/
├── .settings/
├── src/
│ ├── main/java/
│ └── test/java/
├── reports/
├── Screenshots/
├── test-output/
├── junitreports/
├── old/
├── runner/
├── target/
├── *.properties
├── *.xml
├── testng.xml
├── pom.xml
├── .classpath
├── .project
├── geckodriver.exe
├── msedgedriver.exe
├── README.md


### Explanation of folders and files:

- `.settings/` — Eclipse settings  
- `src/main/java/` — Page Objects, base classes, utils, listeners  
- `src/test/java/` — Test case implementations  
- `reports/` — ExtentReport outputs  
- `Screenshots/` — Captured screenshots of failed test cases  
- `test-output/` — Default TestNG reports  
- `junitreports/` — JUnit style reports  
- `old/`, `runner/`, `target/` — Old artifacts, runner files, and build outputs  
- `*.properties` — Test data and config files  
- `*.xml` — TestNG XML suite files  
- `testng.xml` — Master TestNG configuration  
- `pom.xml` — Maven dependencies and build config  
- `.classpath`, `.project` — Eclipse project config files  
- `geckodriver.exe`, `msedgedriver.exe` — Browser driver executables  
- `README.md` — Project documentation  



---

## 🛠️ Tech Stack

| Category              | Tool/Tech                          |
|-----------------------|------------------------------------|
| Programming Language  | Java                               |
| Automation Tool       | Selenium WebDriver 4.4             |
| Test Framework        | TestNG 7.6.1                       |
| Reporting             | ExtentReports + TestNG Reports     |
| Logging               | Log4j                              |
| CI/CD Integration     | Jenkins                            |
| Build Tool            | Maven                              |
| IDE                   | Eclipse                            |
| Version Control       | GitHub                             |
| Manual Testing Docs   | Microsoft Excel, Word              |

---

## 🧪 Testing Approach

### ✅ Manual Testing

- Requirements were reviewed and test cases were created in Excel.
- Defects were logged in a defect sheet.
- Traceability Matrix created to map requirements to test cases.
- Total Test Cases: 27  
  - ✅ Passed: 18  
  - ❌ Failed: 9

### 🤖 Automation Testing

- Structured using **Page Object Model (POM)**.
- Test validations reside under `src/test/java`.
- Page classes and utility functions are under `src/main/java`.
- **TestNG XMLs** control modular test execution:
  - `EcommerceEndFlow.xml`
  - `ErrorValidationTestCases.xml`
  - `HomePageValidation.xml`
- Logging enabled via **Log4j**.
- Reports generated via:
  - **ExtentReports** (HTML)
  - **TestNG Default Reports**
  - Screenshots stored under `/Screenshots` for failed tests
- Browser drivers included (`geckodriver.exe`, `msedgedriver.exe`)
- Maven integrated (`pom.xml`) for dependency management and CLI execution:
  
```bash
mvn clean test

🔁 Jenkins Integration
Project is integrated with Jenkins for CI/CD:

Pulls latest code from GitHub

Builds using Maven

Runs TestNG test suites (via XMLs)

Publishes HTML reports and screenshots

Supports Regression and Smoke testing pipelines


📈 Reporting & Logs
📄 Extent HTML Report: /reports/ExtentReport.html

📸 Failed Screenshots: /Screenshots/

🧾 TestNG Reports: /test-output/, emailable-report.html

📘 Log Files: Custom logs via Log4j saved to /logs/


⚠️ Known Challenges
Synchronization Issues

Used explicit waits, but some failures due to late DOM loads

Cross-browser Compatibility

Firefox rendering issues resolved partially

Dynamic Locators

Used XPath and smart locator strategies

False Positives

Fixed by tightening assertions and logging

Driver Issues

Resolved using WebDriverManager where applicable

✅ To Run the Project
Using Maven:
mvn clean test -DsuiteXmlFile=EcommerceEndFlow.xml


From Jenkins:
Configure Maven job

Set Git repo

Add build step:
mvn clean test -DsuiteXmlFile=EcommerceEndFlow.xml

🔗 Repository
📁 GitHub: https://github.com/your-username/EcommerceMasterFinalProject

📌 Author
Your Name
Test Automation Engineer
Email: jintojose39@gmail.com
LinkedIn: https://www.linkedin.com/in/jinto-jose-b83701153/


---

Let me know if you want this saved as a downloadable `.md` or `.docx` file, or tailored to any team/organization guidelines.
