Feature: Account Page feature

Background: 
Given User is already logged into the application
|username|password|
|japinder.kaur7@gmail.com|Password@1234567890|

Scenario: Accounts Page Title
Given User is on the Accounts Page
When user gets the title of the page
Then page title should be "My Account – ToolsQA Demo Site"

Scenario: Accounts section count
Given User is on the Accounts Page
Then user gets the accounts section
|Dashboard|
|Orders|
|Downloads|
|Addresses|
|Account details|
|Log out|
And Account section count should be 6