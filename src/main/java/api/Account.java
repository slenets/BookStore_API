package api;

import com.jayway.restassured.http.ContentType;
import dto.ErrorMessage;
import dto.UserAuth;

import static com.jayway.restassured.RestAssured.given;

public class Account {
    private  String AUTHORIZED = "Authorized";

    public boolean authorizedCode200(UserAuth userAuth) {
       return given()
                .contentType(ContentType.JSON)
                .body(userAuth)
                .when()
                .post(AUTHORIZED)
                .then()
                .assertThat().statusCode(200)
               .extract().response().as(Boolean.class);
    }

    public ErrorMessage authorizedCode400(UserAuth userAuth){
        return given()
                .contentType(ContentType.JSON)
                .body(userAuth)
                .when()
                .post(AUTHORIZED)
                .then()
                .assertThat().statusCode(400)
                .extract()
                .response().as(ErrorMessage.class);
    }

    public ErrorMessage authorizedCode404(UserAuth userAuth){
        return given()
                .contentType(ContentType.JSON)
                .body(userAuth)
                .when()
                .post(AUTHORIZED)
                .then()
                .assertThat().statusCode(404)
                .extract()
                .response().as(ErrorMessage.class);
    }

}
