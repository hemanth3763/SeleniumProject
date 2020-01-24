Feature: Checking Cyclos

@Registration
Scenario: Checking the registration 
Given open browser and start application
When enter the required details
Then Registration is successful

@AdminLogin
Scenario: checking the admin login
Given open chrome and start application
When enter the valid admin details
Then admin should login

@Permissions
Scenario: checking the permissions
Given start the application
When admin is loggedin
Then give permission to user

@UserLogin
Scenario: checking the user login
Given start application
When enter the valid user credentials
Then user should login

@Addresschange
Scenario: checking address change
Given open the application
When user is logged in
Then change the address of user

@GrantLoans
Scenario: granting the loans to user
Given run the application
When logged in as admin opened the memberlogin
Then grant the loan
