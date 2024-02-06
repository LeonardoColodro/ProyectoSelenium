Feature: Comprar articulo con una tarjeta de Credito
  Yo como un usuario de DemoGuru99
  Quiero comprar un articulo con una tarjeta de credito
  Para ahorrar tiempo en hacer un tramite personal

  Scenario: Cuando no hay transacciones de Tarjeta
    Given la pagina esta estable
    When doy click en generar tarjeta
    And capturamos datos de la tarjeta
    And capturamos el cvv de la tarjeta
    And capturamos la fecha de la tarjeta
    And capturamos el monto disponible de la tarjeta
    When doy click en Check Credit
    And ingreso el dato de la tarjeta y doy click
    Then Puedo capturar los mensajes del balance de tarjeta "Check Credit Balance"
    And capturo el mensaje de "This Card Not Any Transactions"

  Scenario: Cuando compro una sola vez
    Given la pagina esta estable
    When doy click en generar tarjeta
    And capturo datos de tarjeta
    And capturo el monto del producto
    And ingreso la cantidad "4"
    And doy click en agregar
    And valido datos de Tarjeta
    Then Valido el pago exitoso "Payment successfull!"
    And Capturo el numero de orden
    And doy click
    And valido Mensaje Home "Mother Elephant With Babies Soft Toy"

  Scenario Outline: Cuando compro varias veces con cantidades validas
    Given la pagina esta estable
    When doy click en generar tarjeta
    And capturo datos de tarjeta
    And capturo el monto del producto
    And ingreso la cantidad "<cantidad>"
    And doy click en agregar
    And valido datos de Tarjeta
    Then Valido el pago exitoso "Payment successfull!"
    And Capturo el numero de orden
    And doy click
    And valido Mensaje Home "Mother Elephant With Babies Soft Toy"
    Examples:
      | cantidad |
      | 1        |
      | 9        |

  Scenario Outline: Cuando compro con cantidad invalida
    Given la pagina esta estable
    When doy click en generar tarjeta
    And capturo datos de tarjeta
    And capturo el monto del producto
    And ingreso la cantidad "<cantidad>"
    Examples:
      | cantidad |
      | 0        |
      | 10       |

  Scenario: Validar saldo de tarjeta
    Given la pagina esta estable
    When doy click en generar tarjeta
    And capturo datos de tarjeta
    And capturo el monto del producto
    And ingreso la cantidad "4"
    And doy click en agregar
    And valido datos de Tarjeta
    And Capturo el numero de orden
    And doy click y voy a check credit
    And ingreso el dato de la tarjeta y doy click
    Then Puedo capturar los mensajes del balance de tarjeta "Check Credit Balance"
    And valido que la tarjeta sea correcta

