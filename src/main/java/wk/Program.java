package wk;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Program {

    static Properties load(String file) {
        try (InputStream resourceAsStream = Program.class.getClassLoader().getResourceAsStream(file)) {
            Properties prop = new Properties();
            prop.load(resourceAsStream);

            Properties sys = System.getProperties();
            prop.putAll(sys);
            return prop;
        } catch (IOException e) {
            System.err.print(e.getMessage());
            return new Properties();
        }
    }

    public static void main(String[] args) {
        Properties props = load("db.properties");
        System.out.println(props.getProperty("connection"));
    }
}
