package me.gerryyuu.xyyzsmpcore.util;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class FileUtil {
    private FileUtil() {
    }

    public static List<String> readLinesFromTxtFile(File txtFile) throws IOException {
        Path path = Paths.get(txtFile.getAbsolutePath());
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
