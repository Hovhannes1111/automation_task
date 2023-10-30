package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.experimental.UtilityClass;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@UtilityClass
public class JsonUtils {
    private static final Gson GSON = new Gson();
    private static final String JSON_OBJECT_PATH = "src/test/resources/testdata/%s.json";

    public static JSONObject getJsonObject(String fileName) {
        try {
            return new JSONObject(Files.readString(Paths.get(String.format(JSON_OBJECT_PATH, fileName))));
        } catch (IOException e) {
            return null;
        }
    }

    public static <T> T deserializeJson(String fileName, Class<T> c) {
        try (FileReader reader = new FileReader(String.format(JSON_OBJECT_PATH, fileName), StandardCharsets.UTF_8)) {
            Type type = TypeToken.getParameterized(c).getType();
            return GSON.fromJson(reader, type);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize JSON", e);
        }
    }
}
