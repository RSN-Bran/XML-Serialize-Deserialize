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
                
                getter = cls.getMethod("get" + fields[i].getName(), (Class<?>[]) null);
                
                Object res = getter.invoke(obj, (Object[]) null);
                
                boolean ser = true;
                if(fields[i].getType().getSimpleName().equals("int")) {
                    if((int) res < 10) {
                        ser = false;
                    }
                }
                else if(fields[i].getType().getSimpleName().equals("double")) {
                    if((double) res < 10) {
                        ser = false;
                    }
                }
                else if(fields[i].getType().getSimpleName().equals("long")) {
                    if((long) res < 10) {
                        ser = false;
                    }
                }
                else if(fields[i].getType().getSimpleName().equals("short")) {
                    if((short) res == 0) {
                        ser = false;
                    }
                }
                else if(fields[i].getType().getSimpleName().equals("float")) {
                    if((float) res == 0.0) {
                        ser = false;
                    }
                }
                else if(fields[i].getType().getSimpleName().equals("String")) {
                    if(res == null) {
                        ser = false;
                    }
                }
                else if(fields[i].getType().getSimpleName().equals("char")) {
                    if((char) res == '\u0000') {
                        ser = false;
                    }
                }
                if(ser) {
                    ret = ret + "\t\t<" + fields[i].getName() + " xsi:type=\"" + fields[i].getType().getSimpleName() + "\">" + res + "<" + fields[i].getType().getSimpleName() + ">\n";
                }
                
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