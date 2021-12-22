import api.Account;
import com.jayway.restassured.RestAssured;
import dto.ErrorMessage;
import dto.UserAuth;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountTest extends TestBase {
    UserAuth userAuth200 = UserAuth.builder().userName("a").password("aaaaA11@").build();
    UserAuth userAuth400 = UserAuth.builder().userName("").password("").build();
    UserAuth userAuth404 = UserAuth.builder().userName("a").password("aaaadA11@").build();
    Account account = new Account();

    @BeforeMethod
    public void preconditions(){
        RestAssured.baseURI = baseUri;
        RestAssured.basePath = basePath1;
    }

    @Test
    public void authorizedCode200Test() {
       boolean response = account
                .authorizedCode200(userAuth200);
       Assert.assertTrue(response);
    }

    @Test
    public void authorizedCode400(){
        ErrorMessage error = account.authorizedCode400(userAuth400);
        Assert.assertEquals(error.getCode(), 1200);
        Assert.assertEquals(error.getMessage(), "UserName and Password required.");
    }

    @Test
    public void authorizedCode404(){
        ErrorMessage error = account.authorizedCode404(userAuth404);
        Assert.assertEquals(error.getCode(), 1207);
        Assert.assertEquals(error.getMessage(), "User not found!");
    }
}
