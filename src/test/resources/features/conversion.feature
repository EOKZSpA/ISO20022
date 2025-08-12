Feature: Conversion MT a MX
  Scenario: Convertir un archivo MT valido
    Given que tengo un archivo MT valido llamado "mt103.txt"
    When realizo la conversion a MX
    Then el sistema debe retornar un XML con el formato pacs.008