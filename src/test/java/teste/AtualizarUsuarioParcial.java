package teste;

import dominio.AtributosUsuario;
import dominio.BaseTeste;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AtualizarUsuarioParcial extends BaseTeste {

    @Test
    public void atualizarUsuarioParcialComSucesso() {
        AtributosUsuario usuario = new AtributosUsuario();
        usuario.setJob("zion resident");
        given()
                .body(usuario)
                .contentType(ContentType.JSON)
        .when()
                .put("/users/2")
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("name",is(nullValue()))
                .body("job",is("zion resident"))
        ;
    }
}