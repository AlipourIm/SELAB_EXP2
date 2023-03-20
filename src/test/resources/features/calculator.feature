@tag
  Feature: Calculator

  Scenario: add two numbers
    Given Two input values, 1 and 2
    When I add the two values
    Then I expect the result 3

  Scenario Outline: add two numbers:
    Given Two input values, <first> and <second>
    When I add the two values
    Then I expect the result <result>

    Examples:
      | first | second  | result  |
      | 1     | 12      | 13      |
      | -1    | 6       | 5       |
      | 2     | 2       | 4       |

  Scenario: test func sqr
    Given Input value 16 and opt "sqr"
    When I run func
    Then I expect the result 4

  Scenario: test invalid input sqr
    Given Input value -16 and opt "sqr"
    When I run func
    Then I expect to get error

  Scenario: test func rvs
    Given Input value 2 and opt "rvs"
    When I run func
    Then I expect the result 0.5


  Scenario: test invalid input rvs
    Given Input value 0 and opt "rvs"
    When I run func
    Then I expect to get error
    
  Scenario Outline: test func
    Given Input value <Input> and opt "<opt>"
    When I run func
    Then I expect the result <result>

    Examples:
      | Input | opt  | result  |
      | 4     | rvs  | 0.25    |
      | 4     | sqr  | 2       |
      | 1     | sqr  | 1       |
      | 1     | rvs  | 1       |
      | 9     | sqr  | 3       |
      | 6     | rvs  | 0.16666 |
      | -5    | rvs  | -0.2    |
