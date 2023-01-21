Feature: Login

Background:

When User opens url "https://admin-demo.nopcommerce.com/login"

@Smoke
Scenario: Successfull Login with Valid credentials

And  User enters Email as "admin@yourstore.com" and password as "admin"
And Click on Login
Then Home Page title should be "Dashboard / nopCommerce administration"
When User click on logout button
Then Login Page tilte should be "Your store. Login"




Scenario Outline: Successfull Login with Valid credentials

And  User enters Email as "<email>" and password as "<password>"
And Click on Login
Then Home Page title should be "Dashboard / nopCommerce administration"
When User click on logout button
Then Login Page tilte should be "Your store. Login"

Examples:
|email|password|
|admin@yourstore.com|admin|
|admin@yourstore.com|admin|




