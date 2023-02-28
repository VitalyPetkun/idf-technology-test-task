package services;

public enum Paths {

    CONFIG_PROPERTIES_PATHS("src\\main\\resources\\");

    private String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
