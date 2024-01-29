Feature: Comprar articulo con una tarjeta de Credito
  Yo como un usuario de DemoGuru99
  Quiero comprar un articulo con una tarjeta de credito
  Para ahorrar tiempo en hacer un tramite personal

  Scenario: Comprar un solo producto
    Given la pagina esta estable
    When doy click en generar tarjeta
    And capturamos datos de la tarjeta
    And capturamos el cvv de la tarjeta
    And capturamos la fecha de la tarjeta
    And capturamos el monto disponible de la tarjeta
    When doy click en Check Credit
