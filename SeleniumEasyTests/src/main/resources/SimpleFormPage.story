Narrative:
As a user
I want to go onto seleniumeasy website
So that I can test some pages

Scenario: Input message
Given user is on SimpleFormDemoPage
When user writes something
And user clicks Show Message button
Then result should be same as user phrase

Scenario: Adding two values
Given user is on SimpleFormDemoPage
When user filss a and b
And user clicks Get Total button
Then result should equals exactly same