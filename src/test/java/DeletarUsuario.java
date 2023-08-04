import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class DeletarUsuario {
    @Test
    public void deletarUsuarioComSucesso() {
        given()
        .when()
                .delete("https://reqres.in/api/users/3")
        .then()
                .log().all()
                //.assertThat()
                .statusCode(204)
        ;
    }
}