import org.junit.jupiter.api.Test;
import specifications.ApiSpecifications;

import static io.restassured.RestAssured.given;

public class TestClass {

    @Test
    public void testExample() {
        ApiSpecifications.installApiSpecifications();
        var response = given()
                .when()
                .get("/api/users?page=2")
                .then()
                .log().all();
    }

}
