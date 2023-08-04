import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class ListarUsuarios {
    @Test
    public void buscarTodosUsuariosComSucesso() {
        given()
        .when()
                .get("https://reqres.in/api/users")
        .then()
                .log().all()
                //.assertThat()
                //.statusCode(200)
                .statusCode(HttpStatus.SC_OK)
                .body("data[0].id",is(1))
                .body("data",is(notNullValue()))
                //.body("support.url",is("https://reqres.in/#support-heading"))
        ;
    }
}