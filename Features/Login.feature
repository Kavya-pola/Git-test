@BDD-4
Feature: Website login feature execution

	@TEST_BDD-2
	Scenario Outline: Test website functionality
		Given User launch Chrome browser
		When User opens URL "http://admin-demo.nopcommerce.com/login"
		And User enters email as "<email>" and password as "<pwd>"
		And Click on login
		Then Page title should be "Dashboard / nopCommerce administration"
		When User click on Logout link
		Then Page title should be "Your store. Login"
		And Close the browser
		    
		    Examples:
			| email | pwd |
			| admin@yourstore.com | admin |
			
	@TEST_BDD-6
	Scenario Outline: Website login feature fail
		Given User launch Chrome browser
		When User opens URL "http://admin-demo.nopcommerce.com/login"
		And User enters email as "<email>" and password as "<pwd>"
		And Click on login
		Then Page title should be "Dashboard / nopCommerce administration"
		When User click on Logout link
		Then Page title should be "Your store. Login"
		And Close the browser
		    
		    Examples:
			| email | pwd |
			| admin@yourstore.com | admin123 |


			

 
