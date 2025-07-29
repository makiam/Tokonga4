package zfs;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TestZFS {


    @Test
    void testCreateSceneFS() throws IOException {
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        env.put("encoding", "UTF-8");
        env.put("compressionMethod", "DEFLATED");
        env.put("compressionLevel", "9");

        var zipPath = Path.of("scene.aoiz");
        URI uri = URI.create("jar:" + zipPath.toUri());
        ;
        try (FileSystem zipfs = FileSystems.newFileSystem(uri, env)) {
            Path fileInZip = zipfs.getPath("scene.description");
            Files.writeString(fileInZip, "Hello from inside the ZIP!");
        }

    }
}
