package com.eokz.tests.cucumber.stepdefs;

import io.cucumber.java.en.*;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class ConversionApiSteps {
    private String baseUrl;
    private String mensajeMT;
    private Response response;

    @Given("que el servicio de conversion esta disponible en {string}")
    public void que_el_servicio_de_conversion_esta_disponible_en(String url) {
        this.baseUrl = url;
    }

    @Given("tengo el mensaje MT")
    public void tengo_el_mensaje_mt(String mt) {
        this.mensajeMT = mt;
    }

    @When("solicito la conversion a MX")
    public void solicito_la_conversion_a_mx() {
        response = given()
                .header("Content-Type", "text/plain")
                .body(mensajeMT)
                .when()
                .post(baseUrl + "/convert");
    }

    @Then("la respuesta debe tener codigo {int]")
    public void la_respuesta_debe_tener_codigo(Integer codigo) {
        response.then().statusCode(codigo);
    }

    @Then("el XML resultante debe contener {string}")
    public void el_xml_resultante_debe_contener(String contenido) {
        String body = response.getBody().asString();
        assertThat(body, containsString(contenido));
    }
}
