# ECommerceFinalProject
PROJECT REPORT

ABOUT:

The project implemented the end flow of a real-time e-commerce application. This demo of the e-commerce
application includes all the high-level actions of a real e-commerce application. Here we test this application in
both manual and automated ways.

STEPS TO BE FOLLOWED:

Manual Testing:

• User requirement of the application analysed.

• Check the flow of the application.

• Manual test cases are prepared in the excel sheet with proper test case format.

• On the base of manual test cases defect report was created in the excel sheet.

• Traceability matrix was prepared. The traceability process itself is used to review the test cases that
were defined for any requirement.

• Each test case was prepared module-wise.

TEST STATUS:

Total Test cases : 27
Passed : 18
Failed : 9

Automation Testing:

• Created a maven project with the name ‘EcommerceMasterFinalProject.’

• Added all dependencies required for the project in the pom file.

• Created packages related to the project in the main folder and test folder.

• Added resources package in the main folder for the base class and other files like properties and excel
file.

• Validation of test cases was created in the test folder and page objects of the test cases are created in
the main folder.

• Created XML files for the test cases in the TestNg framework.

• Extends report was created with the help of Listeners. So we get screenshots of the failed test cases
and they will be stored in  the Screenshot folder.

• Integrated with maven so, therefore, we can execute the test from the command prompt.(Regression
and Smoke).

• Integrated with Jenkins tool.

• Project was added in the git hub as a repository

TOOLS USED:

Automation Testing:

• Automation tool : Selenium WebDriver 4.4

• Testing Framework : TestNg 7.6.1

• Programming language : Java

• IDE : Eclipse

• Continues Integration : Jenkins

• Version Control : Git hub

Manual Testing:
• MicrosoftExcel

• MicrosoftWord

PROJECT DURATION : 20 days

CHALLENGES FACED :

1.Synchronizing Events
I faced this issue in accept or confirmation option in the application like add to cart module. So I fixed this issues
with explicit waits but some times script will fail due to this delay.
Exceptions shown in that time:
Session time out exception, No such element exception, Element not visible expection

2.Configuration problem
This will mainly occur due to the old version of the drivers .So avoid that condition I used WebdriverManger class
in the automation script unless the script will be failed. There for we don’t bother about updation of drivers.

3.Cross browser Testing Problem
This application is not performing well at some browser like firefox .I faces test failures when I test with fire fox
browser.

4.Finding of Exact locators
This challenge was faced when that time interact with dynamic elements because the content will be change.
That time go for xpath generated by the site .

5.Some times we need negative test results but we get positive result
I am explained with a test case .I found a bug related to usability in the sign up section .Actually I need fail status,
But I got pass status for that test case because there is no error in the user name requirement. Error is found
in the home page alignment .I fixed this issue with putting assert in the script.
