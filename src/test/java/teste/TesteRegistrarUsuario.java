package teste;

import dominio.AtributosUsuario;
import dominio.TesteBase;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TesteRegistrarUsuario extends TesteBase {

    private static final String REGISTRAR_USUARIO_ENDPOINT = "/register";

    @Test
    public void registrarUsuarioComSucesso() {
        AtributosUsuario usuario = new AtributosUsuario("janet.weaver@reqres.in","janet.weaver@reqres.in","teste123");
        given()
                .body(usuario)
                .contentType(ContentType.JSON)
        .when()
                .post(REGISTRAR_USUARIO_ENDPOINT)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id",is(2))
                .body("token",is(notNullValue()))
        ;
    }
}