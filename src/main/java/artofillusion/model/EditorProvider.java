package artofillusion.model;

public interface EditorProvider<T extends SceneObject> {
    void edit(T item);
}
