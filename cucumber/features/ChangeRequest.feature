Feature: Incident Managenment

#Background:
#Given set up the endpoint
#And set up the Authentication

Scenario: Place a post Request without body

And set the Content Type
When place the post request
Then verify the status code as 201
And verify the Content type as json


#Scenario: Place a post Request with body
##And set the Content Type
#When place the post request as ./data/CreateIncident1.json
#Then verify the status code as 201
#And verify the Content type as json


Scenario Outline: Place a post Request with body

And set the Content Type
When place the post request as <FilePath>
Then verify the status code as 201
And verify the Content type as json

#Row and Column
Examples:
|FilePath|
# 1st Row
|1|
# 2nd Row
|2|
|3|

















