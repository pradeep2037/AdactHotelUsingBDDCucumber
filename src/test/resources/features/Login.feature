Feature: Adact Hotel Login

  Scenario Outline: Verify login with <loginType> credentials

    Given when user is on the Adactin login page
    When user enters the username "<username>"
    And user enters the password "<password>"
    And user clicks the login button
    Then user should see "<expectedResult>"

    Examples:
      | loginType                         | username    | password | expectedResult |
      | Valid username valid password     | pradeep2000 | 1A3VTX   | Adactin.com - Search Hotel |
      | Valid username invalid password   | pradeep2000 | iuiui    | Invalid Login details or Your Password might have expired. Click here to reset your password |
      | Invalid username valid password   | prad        | 1A3VTX   | Invalid Login details or Your Password might have expired. Click here to reset your password |
      | Invalid username invalid password | prad        | uou      | Invalid Login details or Your Password might have expired. Click here to reset your password |
      
      
      
     ppppppppppppppppp
