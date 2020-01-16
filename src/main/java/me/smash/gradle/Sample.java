package me.smash.gradle;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;
import java.util.Properties;
import org.apache.commons.io.IOUtils;

public class Sample {

  public static void main(String[] args) throws IOException {
    URL resource = Sample.class.getClassLoader()
        .getResource(Sample.class.getCanonicalName().replace(".", "/") + ".class");
    URLConnection connection = Objects.requireNonNull(resource).openConnection();
    System.out.println(IOUtils.readFully(connection.getInputStream(), connection.getContentLength()).length);
    Properties properties = new Properties();
    properties.load(Sample.class.getClassLoader().getResourceAsStream("version.properties"));
    System.out.println(properties.getProperty("version"));
  }
}
