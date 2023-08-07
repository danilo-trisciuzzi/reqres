package teste;

import dominio.AtributosUsuario;
import dominio.TesteBase;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TesteAutenticarUsuario extends TesteBase {

    private static final String AUTENTICAR_USUARIO_ENDPOINT = "/login";

    @Test
    public void autenticarUsuarioComSucesso() {
        AtributosUsuario usuario = new AtributosUsuario("janet.weaver@reqres.in","janet.weaver@reqres.in","teste123");
        given()
                .body(usuario)
        .when()
                .post(AUTENTICAR_USUARIO_ENDPOINT)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("token",is(notNullValue()))
        ;
    }
}