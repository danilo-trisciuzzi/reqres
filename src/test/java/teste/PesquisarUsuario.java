package teste;

import dominio.BaseTeste;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;

public class PesquisarUsuario extends BaseTeste {

    @Test
    public void buscarUmUsuarioComSucesso() {
        given()
        .when()
                .get("/users/1")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id",is(1))
                .body("data.first_name",is("George"))
                .body("support.url",is("https://reqres.in/#support-heading"))
        ;
    }
}