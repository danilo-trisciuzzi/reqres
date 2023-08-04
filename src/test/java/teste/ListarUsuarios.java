package teste;

import dominio.BaseTeste;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ListarUsuarios extends BaseTeste {

    @Test
    public void buscarTodosUsuariosComSucesso() {
        given()
                .params("page","1")
                .params("per_page","6")
        .when()
                .get("/users")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("page",is(1))
                .body("data[0].id",is(1))
                .body("data",is(notNullValue()))
        ;
    }
}