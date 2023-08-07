package CursoJulioDeLima;

import io.restassured.http.ContentType;
import org.junit.Test;
import static io.restassured.RestAssured.*;

public class ExemploJulioDeLima {

    @Test
    public void testDadoUmAdministradorQuandoCadastroViagensEntaoObtenhoStatusCode201(){
        // Configurar o caminho comum de acesso a minha API rest
        baseURI = "http://localhost";
        port = 8089;
        basePath = "/api";

        //Login na API Rest como admin
        String token = given()
                .body("inserir o corpo da requisição")
                    .contentType(ContentType.JSON)
                .when()
                    .post("/v1/auth")
                .then()
                    .extract()
                        .path("data.token");
        //Cadastrar a viagem
        given()
                .header("Authorization", token)
                .body("corpo da requisição")
                .contentType(ContentType.JSON)
        .when()
                .post("/v1/auth")
        .then()
                .assertThat().statusCode(201);
    }
}

//O ideal é criar uma classe separada para passar os atributos do body nos getters e setters,
// da mesma forma, é interessante fazer mais asserções validando os demais dados do body e não só o status code
//.log().all() - testar para ver como funciona
//Separar os métodos em outras classes, como por exemplo o método do login
//Colocar um before para passar o caminho comum da api