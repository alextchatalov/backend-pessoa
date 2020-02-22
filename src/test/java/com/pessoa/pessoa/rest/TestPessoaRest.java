package com.pessoa.pessoa.rest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
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
    void novaPessoa() {
        given()
                .relaxedHTTPSValidation()
                .param("nome", "Alex")
                .param("cpf","1111")
                .when()
                .post("/api/v1/novo")
                .then().statusCode(200)
                .contentType(ContentType.JSON)
                .body("message", is("CPF inválido!"));

    }
}
