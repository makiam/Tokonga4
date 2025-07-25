package artofillusion.model;

public class Texture implements SceneObject {
    @Override
    public Class<? extends EditorProvider> editorProvider() {
        return TextureEditorProvider.class;
    }
}
