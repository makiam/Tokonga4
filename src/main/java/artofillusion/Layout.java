package artofillusion;

import ModernDocking.DockingRegion;
import ModernDocking.app.Docking;
import ModernDocking.app.RootDockingPanel;
import ModernDocking.ext.ui.DockingUI;

import artofillusion.api.Tool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;

public class Layout extends JFrame {
    private JMenu fileMenu;
    private final List<DockingPanel> windows = new ArrayList<>();

    public Layout() {
        initDocking();
        addDockingPanel("976af87b-90f3-42ce-a5d6-e4ab663fbb15", "Script", new JTree());
        Docking.dock(windows.get(0), this, DockingRegion.SOUTH);
    }

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
        App.getPluginManager().getExtensions(Tool.class).stream().map(Tool::create).forEach(mi -> tools.add(mi));
    }

    private void initDocking() {
        Docking.initialize(this);
        DockingUI.initialize();
        ModernDocking.settings.Settings.setAlwaysDisplayTabMode(true);
        ModernDocking.settings.Settings.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        // create root panel
        RootDockingPanel root = new RootDockingPanel(this);
        add(root, BorderLayout.CENTER);
    }

    private void addDockingPanel(String persistentID, String tabText,Component component) {
        DockingPanel panel = new DockingPanel(persistentID, tabText);
        panel.add(component);
        windows.add(panel);
    }
}
