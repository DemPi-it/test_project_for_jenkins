package specifications;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiSpecifications {

    public static void installApiSpecifications() {

        try (InputStream inputStream = new FileInputStream("C:\\IdeaProjects\\test_project_for_jenkins\\src\\test\\resources\\application.properties")) {
            Properties prop = new Properties();
            prop.load(inputStream);

            RestAssured.requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(prop.getProperty("base.api.uri"))
                    .setContentType(ContentType.JSON)
                    .log(LogDetail.URI)
                    .build();
            RestAssured.responseSpecification = new ResponseSpecBuilder()
                    .build();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
