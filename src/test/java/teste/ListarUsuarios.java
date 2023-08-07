package teste;

import dominio.BaseTeste;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ListarUsuarios extends BaseTeste {

    private static final String LISTAR_USUARIOS_ENDPOINT = "/users";

    @Test
    public void buscarTodosUsuariosComSucesso() {
        given()
                .params("page","1")
                .params("per_page","6")
        .when()
                .get(LISTAR_USUARIOS_ENDPOINT)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("page",is(1))
                .body("data[0].id",is(1))
                .body("data",is(notNullValue()))
        ;
    }
}