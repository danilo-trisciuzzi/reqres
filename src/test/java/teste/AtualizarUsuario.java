package teste;

import dominio.AtributosUsuario;
import dominio.BaseTeste;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class AtualizarUsuario extends BaseTeste {

    private static final String ATUALIZA_USUARIO_ENDPOINT = "/users/2";

    @Test
    public void atualizarUsuarioComSucesso() {
        AtributosUsuario usuario = new AtributosUsuario("Maria","Gerente de Projeto");
        given()
                .body(usuario)
        .when()
                .put(ATUALIZA_USUARIO_ENDPOINT)
        .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("name",is("Maria"))
                .body("job",is("Gerente de Projeto"))
                .body("updatedAt",is(notNullValue()))
        ;
    }
}