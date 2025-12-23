# Selenium E2E Automation Framework

This project was created as part of a technical automation case study.

It demonstrates an end-to-end (E2E) UI automation framework built with **Java**, **Selenium WebDriver**, and **JUnit 5**, following the **Page Object Model (POM)** design pattern.

---

## 🛠 Technologies Used

- Java  
- Maven  
- Selenium WebDriver  
- JUnit 5  
- ChromeDriver  
- Apache POI (Excel-driven testing)



## ▶️ Test Execution Overview

- Each test scenario is implemented in its own test class  
  (e.g. `HomePageTest`, `SearchTest`, `MenuNavigationTest`).

- **E2ETestSuite.java**  
  Executes the full end-to-end scenario from start to finish by running all E2E-tagged tests in sequence.

- **E2ERepeatedRunner.java**  
  Runs the entire E2E test suite multiple times to detect flaky behavior and stability issues in dynamic UI flows.

