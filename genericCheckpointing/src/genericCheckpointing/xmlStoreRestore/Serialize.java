package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import genericCheckpointing.util.SerializableObject;

public class Serialize {
    public Serialize() {
        
    }
    
    public String convert(SerializableObject obj) {
        String ret = "";
        
        Class cls;
        Method getter = null;
        
        try {
            cls = Class.forName(obj.getClass().getName());
            Field fields[] = cls.getDeclaredFields();
            for(int i = 0; i < fields.length; i++) {
                
                
                getter = cls.getMethod("get" + fields[i].getType().getSimpleName(), (Class<?>[]) null);
                System.out.println(getter);
                
                Object res = getter.invoke(obj, (Object[]) null);
                System.out.println(res);
                
                ret = ret + "\t\t<" + fields[i].getName() + " xsi:type=\"" + fields[i].getType().getSimpleName() + "\">" + res + "<" + fields[i].getType().getSimpleName() + ">\n";
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
        return ret;
    }
}