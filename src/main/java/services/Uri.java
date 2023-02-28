package services;

import framework.utils.PropertiesManager;

public enum Uri {

    DEMOQA_URI(PropertiesManager.getValue(
            Paths.CONFIG_PROPERTIES_PATHS.getPath(),
            Files.CONFIG_PROPERTIES.getFile(),
            ConfigVariables.DEMOQA_URI.getConfigVariable()));

    private String uri;

    Uri(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }
}
