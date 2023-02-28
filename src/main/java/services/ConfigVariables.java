package services;

public enum ConfigVariables {

    DEMOQA_URI("demoqaUri"),
    USER_NAME("userName"),
    PASSWORD("password");

    private String configVariable;

    ConfigVariables(String configVariable) {
        this.configVariable = configVariable;
    }

    public String getConfigVariable() {
        return configVariable;
    }
}
