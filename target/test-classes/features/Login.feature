@Login    @UAT    @smokeTest  @Sprint23.6
Feature: To test login functionality for loblaws website


Background: 
Given Loblaws website is up and running
When User has a internet connection



#this is a test case
@multiplelogin   @login1
Scenario Outline: Test login with multiple credentials
Given user navigates to loblaws website
When user clicked on Sign In
Then user naviagted to login page
Then user enters valid "<email>" and "<password>"
Then user clicks on sign In button
Then user able to do successful login

Examples:
|email|password|var1|var2|var3|
|abc@gmail.com|Test@12345||||
|testing@gmail.com|Test@1278678||||


@smoke   @singleloginwithcorrectdata  @login1
Scenario: Test login with one user credential with hardcoded values user1

Given user navigates to loblaws website
Then user naviagted to login page
Then user enters valid email and password
Then user clicks on sign In button
Then user able to do successful login






