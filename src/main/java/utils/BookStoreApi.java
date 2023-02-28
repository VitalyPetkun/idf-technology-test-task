package utils;

import framework.utils.api.ApiUtils;
import framework.utils.api.Response;
import io.restassured.http.ContentType;

import static services.BookStoreEndPoints.*;

public class BookStoreApi extends ApiUtils {

    private BookStoreApi() {
        super();
    }

    public static Response registrationUser(ContentType contentType, String user) {
        return ApiUtils.doPost(contentType, user,
                ACCOUNT.getEndPoint().concat(VERSION.getEndPoint()).concat(USER.getEndPoint()));
    }

    public static Response getBooks(ContentType contentType) {
        return ApiUtils.doGet(contentType,
                BOOK_STORE.getEndPoint().concat(VERSION.getEndPoint()).concat(BOOKS.getEndPoint()));
    }
}
