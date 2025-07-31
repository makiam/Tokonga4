package model;

import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Expose;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Slf4j
public final class FileMoniker {
    @Expose(deserialize = false, serialize = false)
    boolean active = true;


    @SerializedName("external")
    boolean link = false;
    @SerializedName("imageOrigin")
    Path source;
    @SerializedName("path")
    Path local;

    public FileMoniker(FileSystem fs, Path source, Boolean link) throws IOException {
        this.source = source;
        this.link = link;
        if(!link) {
            local = fs.getPath("images", source.getFileName().toString());
            try {
                pack(fs);
            } catch(IOException ie) {
                log.atError().setCause(ie).log("Unable to embed image");
                throw ie;
            }

        }
    }

    private void pack(FileSystem fs) throws IOException {
        Files.copy(source, local, StandardCopyOption.REPLACE_EXISTING);
    }
}
