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
    
    /** Constructor for FileProcessor
    * @param (String) inFile - The input file to read from
    * @return (void)
    */
    public FileProcessor(String inFile) {
        fileName = inFile;
    }
    
    /** Reads a file and inserts each line into the tree
    * First sets up a BufferedReader using the file name from the constructor
    * For each line of the file, call insertNode from the tree using the line to insert it into the tree
    * Perform error checks
    * @param (TreeBuilder) tree - the tree to be worked on
    * @return (void)
    */
    public void readFile(Vector<SerializableObject> objects) {
        File inFile = new File(fileName);
        BufferedReader read = null;
        
        Deserialize deserialize = new Deserialize();
        
        try {
            read = new BufferedReader(new FileReader(inFile));
            String line;
            
            boolean startReading = false;
            SerializableObject current = null;
            while((line = read.readLine()) != null) {
                if(line.contains("MyAllTypesFirst")){
                    current = new MyAllTypesFirst();
                    startReading = true;
                }
                else if(line.contains("MyAllTypesSecond")){
                    current = new MyAllTypesSecond();
                    startReading = true;
                }
                
                else if(line.equals("\t</complexType>")) {
                    startReading = false;
                    objects.add(current);
                }
                
                else if(startReading) {
                    deserialize.convert(current, line);
                }
            }
        }
        //Catch File Not Found
        catch(FileNotFoundException e) {
            System.err.println("ERROR: Unable to open input file");
            System.exit(0);
        }
        //Catch IO Exception
        catch(IOException e) {
            System.err.println("ERROR: IO Exception");
            System.exit(0);
        }
        finally {
            try{
                read.close();
            }
            catch(IOException e) {
                System.err.println("Error: IO Exception");
                System.exit(0);
            }
        }
    }
    
    public void writeFile(Vector<String> lines) {
         try{
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            for(int i = 0; i < lines.size(); i++){
                bw.write(lines.get(i));
            }
            
            bw.close();
        }
        catch(FileNotFoundException e) {
            System.err.println("ERROR: Unable to open output file");
            System.exit(0);
        }
        //Catch IO Exception
        catch(IOException e) {
            System.err.println("ERROR: IO Exception");
            System.exit(0);
        }
    }
}