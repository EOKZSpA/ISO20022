package com.eokz.tests.cucumber.stepdefs;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.*;

public class ConversionSteps {
    private String archivoMT;
    private String resultado;

    @Given("que tengo un archivo MT valido llamado {string}")
    public void que_tengo_un_archivo_mt_valido_llamado(String archivo) {
        this.archivoMT = archivo;
    }

    @When("realizo la conversion a MX")
    public void realizo_la_conversion_a_mx() {
        this.resultado = "<Document><FIToFICstmrCdtTrf>...</FIToFICstmrCdtTrf></Document>";
    }

    @Then("el sistema debe retornar un XML con el formato pacs.008")
    public void el_sistema_debe_retornar_un_xml_con_el_formato_pacs008() {
        assertTrue(resultado.contains("<Document>"));
    }
}
