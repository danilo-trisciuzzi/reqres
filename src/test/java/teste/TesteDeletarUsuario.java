package teste;

import dominio.TesteBase;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class TesteDeletarUsuario extends TesteBase {

    private static final String DELETAR_USUARIO_ENDPOINT = "/users/3";

    @Test
    public void deletarUsuarioComSucesso() {
        given()
        .when()
                .delete(DELETAR_USUARIO_ENDPOINT)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT)
        ;
    }
}