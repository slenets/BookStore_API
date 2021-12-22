package api;

import com.jayway.restassured.http.ContentType;
import dto.ErrorMessage;
import dto.GenerateTokenResponse;
import dto.User;
import dto.UserAuth;

import static com.jayway.restassured.RestAssured.given;

public class GenerateToken {
    private String token = "GenerateToken";

    public GenerateTokenResponse generateTokenCode200(UserAuth userAuth) {
        return given()
                .contentType(ContentType.JSON)
                .body(userAuth)
                .when()
                .post(token)
                .then().assertThat()
                .statusCode(200)
                .extract()
                .response().as(GenerateTokenResponse.class);
    }

    public ErrorMessage generateTokenCode400(UserAuth userAuth){
        return given()
                .contentType(ContentType.JSON)
                .body(userAuth)
                .when()
                .post(token)
                .then()
                .assertThat()
                .statusCode(400)
                .extract()
                .response()
                .as(ErrorMessage.class);
    }
}
