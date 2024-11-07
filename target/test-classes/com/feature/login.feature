@loginPage
Feature: To validate the login page of facebook application

@validData
Scenario: To validate user should be on home page with login credentials
	Given open any browser
	And enter the application url
	And locate email textbox and enter email "poojajamble10@gmail.com"
	And locate password textbos and enter password "Pooja@2207"
	When locate login button and click on it
	Then validate user should be on "Facebook"
	And close the browser
	
@invalidData	
Scenario Outline: To validate user should be on login page with invalid login credentials
	Given open any browser
	And enter the application url
	And locate email textbox and enter email "<email>"
	And locate password textbos and enter password "<password>"
	When locate login button and click on it
	Then validate user should be on "Log in to Facebook"
	And close the browser
	Examples:
	|     testName			|         email					|password  |
	|Both are empty			|												|          |
	|Email is empty     |												|Pooja@2207|
	|Password is empty  |poojajamble10@gmail.com|					 |
	|Both are invalid   |poojajamble@gmail.com	|Pooja@123 |
	|Email is invalid   |poojajamble@gmail.com	|Pooja@2207|
	|Password is invalid|poojajamble10@gmail.com|Pooja@123 |