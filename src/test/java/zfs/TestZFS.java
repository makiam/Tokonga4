package zfs;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

@Slf4j
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

        try (FileSystem fs = FileSystems.newFileSystem(uri, env)) {
            Files.createDirectories(fs.getPath("images"));
            Path fileInZip = fs.getPath("scene.description");
            log.info("Path: {}, scheme: {}", fileInZip.toUri(), fileInZip.toUri().getScheme());
            Files.writeString(fileInZip, "Hello from inside the ZIP!");
        }

    }
}
