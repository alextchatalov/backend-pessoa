package com.pessoa.pessoa.rest;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPessoaRest {

    @Before
    public void setup() {
        RestAssured.baseURI = "localhost";
        RestAssured.port = 8080;
    }
    @Order(1)
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
    @Order(2)
    @Test
    void novaPessoaValida() {

        String myJson = "{\"nome\":\"Alex\",\"cpf\": \"13341639012\"}";

        given()
                .contentType("application/json")
                .body(myJson)
                .when()
                .post("/api/v1/novo")
                .then()
                .statusCode(201);
    }

    @Order(4)
    @Test
    void deletarPessoas() {

        String myJson = "{\"nome\":\"Alex\",\"cpf\": \"13341639012\"}";

        given()
                .contentType("application/json")
                .body(myJson)
                .when()
                .get("/api/v1/list")
                .then()
                .statusCode(200);


    }
}
