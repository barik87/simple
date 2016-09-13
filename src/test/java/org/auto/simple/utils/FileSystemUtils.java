package org.auto.simple.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.junit.Assert;

public class FileSystemUtils {

    /**
     * Adds path of the project directory with a slash ('/') on the end.
     * 
     * @param relativePath
     *            - path from the project directory, like 'data' or 'reports';
     * 
     * @return absolute path;
     */
    public static String addAbsolutePath(String relativePath) {
        String result = relativePath;
        try {
            result = new File(".").getCanonicalPath() + File.separator + relativePath;
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        return result;
    }

    /**
     * Fetch the entire contents of a text file, and return it in a String. This style of implementation does not throw
     * Exceptions to the caller.
     * 
     * @param file
     *            is a file which already exists and can be read.
     */
    public static List<String> getContents(File file) {
        try {
            return Files.readAllLines(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        return null;
    }
}
