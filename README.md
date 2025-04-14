# monefyApp
End-to-End Tests with Cucumber, Appium, and RestAssured (Maven)
This project contains automated end-to-end tests using the Cucumber framework. It includes tests for:

Android Application Testing: Using Appium to interact with and test an Android application.

RESTful API Testing: Using RestAssured to validate API endpoints.

This project uses Maven as the build tool.

## Prerequisites

- Before running the tests, ensure you have the following installed and configured:

- Java Development Kit (JDK): Version 11 or higher.

- Apache Maven: Download and install Maven from https://maven.apache.org/download.cgi.  Make sure the mvn command is available in your system's PATH.

- Android SDK: Required for setting up the Android emulator or connecting a real Android device.

- Appium Server: Install Appium to automate Android interactions. You can install it via npm:

`npm install -g appium
`
- Make sure to set the necessary environment variables for Appium to work (e.g., ANDROID_HOME).

- Node.js and npm: Required for Appium.


### Android Emulator or Real Device:

- If using an emulator, create one using the Android SDK.

- If using a real device, enable USB debugging on your device and connect it to your computer.



## **Setup**

**Clone the Repository:**

git clone https://github.com/vidhyasr25/monefy.git

cd https://github.com/vidhyasr25/monefy.git

**Set up Android Environment (if needed):**

- Ensure your Android emulator is running or your Android device is connected and recognized by adb.

- Verify that the ANDROID_HOME environment variable is set correctly.

**Start Appium Server (if needed):**

- Open a new terminal and start the Appium server:

`appium
`

**Configure Application Under Test (for Android):**

Please install the monefy application on the emulator or on the real device where the test would be run.

**Configure Maven Dependencies:**

Ensure your pom.xml file includes the necessary dependencies similar to the dependencies in pom.xml:

#### Running the Tests

The tests are executed using Maven. Open a terminal in the project's root directory and use the following commands:
To run the entire testsuite
`mvn verify
`
To run specific test or test run based on tags as follows:
- For Mobile tests

 `mvn verify -Dcucumber.filter.tags="@E2E"
`
- For API test run

  `mvn verify -Dcucumber.filter.tags="@E2EAPI"`

Please update the emulator device id with your device id in the feature files in the path "src/test/resources/featureFiles/MonefyBaseActions.feature"

## Reports:

Cucumber reports are generated under the directory target/site/cucumber-pretty.html, with the execution of every test run

Please find the already generated reports on the successful execution earlier with the name as follows
1. cucumber-pretty 3_MobileTests.html
2. cucumber-pretty_MobileAndAPIRun.html
