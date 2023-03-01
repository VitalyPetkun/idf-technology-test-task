package framework.utils.api;

import framework.utils.SmartLogger;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ApiUtils {

    protected ApiUtils() {
    }

    public static void setupBaseUri(String currentBaseUri) {
        SmartLogger.logInfo("Setup baseUri ".concat(currentBaseUri));
        baseURI = currentBaseUri;
    }

    protected static Response doGet(ContentType contentType, String endPoint) {
        SmartLogger.logInfo("Get request ".concat(baseURI).concat(endPoint));
        return new Response(given().accept(contentType).when().get(endPoint).then());
    }

    protected static Response doPost(ContentType contentType, String body, String endPoint) {
        SmartLogger.logInfo("Post request ".concat(baseURI).concat(endPoint));
        return new Response(given().accept(contentType).contentType(contentType).
                body(body).when().post(endPoint).then());
    }

    protected static Response doDelete(ContentType contentType, String endPoint) {
        SmartLogger.logInfo("Delete request ".concat(baseURI).concat(endPoint));
        return new Response(given().accept(contentType).when().delete(endPoint).then());
    }
}
