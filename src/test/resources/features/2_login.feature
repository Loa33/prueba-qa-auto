Feature: Registro en ParaBank

  Scenario: Como usuario existente quiero iniciar sesion para acceder a Parabank
    Given Estoy en la pagina de inicio de ParaBank
    When Lleno los datos de login
    And Hago click en el boton Log In
    Then Visualizo los datos de mi cuenta

  Scenario: Como nuevo usuario quiero registrarme para poder acceder a ParaBank
    Given Estoy en la pagina de inicio de ParaBank
    When No lleno los datos de login
    And Hago click en el boton Log In
    Then Visualizo un mensaje de error que dice "Please enter a username and password."

  Scenario: Inicio de sesión fallido con credenciales incorrectas
    Given Estoy en la pagina de inicio de ParaBank
    When Lleno el login con datos incorrectos
    And Hago click en el boton Log In
    Then Visualizo un mensaje de error que dice "The username and password could not be verified."

