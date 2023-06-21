Feature: Organizer Adding
  As a Developer
  I want to add Organizer through API
  So that It can be available to applications.

  Background:
    Given The Endpoint "http://localhost:%d/api/v1/organizers" is available

  @organizer-adding
  Scenario: Add organizer with unique email
    When A Post Request is sent with values "Isabella Soriano", "IsabellaSH", "isabella@gmail.com"
    Then A Response is received with Status 201
    And An Organizer Resource is included in Response Body, with values "Isabella Soriano", "IsabellaSH, "isabella@gmail.com"

  @organizer-duplicated
  Scenario: Add Organizer with existing email
    Given An Organizer Resource with values "Camila Soriano", "CamilaSH", "camila@gmail.com" is already stored
    When A Post Request is sent with values "Camila Soriano", "CamilaSH", "camila@gmail.com"
    Then A Response is received with Status 400
    And A Message is included in Response Body, with value "Not all constraints satisfied for Organizers: An organizer with the same email already exists."




