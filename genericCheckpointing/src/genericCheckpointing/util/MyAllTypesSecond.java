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
        if(MyDoubleT > 0) {
            str = str + "myDoubleT: " + MyDoubleT + "\n";
        }
        if(MyFloatT > 0) {
            str = str + "myFloatT: " + MyFloatT + "\n";
        }
        if(MyShortT > 0) {
            str = str + "myShortT: " + MyShortT + "\n";
        }
        if(MyCharT != '\u0000') {
            str = str + "myCharT: " + MyCharT + "\n";
        }
        if(MyOtherDoubleT > 0) {
            str = str + "myOtherDoubleT: " + MyOtherDoubleT + "\n";
        }
        if(MyOtherFloatT > 0) {
            str = str + "myOtherFloatT: " + MyOtherFloatT + "\n";
        }
        if(MyOtherShortT > 0) {
            str = str + "myShortT: " + MyOtherShortT + "\n";
        }
        if(MyOtherCharT != '\u0000') {
            str = str + "myCharT: " + MyOtherCharT + "\n";
        }
        
        return str;
    }
}