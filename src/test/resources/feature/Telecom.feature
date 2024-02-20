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






