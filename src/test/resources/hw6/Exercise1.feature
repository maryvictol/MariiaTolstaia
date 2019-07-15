Feature: Exercise 1

  Scenario: Different Elements Page test
    Given I am on Home Page
    When I login as user 'PITER_CHAILOVSKII'
    Then 'Home Page' page is opened
    And Assert User name in the right-top side of screen
    And Check interface on Home page
    When Click on 'Service' subcategory in the header
    Then Check that top drop down contains options
        | SUPPORT            |
        | DATES              |
        | COMPLEX TABLE      |
        | SIMPLE TABLE       |
        | USER TABLE         |
        | TABLES WITH PAGES  |
        | DIFFERENT ELEMENTS |
        | PERFOMANCE         |
    When Click on Service subcategory in the left section
    Then Check that left drop down contains options
        | SUPPORT            |
        | DATES              |
        | COMPLEX TABLE      |
        | SIMPLE TABLE       |
        | USER TABLE         |
        | TABLES WITH PAGES  |
        | DIFFERENT ELEMENTS |
        | PERFOMANCE         |
    When Open through the header menu Service 'different-elements' Page
    Then Check interface on Different elements page
    # TODO On the which page these section is located?
    And Check that there is Right Section
    And Check that there is Left Section
    # TODO It is better to add page name for the these actions
    When I mark 'Water' checkbox on Different Elements page
    Then Check that log shows status 'true' for 'Water' checkbox
    When I mark 'Wind' checkbox on Different Elements page
    Then Check that log shows status 'true' for 'Wind' checkbox
    When Select radiobutton 'Selen' on Different Elements page
    Then Check that log shows that 'metal' change value to 'Selen'
    When Select 'Yellow' in dropdown
    Then Check that log shows that 'Colors' change value to 'Yellow'
    When I mark 'Water' checkbox on Different Elements page
    Then Check that log shows status 'false' for 'Water' checkbox
    When I mark 'Wind' checkbox on Different Elements page
    Then Check that log shows status 'false' for 'Wind' checkbox
