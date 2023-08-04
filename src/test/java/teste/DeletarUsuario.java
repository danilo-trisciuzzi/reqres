package teste;

import dominio.BaseTeste;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeletarUsuario extends BaseTeste {
    @Test
    public void deletarUsuarioComSucesso() {
        given()
        .when()
                .delete("/users/3")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT)
        ;
    }
}