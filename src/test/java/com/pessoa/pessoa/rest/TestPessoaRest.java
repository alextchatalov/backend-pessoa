package com.pessoa.pessoa.rest;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class TestPessoaRest {

    @Before
    public void setup() {
        RestAssured.baseURI = "localhost";
        RestAssured.port = 8080;
    }

    @Test
    void novaPessoaInvalida() {

        String myJson = "{\"nome\":\"alex\",\"cpf\": \"1111\"}";

        given()
                .contentType("application/json")
                .body(myJson)
                .when()
                .post("/api/v1/novo")
                .then()
                .statusCode(400)
                .body("message", containsString("CPF inválido!"));
    }

    @Test
    void novaPessoaValida() {

        String myJson = "{\"nome\":\"alex\",\"cpf\": \"13341639012\"}";

        given()
                .contentType("application/json")
                .body(myJson)
                .when()
                .post("/api/v1/novo")
                .then()
                .statusCode(201);
    }
}
