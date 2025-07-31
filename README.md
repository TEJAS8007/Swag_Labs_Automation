# 🧪 Swag Labs Automation Framework

This repository contains a **Test Automation Framework** developed using **Java**, **Selenium**, and **TestNG** to automate the test scenarios of the Swag Labs application.

---

## 🧰 Tech Stack

| Tool/Library         | Description                          |
|----------------------|--------------------------------------|
| Java (1.8+)          | Programming Language                  |
| Selenium WebDriver   | Browser Automation                   |
| TestNG               | Test Management Framework            |
| Apache POI           | Read/Write Excel files               |
| Log4j2               | Logging Mechanism                    |
| Maven                | Build and Dependency Management      |
| Page Object Model    | Design Pattern for Maintainability   |
| Data-Driven Testing  | Read login data from Excel Sheet     |

---

## 📁 Project Structure

Swag_Labs_Automation/
│
├── src/
│ ├── test/java/
│ │ ├── Com.QA.Pages/ # Page Classes (POM)
│ │ ├── Com.QA.tests/ # Test Classes
│ │ └── Com.QA.Utilities/ # Utility & Helper Classes
│ │
│ └── test/resources/
│ ├── Excel_Data/ # Test Data (Excel)
│ └── log4j2.xml # Logging Configuration
│
├── pom.xml # Maven Configuration
├── testng.xml # TestNG Suite
└── README.md # Project Documentation

yaml
Copy
Edit

---

## 🔍 Features

- ✅ Page Object Model (POM)
- ✅ TestNG Annotations (`@BeforeClass`, `@AfterClass`, etc.)
- ✅ Data-Driven Testing with Excel (Apache POI)
- ✅ Logging with Log4j2
- ✅ Screenshot capture on failure
- ✅ Cross-browser support (easily extendable)
- ✅ Configurable via `properties` file

---

## 🚀 How to Run the Tests

### 🔧 Prerequisites

- Java 1.8 or higher
- Maven
- IDE (Eclipse/IntelliJ)
- Chrome or Firefox browser

### ▶️ Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/<your-username>/Swag_Labs_Automation.git
   cd Swag_Labs_Automation
Update the following:

src/test/resources/Excel_Data/ → Add your login test data Excel file.

log4j2.xml for custom log formatting (optional)

Run via Maven

bash
Copy
Edit
mvn clean test
Or Run via TestNG Suite

Right-click on testng.xml → Run As → TestNG Suite

📸 Reports & Screenshots
📂 All logs stored in /logs

📂 Screenshots saved in /ScreenShots on test failures

📂 Test reports generated in /test-output

✍️ Author
Tejas Jayendra Aware
📧 [Email (awaretejas1@gmail.com)]


🙌 Contributing
Feel free to fork this repository and contribute by submitting a pull request. Suggestions and improvements are welcome!


