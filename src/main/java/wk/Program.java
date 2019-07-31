package wk;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Program {
    public static void main(String[] args) {
        try (InputStream resourceAsStream = Program.class.getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            prop.load(resourceAsStream);

            Properties sys = System.getProperties();
            prop.putAll(sys);

            prop.forEach((k, v) -> System.out.println(k + " = " + v));

        } catch (IOException e) {
            System.err.print(e.getMessage());
        }
    }
}
