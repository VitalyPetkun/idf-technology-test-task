package services;

public enum Paths {

    TEST_RESOURCES_PATHS("src\\test\\resources\\");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
