
Feature: Login page feature

Scenario: Login Page Title
Given user is on login page
When user gets the title of the page
Then page title should be "My Account – ToolsQA Demo Site"

Scenario: Forgot password link
Given user is on login page
Then forgot password link should be displayed

Scenario: Login with correct credentials
Given user is on login page
When user enters username "japinder.kaur7@gmail.com"
And user enters password "Password@1234567890"
And user clicks on Login button
Then user gets sees Dashboard link
