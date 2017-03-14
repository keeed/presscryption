/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kedren Villena
 */
public class PropertiesManager {

    private static final Properties PROPERTIES = new Properties();
    private static final Properties UI_PROPERTIES = new Properties();

    public static void LoadProperties(InputStream inputStream) {

        try {
            PROPERTIES.load(inputStream);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String GetProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    public static Enumeration<?> GetAllPropertyNames() {
        return PROPERTIES.propertyNames();
    }

    public static void LoadUIProperties(InputStream inputStream) {
        try {
            UI_PROPERTIES.load(inputStream);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PropertiesManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String GetUIProperty(String key) {
        return UI_PROPERTIES.getProperty(key);
    }

    public static Enumeration<?> GetAllUIPropertyNames() {
        return UI_PROPERTIES.propertyNames();
    }

    public static void CreateComponents() {
        createComponents(PROPERTIES.propertyNames());
        createUIComponents(UI_PROPERTIES.propertyNames());
    }

    private static void createComponents(Enumeration<?> keys) {
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            if (key.startsWith("Component") && !key.endsWith(".Jar")) {
                String className = PropertiesManager.GetProperty(key);
                String jarName = PropertiesManager.GetProperty(key + ".Jar");
                Object object = (Object) ObjectCreator.CreateInstance(jarName, className);

                ComponentManager.RegisterComponent(object.getClass(), object);
            }
        }
    }

    private static void createUIComponents(Enumeration<?> keys) {
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            if (key.startsWith("Component") && !key.endsWith(".Jar")) {
                String className = PropertiesManager.GetUIProperty(key);
                String jarName = PropertiesManager.GetUIProperty(key + ".Jar");
                Object object = (Object) ObjectCreator.CreateInstance(jarName, className);

                ComponentManager.RegisterComponent(object.getClass(), object);
            }
        }
    }
}
