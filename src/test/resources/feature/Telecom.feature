Feature: Registar datos de un cliente
  Yo como un usuario de DemoGuru99
  Quiero registrar datos de un cliente
  Para obtener un plan de telecomunicaciones

  Scenario: Cuando registro datos de manera correcta.
    Given La web esta disponible
    When doy click en telecom proyect
    And doy click en agregar cliente
    And ingreso datos de cliente
      | check | nombre   | apellido | email         | direccion | telefono |
      | done  | Leonardo | Col      | test@test.com| Mi casa   | 12374567 |
    And click enviar un formulario
    And capturo el customer del cliente
    And doy click en agregar tarija de customer


  Scenario: Cuando registro datos desde csv
    Given La web esta disponible
    When doy click en telecom proyect
    And doy click en agregar cliente
    And ingreso los datos del cliente desde un csv

  Scenario: Validar mensaje de Alerta.
    Given La web esta disponible
    When doy click en telecom proyect
    And doy click en agregar cliente
    And click enviar un formulario
    Then obtengo el mensaje de Alerta
