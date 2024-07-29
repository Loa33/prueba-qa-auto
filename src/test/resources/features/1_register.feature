Feature: Registro en ParaBank

  Background:
    Given Estoy en la pagina de inicio de ParaBank
    And Hago click en el link Register
    And Soy redirigido a la pagina de registro

  Scenario: Como nuevo usuario quiero registrarme para poder acceder a ParaBank
    When Lleno el formulario de registro con mis datos
      | Campo      | Value                    |
      | First Name | Loana                    |
      | Last Name  | Test                     |
      | Address    | Direccion de prueba #123 |
      | City       | Trujillo                 |
      | State      | Trujillo                 |
      | Zip Code   | 13006                    |
      | Phone #    | 999888777                |
      | SSN        | 45637823                 |
    And Hago click en el boton Register
    Then Visualizo un mensaje que dice "Your account was created successfully. You are now logged in."


  Scenario Outline: Intento de registro fallido debido a un campo obligatorio vacio
    When Lleno el formulario de registro excepto el campo "<Campo>"
      | Field                 | Value                    |
      | First Name            | Loana                    |
      | Last Name             | Test                     |
      | Address               | Direccion de prueba #123 |
      | City                  | Trujillo                 |
      | State                 | Trujillo                 |
      | Zip Code              | 13006                    |
      | Phone #               | 999888777                |
      | SSN                   | 45637823                 |
      | Username              | user                     |
      | Password              | passw0rd                 |
      | Password Confirmation | passw0rd                 |
    And Hago click en el boton Register
    Then Visualizo un mensaje de error que dice "<MensajeError>"
    Examples:

      | Campo                 | MensajeError                        |
      | First Name            | First name is required.             |
      | Last Name             | Last name is required.              |
      | Address               | Address is required.                |
      | City                  | City is required.                   |
      | State                 | State is required.                  |
      | Zip Code              | Zip Code is required.               |
      | SSN                   | Social Security Number is required. |
      | Username              | Username is required.               |
      | Password              | Password is required.               |
      | Password Confirmation | Password confirmation is required.  |

  Scenario: Intento de registro fallido debido a que la contraseña de confirmación no coincide
    When Lleno el formulario de registro con contraseña de confirmación no coincidente
      | Campo      | Value                    |
      | First Name | Loana                    |
      | Last Name  | Test                     |
      | Address    | Direccion de prueba #123 |
      | City       | Trujillo                 |
      | State      | Trujillo                 |
      | Zip Code   | 13006                    |
      | Phone #    | 999888777                |
      | SSN        | 45637823                 |
    And Hago click en el boton Register
    Then Visualizo un mensaje de error que dice "Passwords did not match."

