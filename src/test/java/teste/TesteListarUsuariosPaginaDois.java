package teste;

import dominio.TesteBase;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TesteListarUsuariosPaginaDois extends TesteBase {

    private static final String LISTAR_USUARIOS_ENDPOINT = "/users";

    @Test
    public void buscarTodosUsuariosComSucesso() {
        int paginaPesquisada = 1;

        int perPageEsperado = getPerPageEsperado(paginaPesquisada);

        given()
                .params("page",paginaPesquisada)
        .when()
                .get(LISTAR_USUARIOS_ENDPOINT)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("page",is(1))
                .body("data[0].id",is(1))
                .body("data",is(notNullValue()))
                .body("data.size()",is(perPageEsperado))
                .body("data.findAll {it.avatar.startsWith('https://reqres.in')}.size()", is(perPageEsperado))
        ;
    }

    private static int getPerPageEsperado(int page) {
        int perPageEsperado = given()
                .param("page", page)
            .when()
                .get(LISTAR_USUARIOS_ENDPOINT)
            .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .path("per_page");
        return perPageEsperado;
    }
}