package genericCheckpointing.util;

import java.io.File;

import java.io.BufferedReader;
import java.io.FileReader;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import genericCheckpointing.xmlStoreRestore.Deserialize;

public class FileProcessor {
    
    private String fileName;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    
    private FileReader fr = null;
    private BufferedReader br = null;
    
    /** Constructor for FileProcessor
    * @param (String) inFile - The input file to read from
    * @return (void)
    */
    public FileProcessor(String inFile) {
        fileName = inFile;
    }
    
    
    
    public void startReading() {
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
        }
        catch(FileNotFoundException e) {
            System.err.println("ERROR: Unable to open output file");
            System.exit(0);
        }
    }

    public String readFile() {
        
        String line = null;
        try {
            line = br.readLine();
        }
        //Catch IO Exception
        catch(IOException e) {
            System.err.println("ERROR: IO Exception");
            System.exit(0);
        }
        
        return line;
    }
    
    public void closeReading() {
        try {
            br.close();
        }
        catch(IOException e) {
            System.err.println("ERROR: IO Exception");
            System.exit(0);
        }
    }
    
    
    
    public void startWriting() {
        try{
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
        }
        catch(FileNotFoundException e) {
            System.err.println("ERROR: Unable to open output file");
            System.exit(0);
        }
        catch(IOException e) {
            System.err.println("ERROR: IO Exception");
            System.exit(0);
        }
    }
    
    public void writeFile(String line) {
        try {
            bw.write(line);
            
        }
        //Catch IO Exception
        catch(IOException e) {
            System.err.println("ERROR: IO Exception");
            System.exit(0);
        }
    }
    
    public void closeWriting() {
        try {
            bw.close();
        }
        catch(IOException e) {
            System.err.println("ERROR: IO Exception");
            System.exit(0);
        } 
    }
}