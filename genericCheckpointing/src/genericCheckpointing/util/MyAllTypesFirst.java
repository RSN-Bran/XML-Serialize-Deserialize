package genericCheckpointing.util;

public class MyAllTypesFirst extends SerializableObject {
    
    private int MyInt;
    private long MyLong;
    private String MyString;
    private boolean MyBoolean;
    
    private int MyOtherInt;
    private long MyOtherLong;
    private String MyOtherString;
    private boolean MyOtherBoolean;
    
    public MyAllTypesFirst() {
        
    }
    public MyAllTypesFirst(int _firstInt, long _firstLong, String _firstString, boolean _firstBoolean) {
        MyInt = _firstInt;
        MyLong = _firstLong;
        MyString = _firstString;
        MyBoolean = _firstBoolean;
    }
    
    public void setMyInt(int newInt) {
        MyInt = newInt;
    }
    public int getMyInt() {
        return MyInt;
    }
    public void setMyOtherInt(int newInt) {
        MyOtherInt = newInt;
    }
    public int getMyOtherInt() {
        return MyOtherInt;
    }
    
    public void setMyLong(long newLong) {
        MyLong = newLong;
    }
    public long getMyLong() {
        return MyLong;
    }
    public void setMyOtherLong(long newLong) {
        MyOtherLong = newLong;
    }
    public long getMyOtherLong() {
        return MyOtherLong;
    }
    
    public void setMyString(String newString) {
        MyString = newString;
    }
    public String getMyString() {
        return MyString;
    }
    public void setMyOtherString(String newString) {
        MyOtherString = newString;
    }
    public String getMyOtherString() {
        return MyOtherString;
    }
    
    public void setMyBoolean(boolean newBoolean) {
        MyBoolean = newBoolean;
    }
    public boolean getMyBoolean() {
        return MyBoolean;
    }
    public void setMyOtherBoolean(boolean newBoolean) {
        MyOtherBoolean = newBoolean;
    }
    public boolean getMyOtherBoolean() {
        return MyOtherBoolean;
    }
    
    public String toString() {
        String str = "";
        str = str + "myInt: " + MyInt + "\n";
        str = str + "myLong: " + MyLong + "\n";
        str = str + "myString: " + MyString + "\n";
        str = str + "myBoolean: " + MyBoolean + "\n";
        
        return str;
    }
}