package io.github.xtherk.bytehook;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author xtherk
 */
public class ResourceUtils {
    public static final Path currentDir = Paths.get(System.getProperty("user.dir"));

    public static Path getMavenModulePath(String moduleName) {
        return currentDir.resolve(moduleName);
    }

    public static Path getByteHookModulePath(String moduleName) throws FileNotFoundException {
        Path target = getMavenModulePath(moduleName).resolve("target");
        if (Files.exists(target)) {
            return target.resolve("classes");
        }
        throw new FileNotFoundException("Please compile the \"bytehook-module-example\" module first");
    }

}
