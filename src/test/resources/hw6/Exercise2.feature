Feature: Exercise 2

Scenario: User Table Page test
  Given I am on Home Page
  When I login as user 'PITER_CHAILOVSKII'
  And Click on 'Service' subcategory in the header
  And I click on 'user-table' button in Service dropdown
  Then 'User Table' page is opened
  And 'NUMBER_USER_TABLE_RECORDS' NumberType Dropdowns are displayed on Users Table on User Table Page
  And 'NUMBER_USER_TABLE_RECORDS' User names are displayed on Users Table on User Table Page
  And 'NUMBER_USER_TABLE_RECORDS' Description images are displayed on Users Table on User Table Page
  And 'NUMBER_USER_TABLE_RECORDS' Description texts under images are displayed on Users Table on User Table Page
  And 'NUMBER_USER_TABLE_RECORDS' checkboxes are displayed on Users Table on User Table Page
  And User table contains following values:
    | Number | User             | Description                      |
    | 1      | Roman            | Wolverine                        |
    | 2      | Sergey Ivan      | Spider Man                       |
    | 3      | Vladzimir        | Punisher                         |
    | 4      | Helen Bennett    | Captain America some description |
    | 5      | Yoshi Tannamuri  | Cyclope some description         |
    | 6      | Giovanni Rovelli | Hulk some description            |
  When I select Vip checkbox for 'Sergey Ivan'
  Then Check that log shows status 'true' for Vip checkbox
  When I click on dropdown in column Type for user 'Roman'
  Then UserType dropdown contains values
  | Dropdown Values |
  | Admin           |
  | User            |
  | Manager         |
