package teste;

import dominio.AtributosUsuario;
import dominio.BaseTeste;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RegistrarUsuario extends BaseTeste {

    @Test
    public void registrarUsuarioComSucesso() {
        AtributosUsuario usuario = new AtributosUsuario("janet.weaver@reqres.in","janet.weaver@reqres.in","teste123");
        given()
                .body(usuario)
                .contentType(ContentType.JSON)
        .when()
                .post("/register")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id",is(2))
                .body("token",is(notNullValue()))
        ;
    }
}