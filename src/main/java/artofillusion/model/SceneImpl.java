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
    public MaterialsCollection getMaterialsCollection() {
        return new MaterialsCollection(materials);
    }

    @Override
    public void add(Material material) {
        materials.add(material);
    }

    @Override
    public void add(Texture texture) {
        textures.add(texture);
    }

    private class MaterialsCollection implements SceneObjectCollection<Material> {
        private List<Material> materials;

        MaterialsCollection(List<Material> materials) {
            this.materials = materials;
        }

        @Override
        public int getCount() {
            return materials.size();
        }
    }

    private class TexturesCollectionImpl extends TextureCollection {

    }
}
