package teste;

import dominio.BaseTeste;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeletarUsuario extends BaseTeste {

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