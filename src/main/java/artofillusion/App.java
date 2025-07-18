package artofillusion;

import groovy.lang.GroovyShell;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.control.customizers.ImportCustomizer;
import org.pf4j.JarPluginManager;
import org.pf4j.PluginManager;
import org.pf4j.PluginStateEvent;


import javax.swing.*;
import java.nio.file.Path;

@Slf4j
public class App {
    @Getter
    private static PluginManager pluginManager = new JarPluginManager(Path.of("./Plugins"));
    static {
        pluginManager.addPluginStateListener(App::onPluginStateEvent);
    }
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Shutdown plugin system...");
            pluginManager.stopPlugins();
            pluginManager.unloadPlugins();
        }));
        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> log.error("Uncaught exception: {} from: {}", e.getMessage(), e));
    }

    @Getter
    private static GroovyShell shell;

    static {
        var cc = new CompilerConfiguration();
        var ic = new ImportCustomizer();
        ic.addStarImports("javax.swing");
        ic.addStarImports(App.class.getPackageName());
        cc.addCompilationCustomizers(ic);
        shell = new GroovyShell(cc);
    }


    @Getter
    @SuppressWarnings("java:S115")
    private static final String appName = "Tokonga";

    public static void main(String... args) {
        log.info("Starting application...");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException ex) {
        }

        pluginManager.loadPlugins();
        pluginManager.startPlugins();
        String script = "SwingUtilities.invokeLater(() -> new Layout().setVisible(true));";
        shell.parse(script).run();

    }

    private static void onPluginStateEvent(PluginStateEvent event) {
        log.info("Plugin {} switched from {} to {}", event.getPlugin(), event.getOldState(), event.getPluginState());
    }
}
