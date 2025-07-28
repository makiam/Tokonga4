package artofillusion.model;


import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("color")
public class ColorRef implements SceneObject {
    @Override
    public String getName() {
        return "Color";
    }
}
