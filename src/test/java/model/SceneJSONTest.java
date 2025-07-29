package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class SceneJSONTest {

    @Test
    void testCreate() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        var scene = new SceneJSON();
        scene.add(new SceneItemJSON());
        scene.add(new SceneItemJSON());
        log.info("Json: {}", gson.toJson(scene));
    }
}
