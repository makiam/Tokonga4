package model;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SceneJSON {
    private final UUID sceneId = java.util.UUID.randomUUID();

    private List<SceneItemJSON> objects = new ArrayList<>();

    void add(SceneItemJSON item) {
        item.
        objects.add(item);
    }
}
