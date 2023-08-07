package teste;

import dominio.TesteBase;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TestePesquisarUsuario extends TesteBase {

    private static final String PESQUISAR_USUARIO_ENDPOINT = "/users/1";

    @Test
    public void buscarUmUsuarioComSucesso() {
        given()
        .when()
                .get(PESQUISAR_USUARIO_ENDPOINT)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id",is(1))
                .body("data.first_name",is("George"))
                .body("support.url",is(notNullValue()))
        ;
    }
}