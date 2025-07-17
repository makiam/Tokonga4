package artofillusion;

import groovy.lang.GroovyShell;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.pf4j.JarPluginManager;
import org.pf4j.PluginManager;

import javax.swing.*;
import java.nio.file.Path;

@Slf4j
public class App {
    @Getter
    private static PluginManager pluginManager = new JarPluginManager(Path.of("./Plugins"));

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Shutdown plugin system...");
            pluginManager.stopPlugins();
            pluginManager.unloadPlugins();
        }));
        Thread.setDefaultUncaughtExceptionHandler((Thread t, Throwable e) -> log.error("Uncaught exception: {} from: {}", e.getMessage(), e));
    }

    @Getter
    private static GroovyShell shell = new GroovyShell();

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

        SwingUtilities.invokeLater(() -> new Layout().setVisible(true));
    }
}
