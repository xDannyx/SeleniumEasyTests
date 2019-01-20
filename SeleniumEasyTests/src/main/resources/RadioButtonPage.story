Narrative:
As a user
I want to go onto seleniumeasy website
So that I can test some pages

Scenario: Chceck male radio button
Given user is on RadioButtonPage
When user checks male button
And user clicks Get Checked Value button
Then result for male should be correct

Scenario: Check female radio button
Given user is on RadioButtonPage
When user checks female button
And user clicks Get Checked Value button
Then result for male should be correct