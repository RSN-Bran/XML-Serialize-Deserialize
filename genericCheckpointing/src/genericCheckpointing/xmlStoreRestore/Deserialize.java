package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.util.SerializableObject;

public class Deserialize {
    public Deserialize() {
        
    }
    
    public void convert(SerializableObject obj, String line) {
        
        Class cls;
        Method setter = null;
        
        String[] splitString = line.split("[ <\":>]");
        
        //splitString 1 gives param name
        //splitString 4 gives param type
        //splitString 6 gives param value
        
        
        try {
            cls = Class.forName(obj.getClass().getName());
            //System.out.println(line);
            
            Class[] cArg = new Class[1];
            
            if(splitString[4].equals("int")) {
                cArg[0] = int.class;
                setter = cls.getMethod("set" + splitString[1], cArg);
                setter.invoke(obj, Integer.parseInt(splitString[6]));
            }
            else if(splitString[4].equals("long")) {
                cArg[0] = long.class;
                setter = cls.getMethod("set" + splitString[1], cArg);
                setter.invoke(obj, Long.parseLong(splitString[6]));
            }
            else if(splitString[4].equals("String")) {
                cArg[0] = String.class;
                setter = cls.getMethod("set" + splitString[1], cArg);
                setter.invoke(obj, splitString[6]);
            }
            else if(splitString[4].equals("boolean")) {
                cArg[0] = boolean.class;
                setter = cls.getMethod("set" + splitString[1], cArg);
                setter.invoke(obj, Boolean.parseBoolean(splitString[6]));
            }
            else if(splitString[4].equals("double")) {
                cArg[0] = double.class;
                setter = cls.getMethod("set" + splitString[1], cArg);
                setter.invoke(obj, Double.parseDouble(splitString[6]));
            }
            else if(splitString[4].equals("float")) {
                cArg[0] = float.class;
                setter = cls.getMethod("set" + splitString[1], cArg);
                setter.invoke(obj, Float.parseFloat(splitString[6]));
            }
            else if(splitString[4].equals("short")) {
                cArg[0] = short.class;
                setter = cls.getMethod("set" + splitString[1], cArg);
                setter.invoke(obj, Short.parseShort(splitString[6]));
            }
            else if(splitString[4].equals("char")) {
                cArg[0] = char.class;
                setter = cls.getMethod("set" + splitString[1], cArg);
                setter.invoke(obj, splitString[6].charAt(0));
            }
            
            
        } catch (ClassNotFoundException e) {
			System.err.println("Class Not found exception");
			System.exit(0);
            
		} catch (NoSuchMethodException e) {
			
			System.err.println("No such method Exception");
			System.exit(0);

		} catch (SecurityException e) {
			
			System.err.println("Security Exception");
			System.exit(0);

		} catch (IllegalAccessException e) {
			
			System.err.println("Illegal Access Exception");
			System.exit(0);

		} catch (IllegalArgumentException e) {
			
			System.err.println("Illegal Argument Exception");
			System.exit(0);

		} catch (InvocationTargetException e) {
			
			System.err.println("Invocation Target Exception");
			System.exit(0);

		}	
    }
}