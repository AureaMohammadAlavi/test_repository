package me.smash.gradle;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import org.apache.commons.io.IOUtils;

public class Sample {

  public static void main(String[] args) throws IOException {
    URL resource = Sample.class.getClassLoader()
        .getResource(Sample.class.getCanonicalName().replace(".", "/") + ".class");
    URLConnection connection = Objects.requireNonNull(resource).openConnection();
    IOUtils.readFully(connection.getInputStream(), connection.getContentLength());
  }
}
