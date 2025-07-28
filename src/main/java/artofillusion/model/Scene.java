package artofillusion.model;

public interface Scene {
    TextureCollection getTexturesCollection();
    SceneObjectCollection getMaterialsCollection();

    void add(Material material);
    void add(Texture texture);

}
