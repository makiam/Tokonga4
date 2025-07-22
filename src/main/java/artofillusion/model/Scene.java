package artofillusion.model;

public interface Scene {
    TextureCollection getTexturesCollection();
    MaterialCollection getMaterialsCollection();

    void add(Material material);
    void add(Texture texture);

}
