package model;

import lombok.Getter;

import java.util.UUID;

public class SceneItemJSON {

    UUID parent;

    @Getter
    private UUID id;

    SceneItemJSON() {
        this.id = java.util.UUID.randomUUID();
    }
}
