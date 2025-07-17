package artofillusion;

import artofillusion.api.Tool;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Layout extends JFrame {
    private JMenu fileMenu;
    @Override
    protected void frameInit() {
        super.frameInit();
        this.setTitle(App.getAppName());
        this.setSize(1280, 1024);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setJMenuBar(new JMenuBar());
        var mb = getJMenuBar();
        mb.add(fileMenu = new JMenu("File"));
        fileMenu.add(new JMenuItem("Exit")).addActionListener((ActionEvent e) -> System.exit(0));
        mb.add(new JMenu("Edit"));
        var tools = mb.add(new JMenu("Tools"));
        App.getPluginManager().getExtensions(Tool.class).forEach(tool -> {
            tools.add(new JMenuItem(tool.getName()));
        });
    }
}
