package ch.burg.deskriptor.engine;

import java.io.InputStream;

public class TestUtils {

    public static InputStream getInputStream(final String path) {
        final ClassLoader classLoader = TestUtils.class.getClassLoader();
        return classLoader.getResourceAsStream(path);
    }
}
