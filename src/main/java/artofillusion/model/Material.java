package artofillusion.model;

public class Material implements SceneObject {
    @Override
    public Class<? extends EditorProvider> editorProvider() {
        return MaterialEditorProvider.class;
    }
}
