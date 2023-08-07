package teste;

import dominio.AtributosUsuario;
import dominio.BaseTeste;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class AtualizarUsuarioParcial extends BaseTeste {

    private static final String ATUALIZA_USUARIO_ENDPOINT = "/users/2";

    @Test
    public void atualizarUsuarioParcialComSucesso() {
        AtributosUsuario usuario = new AtributosUsuario();
        usuario.setJob("Analista Senior");
        given()
                .body(usuario)
        .when()
                .put(ATUALIZA_USUARIO_ENDPOINT)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("name",is(nullValue()))
                .body("job",is("Analista Senior"))
        ;
    }
}