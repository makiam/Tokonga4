package artofillusion.api;

import org.pf4j.ExtensionPoint;

import javax.swing.*;

public interface Tool extends ExtensionPoint {
    default String getName() {
        return this.getClass().getSimpleName();
    }

    static JMenuItem create(Tool tool) {
        return new JMenuItem(tool.getName());
    }
}
