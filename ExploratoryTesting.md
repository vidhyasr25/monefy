# monefyApp
Exploratory testing observations and Findings

## Observations & Bugs

### Scenario 1: 
_**Issue in navigating back to the main screen from the balance screen display**_

_Severity_
- Major

_Priority_
- High

_Type_
- Functional issue

_Steps to reproduce:_
- Click on the Balance button on the main screen of a specific date, eg., April 12 2025
- Now swipe right to navigate to the previous dates while staying on the same Balance screen
- Minimize or maximise one of the records or Category displayed for the previous date eg., April 10 2025
- Now swipe left to reach the current date April 12, 2025 and tap on the Balance button or the navigation menu icon to return to the main screen

_Expected Result_

User must be navigated to the main screen on tapping the Balance button

_Actual Result_ 

User is not navigated to the main screen and is stuck on the balance screen. When the user clicks on the Date or currency sorting option, then they are taken to the main screen

### Scenario 2:
_**Unable to display the transfer records**_

_Severity_
- Major

_Priority_
- High

_Type_
- UI issue

_Steps to reproduce:_
- User click on the transfer icon to add a new transfer on April 12, 2025
- On the new transfer screen, enter amount 100
- Select the transfer from cash to Card option
- Click on Add transfer option

_Expected Result_

User should be able to see the transfer record and the amount transferred should be deducted from the balance

_Actual Result_

No Transfer record is displayed and the balance is also not updated accordingly with the transfer

### Scenario 3:
_**UI issue in the main screen when a new expense or income record is added

_Severity_
- Low

_Priority_
- Low

_Type_
- UI issue

_Steps to reproduce:_
- User is on the main screen and selects one of the category for expense, eg., Car
- Add the money value as 100 and click on Add car button to add the new expense

_Expected Result_

New expense and the old expense which is already displayed should not be over one another

_Actual Result_

New expense added is displayed over the old expense display(overwritten) in the main screen for few seconds which makes it hard to know the old expense amount


### Risk Mitigation:

- Transfer records aren't updated in the app when all accounts are selected and therefore it displays an incorrect Balance amount which needs to be corrected, if not it displays the wrong budget


