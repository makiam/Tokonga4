package artofillusion.model;

import artofillusion.api.ImplementationVersion;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@ImplementationVersion
public class SceneImpl implements Scene {

    private final List<Material> materials = new ArrayList<>();
    private final List<Texture> textures = new ArrayList<>();

    @Override
    public TextureCollection getTexturesCollection() {
        return new TexturesCollectionImpl();
    }

    @Override
    public MaterialCollection getMaterialsCollection() {
        return new MaterialsCollectionImpl();
    }

    @Override
    public void add(Material material) {
        materials.add(material);
    }

    @Override
    public void add(Texture texture) {
        textures.add(texture);
    }

    private class MaterialsCollectionImpl extends MaterialCollection {

    }

    private class TexturesCollectionImpl extends TextureCollection {

    }
}
