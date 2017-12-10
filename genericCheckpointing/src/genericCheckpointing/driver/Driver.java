package genericCheckpointing.driver;

import java.util.Vector;
import java.util.ArrayList;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.util.RandomVals;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;
import genericCheckpointing.xmlStoreRestore.Serialize;
import genericCheckpointing.xmlStoreRestore.Deserialize;

// import the other types used in this file

public class Driver {
    
    public static void main(String[] args) {
	
        //Initialize parameters
        String mode = args[0];
        int numObjs = 0;
        String file = args[2];

        if(args.length != 3) {
            System.err.println("Usage: <Mode> <NumObjs> <File>");
            System.exit(1);
        }

        if(args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
            System.err.println("Usage: <Mode> <NumObjs> <File>");
            System.exit(1);
        }

        if(!((mode.equals("serdeser")) || (mode.equals("deser")))) {
            System.err.println("Mode must be 'serdeser' or 'deser'");
            System.exit(1);
        }

        try{
            numObjs = Integer.parseInt(args[1]);
        }
        catch(NumberFormatException e) {
            System.err.println("NumObjs must be an int");
            System.exit(1);
        }

        FileProcessor fp = new FileProcessor(file);
        
        ProxyCreator pc = new ProxyCreator();

        // create an instance of StoreRestoreHandler (which implements
        // the InvocationHandler

        // create a proxy
        StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
                                     new Class[] {
                                         StoreI.class, RestoreI.class
                                     }, 
                                     new StoreRestoreHandler()
                                     );

        // FIXME: invoke a method on the handler instance to set the file name for checkpointFile and open the file

        MyAllTypesFirst myFirst;
        MyAllTypesSecond  mySecond;

        RandomVals randVals = new RandomVals();
        
        Vector<SerializableObject> createdObjects = new Vector<SerializableObject>();
        
        if(mode.equals("serdeser")) {
                // Use an if/switch to proceed according to the command line argument
        // For deser, just deserliaze the input file into the data structure and then print the objects
        // The code below is for "serdeser" mode
        // For "serdeser" mode, both the serialize and deserialize functionality should be called.

        // create a data structure to store the objects being serialized
            // NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst and MyAllTypesSecond
           for (int i=0; i<numObjs; i++) {

            // FIXME: create these object instances correctly using an explicit value constructor
            // use the index variable of this loop to change the values of the arguments to these constructors
               myFirst = new MyAllTypesFirst(randVals.randInt(), randVals.randLong(), randVals.randString(), randVals.randBoolean());
               mySecond = new MyAllTypesSecond(randVals.randDouble(), randVals.randFloat(), randVals.randShort(), randVals.randChar());
               mySecond = new MyAllTypesSecond(randVals.randDouble(), randVals.randFloat(), randVals.randShort(), randVals.randChar());
               
               createdObjects.add(myFirst);
               createdObjects.add(mySecond);

            ((StoreI) cpointRef).writeObj(myFirst, "XML");
            ((StoreI) cpointRef).writeObj(mySecond, "XML");

           }

           SerializableObject myRecordRet;

           // create a data structure to store the returned ojects
           for (int j=0; j<2*numObjs; j++) {

               myRecordRet = ((RestoreI) cpointRef).readObj("XML");
            // FIXME: store myRecordRet in the vector
           }
            
            Serialize serialize = new Serialize();
            Vector<String> outputLines = new Vector<String>();
            for(int i = 0; i < createdObjects.size(); i++) {
                outputLines.add("<DPSerialization>\n");
                outputLines.add("\t<complexType xsi:type=\"" +  createdObjects.get(i).getClass().getName() + "\">\n");
                    
                outputLines.add(serialize.convert(createdObjects.get(i)));
                
                outputLines.add("\t</complexType>\n");
                if(i == createdObjects.size()-1) {
                    outputLines.add("</DPSerialization>");
                }
                else {
                    outputLines.add("</DPSerialization>\n");
                }
                
            }
            fp.writeFile(outputLines);

        // FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)

        // FIXME: compare and confirm that the serialized and deserialzed objects are equal. 
        // The comparison should use the equals and hashCode methods. Note that hashCode 
        // is used for key-value based data structures

        }
        Vector<SerializableObject> readObjects = new Vector<SerializableObject>();
        
        fp.readFile(readObjects);
        for(int i = 0; i < readObjects.size(); i++) {
            System.out.println(readObjects.get(i).toString());
        }
    }
}