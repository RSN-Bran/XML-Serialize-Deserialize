package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.FileProcessor;

//needs to implement InvocationHandler
public class StoreRestoreHandler implements InvocationHandler  {
    
    private FileProcessor fp = null;
    
    public StoreRestoreHandler(FileProcessor _fp) {
        fp = _fp;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        if ("writeObj".equals(method.getName())) {
			if("XML".equals(args[1].toString())) {
                Serialize serialize = new Serialize();
				serialize.start((SerializableObject)args[0], fp);
			}	
        }
        else if ("readObj".equals(method.getName())) {
			if("XML".equals(args[0].toString())) {
                Deserialize deserialize = new Deserialize();
				return deserialize.start(fp);
			}	
        }
        return null;
    }
}