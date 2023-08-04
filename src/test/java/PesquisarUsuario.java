import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class PesquisarUsuario {
    @Test
    public void buscarUmUsuarioComSucesso() {
        given()
        .when()
                .get("https://reqres.in/api/users/1")
        .then()
                .log().all()
                .assertThat()
                .statusCode(200)
                .body("data.id",is(1))
                .body("data.first_name",is("George"))
                .body("support.url",is("https://reqres.in/#support-heading"))
        ;
    }
}