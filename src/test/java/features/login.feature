Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" site
And Click on login link in home	page to land on secure sign in page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And Close browsers

Examples:
|username           |password |
|test99@gmail.com   |123456   |
|test1234@gmail.com |23456    |
