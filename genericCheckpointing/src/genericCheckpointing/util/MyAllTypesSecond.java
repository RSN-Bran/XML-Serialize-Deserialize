package genericCheckpointing.util;

public class MyAllTypesSecond extends SerializableObject {
    
    private double secondDouble;
    private float secondFloat;
    private short secondShort;
    private char secondChar;
    
    public MyAllTypesSecond() {
        
    }
    public MyAllTypesSecond(double _secondDouble, float _secondFloat, short _secondShort, char _secondChar) {
        secondDouble = _secondDouble;
        secondFloat = _secondFloat;
        secondShort = _secondShort;
        secondChar = _secondChar;
    }
    
    public void setDouble(double newDouble) {
        secondDouble = newDouble;
    }
    public double getDouble() {
        return secondDouble;
    }
    
    public void setFloat(float newFloat) {
        secondFloat = newFloat;
    }
    public float getFloat() {
        return secondFloat;
    }
    
    public void setShort(short newShort) {
        secondShort = newShort;
    }
    public short getShort() {
        return secondShort;
    }
    
    public void setChar(char newChar) {
        secondChar = newChar;
    }
    public char getChar() {
        return secondChar;
    }
    
    public String toString() {
        String str = "";
        str = str + "myDouble: " + secondDouble + "\n";
        str = str + "myFloat: " + secondFloat + "\n";
        str = str + "myShort: " + secondShort + "\n";
        str = str + "myChar: " + secondChar + "\n";
        
        return str;
    }
}