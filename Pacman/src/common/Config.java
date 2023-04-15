package common;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private int width;
    private int height;

    public Config() {
        Properties props = new Properties();

        try {
            props.load(new FileInputStream("config.properties"));

            width = Integer.parseInt(props.getProperty("window.width"));
            height = Integer.parseInt(props.getProperty("window.height"));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Font getFont(float size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File("data/assets/fonts/emulogic.ttf")).deriveFont(size);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return null;
        }
    }
}
