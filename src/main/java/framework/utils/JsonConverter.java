package framework.utils;

import com.google.gson.Gson;

public class JsonConverter {

    private static Gson gson;

    private JsonConverter() {
        gson = new Gson();
    }

    private static Gson getGson() {
        if (gson == null)
            new JsonConverter();
        return gson;
    }

    public static String getJsonString(Object object) {
        SmartLogger.logInfo("Converting object to jsonString");
        return getGson().toJson(object);
    }

    public static <T> T getObject(String jsonString, Class<T> cls) {
        SmartLogger.logInfo("Converting jsonString to object");
        try {
            return getGson().fromJson(jsonString, cls);
        } catch (Throwable e) {
            SmartLogger.logError("Don't converter string in json");
        }

        return null;
    }
}