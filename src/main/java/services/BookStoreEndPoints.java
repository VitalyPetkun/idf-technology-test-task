package services;

public enum BookStoreEndPoints {

    ACCOUNT("/Account"),
    BOOK_STORE("/BookStore"),
    VERSION("/v1"),
    USER("/User"),
    BOOKS("/Books");

    private String endPoint;

    BookStoreEndPoints(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

}
