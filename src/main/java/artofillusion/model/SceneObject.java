package artofillusion.model;

public interface SceneObject {
    default String getName() {
        return this.getClass().getSimpleName();
    }
}
