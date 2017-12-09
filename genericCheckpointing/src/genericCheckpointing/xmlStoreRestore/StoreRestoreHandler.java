package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

//needs to implement InvocationHandler
public class StoreRestoreHandler implements InvocationHandler  {
    public StoreRestoreHandler() {
        
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        if("writeObj".equals(method.getName())) {
            
        }
        return null;
    }
}