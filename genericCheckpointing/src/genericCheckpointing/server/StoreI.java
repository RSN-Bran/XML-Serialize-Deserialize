package genericCheckpointing.server;

import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;

public interface StoreI extends StoreRestoreI {
    void writeObj(MyAllTypesFirst first, String format);
    void writeObj(MyAllTypesSecond secon, String format);  
}