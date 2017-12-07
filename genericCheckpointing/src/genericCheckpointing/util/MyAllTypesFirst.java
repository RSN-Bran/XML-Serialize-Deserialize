package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject {
    
    private int firstInt;
    private long firstLong;
    private String firstString;
    private boolean firstBoolean;
    
    public MyAllTypesFirst() {
        
    }
    public MyAllTypesFirst(int _firstInt, long _firstLong, String _firstString, boolean _firstBoolean) {
        firstInt = _firstInt;
        firstLong = _firstLong;
        firstString = _firstString;
        firstBoolean = _firstBoolean;
    }
    
    public void setInt(int newInt) {
        firstInt = newInt;
    }
    public int getInt() {
        return firstInt;
    }
    
    public void setLong(long newLong) {
        firstLong = newLong;
    }
    public long getLong() {
        return firstLong;
    }
    
    public void setString(String newString) {
        firstString = newString;
    }
    public String getString() {
        return firstString;
    }
    
    public void setBoolean(boolean newBoolean) {
        firstBoolean = newBoolean;
    }
    public boolean getBoolean() {
        return firstBoolean;
    }
}