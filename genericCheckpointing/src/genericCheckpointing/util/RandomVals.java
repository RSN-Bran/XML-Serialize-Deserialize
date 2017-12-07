package genericCheckpointing.util;

import java.util.Random;
public class RandomVals {
    
    public RandomVals() {
        
    }
    
    public int randInt() {
        Random rand = new Random();
        int val = rand.nextInt(9999) + 1;
        return val;
        
    }
    
    public long randLong() {
        Random rand = new Random();
        long val1 = rand.nextInt(99999999)+1;
        long val2 = rand.nextInt(99999999)+1;
        return val1+val2;
    }
    
    public String randString() {
        String all = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        String val = "";
        int len = rand.nextInt(10) + 1;
        for(int i = 0; i < len; i++) {
            int c = rand.nextInt(52);
            val = val + all[c];
        }
        return val;
    }
    
    public boolean randBoolean() {
        
    }
    
    public double randDouble() {
        
    }
        
    public float randFloat() {
        
    }
        
    public short randShort() {
        
    }
        
    public char randChar() {
        String all = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        int val = rand.nextInt(52);
        return all[val];
        
    }
}