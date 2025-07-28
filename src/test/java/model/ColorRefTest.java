package model;

import artofillusion.model.ColorRef;
import artofillusion.model.Scene;
import artofillusion.model.SceneImpl;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.junit.jupiter.api.BeforeAll;

public class ColorRefTest {

    static XStream xstream;

    @BeforeAll
    static void init() {
        xstream = new XStream(new StaxDriver());
        xstream.ignoreUnknownElements();
        xstream.allowTypes(new Class[]{SceneImpl.class,ColorRef.class});
        xstream.processAnnotations(new Class[]{SceneImpl.class, ColorRef.class});
    }
}
