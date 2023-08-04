package teste;

import dominio.AtributosUsuario;
import dominio.BaseTeste;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AutenticarUsuario extends BaseTeste {
    @Test
    public void autenticarUsuarioComSucesso() {
        AtributosUsuario usuario = new AtributosUsuario("janet.weaver@reqres.in","janet.weaver@reqres.in","teste123");
        given()
                .body(usuario)
                .contentType(ContentType.JSON)
        .when()
                .post("/login")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("token",is(notNullValue()))
        ;
    }
}