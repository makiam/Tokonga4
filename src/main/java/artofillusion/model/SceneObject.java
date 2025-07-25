package artofillusion.model;

public interface SceneObject {

    default String getName() {
        return this.getClass().getSimpleName();
    }

    default Class<? extends EditorProvider> editorProvider() {
        return null;
    }


}
