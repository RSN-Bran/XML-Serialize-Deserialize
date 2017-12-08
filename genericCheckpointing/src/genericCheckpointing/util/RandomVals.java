package genericCheckpointing.util;

import java.util.Random;
public class RandomVals {
    
    public RandomVals() {
        
    }
    
    public int randInt() {
        Random rand = new Random();
        int val = rand.nextInt(2147483647);
        return val;
        
    }
    
    public long randLong() {
        Random rand = new Random();
        long val1 = rand.nextInt(2147483647);
        long val2 = rand.nextInt(2147483647);
        long val3 = rand.nextInt(2147483647);
        return val1+val2+val3;
    }
    
    public String randString() {
        String all = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        String val = "";
        int len = rand.nextInt(10) + 1;
        for(int i = 0; i < len; i++) {
            int c = rand.nextInt(52);
            val = val + all.charAt(c);
        }
        return val;
    }
    
    public boolean randBoolean() {
        Random rand = new Random();
        int randNum = rand.nextInt(2);
        if(randNum == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public double randDouble() {
        Random rand = new Random();
        String all = "123456789";
        int rand1 = rand.nextInt(10);
        int rand2 = rand.nextInt(10);
        String num = "";
        for(int i = 0; i < rand1; i++) {
            int c = rand.nextInt(9);
            num = num + all.charAt(c);
        }
        
        num = num + ".";
        
        for(int i = 0; i < rand2; i++) {
            int c = rand.nextInt(9);
            num = num + all.charAt(c);
        }
        
        return Double.parseDouble(num);
    }
        
    public float randFloat() {
        Random rand = new Random();
        String all = "123456789";
        int rand1 = rand.nextInt(10);
        int rand2 = rand.nextInt(10);
        String num = "";
        for(int i = 0; i < rand1; i++) {
            int c = rand.nextInt(9);
            num = num + all.charAt(c);
        }
        
        num = num + ".";
        
        for(int i = 0; i < rand2; i++) {
            int c = rand.nextInt(9);
            num = num + all.charAt(c);
        }
        
        return Float.parseFloat(num);
        
    }
        
    public short randShort() {
        Random rand = new Random();
        int val = rand.nextInt(32767);
        return (short)val;
    }
        
    public char randChar() {
        String all = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        int val = rand.nextInt(52);
        return all.charAt(val);
        
    }
}