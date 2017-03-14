/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presscryption.common;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Kedren Villena
 */
public class ComponentManager {
    
    private static final HashMap<Type, Object> COMPONENTS = new HashMap<>();
    
    public static void RegisterComponent(Type type, Object instance) {
        if (COMPONENTS.containsKey(type)) {
            COMPONENTS.replace(type, instance);
        }
        else {
            COMPONENTS.put(type, instance);
        }
    }
    
    public static <T> T GetComponent(Class<T> type) {
        
        if (COMPONENTS.containsKey(type)) {
            return (T) COMPONENTS.get(type);
        }
        
        Set<Map.Entry<Type, Object>> entrySet = COMPONENTS.entrySet();
        
        for (Entry entry : entrySet) {
            if (type.isInstance(entry.getValue())) {
                return (T) entry.getValue();
            }
        }
        
        return null;
    }  
}
