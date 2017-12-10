package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {
    
    private double MyDoubleT;
    private float MyFloatT;
    private short MyShortT;
    private char MyCharT;
    
    private double MyOtherDoubleT;
    private float MyOtherFloatT;
    private short MyOtherShortT;
    private char MyOtherCharT;
    
    
    public MyAllTypesSecond() {
        
    }
    
    public MyAllTypesSecond(double _secondDouble, float _secondFloat, short _secondShort, char _secondChar) {
        MyDoubleT = _secondDouble;
        MyFloatT = _secondFloat;
        MyShortT = _secondShort;
        MyCharT = _secondChar;
    }
    
    public void setMyDoubleT(double newDouble) {
        MyDoubleT = newDouble;
    }
    public double getMyDoubleT() {
        return MyDoubleT;
    }
    public void setMyOtherDoubleT(double newDouble) {
        MyOtherDoubleT = newDouble;
    }
    public double getMyOtherDoubleT() {
        return MyOtherDoubleT;
    }
    
    public void setMyFloatT(float newFloat) {
        MyFloatT = newFloat;
    }
    public float getMyFloatT() {
        return MyFloatT;
    }
    public void setMyOtherFloatT(float newFloat) {
        MyOtherFloatT = newFloat;
    }
    public float getMyOtherFloatT() {
        return MyOtherFloatT;
    }
    
    public void setMyShortT(short newShort) {
        MyShortT = newShort;
    }
    public short getMyShortT() {
        return MyShortT;
    }
    public void setMyOtherShortT(short newShort) {
        MyOtherShortT = newShort;
    }
    public short getMyOtherShortT() {
        return MyOtherShortT;
    }
    
    public void setMyCharT(char newChar) {
        MyCharT = newChar;
    }
    public char getMyCharT() {
        return MyCharT;
    }
    public void setMyOtherCharT(char newChar) {
        MyOtherCharT= newChar;
    }
    public char getMyOtherCharT() {
        return MyOtherCharT;
    }
    
    public String toString() {
        String str = "";
        str = str + "myDouble: " + MyDoubleT + "\n";
        str = str + "myFloat: " + MyFloatT + "\n";
        str = str + "myShort: " + MyShortT + "\n";
        str = str + "myChar: " + MyCharT + "\n";
        str = str + "myOtherDouble: " + MyOtherDoubleT + "\n";
        str = str + "myOtherFloat: " + MyOtherFloatT + "\n";
        str = str + "myOtherShort: " + MyOtherShortT + "\n";
        str = str + "myOtherChar: " + MyOtherCharT + "\n";
        
        return str;
    }
}