Feature: Conversion MT a MX via API
  Scenario: Convertir un mensaje MT103 a formato pacs.008
    Given que el servicio de conversion esta disponible en "http://localhost:8080"
    And tengo el mensaje MT:
    """
    {1:F01AAAAUS33AXXX0000000000}{2:O1031256050205BBBBGB2LAXXX11112222330502051256N}{4:
      :20:TRX12345678
      :32A:230502USD1000,
      :50K:/12345678
      JOHN DOE
      :59:/87654321
      JANE DOE
      :71A:OUR
      -}
    """
    When solicito la conversion a MX
    Then la respuesta debe tener codigo 200
    And el XML resultante debe contener "<Document>"