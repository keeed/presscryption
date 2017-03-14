/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kedren Villena
 */
public class ObjectCreator {

    public static <T> T CreateInstance(
            String jarName,
            String className) {

        try {
            File jarFile = new File(jarName);
            if (!jarFile.isFile()) {
                throw new FileNotFoundException("Missing required JAR: " + jarFile.toString());
            }
            URL jarUrl = jarFile.toURI().toURL();

            URLClassLoader cl = URLClassLoader.newInstance(new URL[]{jarUrl});

            Class classInstance = cl.loadClass(className);

            T instance = (T) classInstance.newInstance();

            return instance;

        } catch (FileNotFoundException | ClassNotFoundException | InstantiationException | IllegalAccessException | MalformedURLException ex) {
            Logger.getLogger(ObjectCreator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
