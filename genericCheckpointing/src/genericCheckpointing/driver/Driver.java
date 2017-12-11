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

        //Error check paramters
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

        //Create instances of objects needed for later
        FileProcessor fp = new FileProcessor(file);
        ProxyCreator pc = new ProxyCreator();
        RandomVals randVals = new RandomVals();

        // create an instance of StoreRestoreHandler (which implements
        // the InvocationHandler

        // create a proxy
        StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
                                     new Class[] {
                                         StoreI.class, RestoreI.class
                                     }, 
                                     new StoreRestoreHandler(fp)
                                     );
        
        //List of objects to be created
        Vector<SerializableObject> createdObjects = new Vector<SerializableObject>();
        
        MyAllTypesFirst myFirst;
        MyAllTypesSecond  mySecond;
        
        //Serdeser mode: Serializes objects to random values, stores them in a file, then reads from the file and outputs them
        if(mode.equals("serdeser")) {
            
            //Open the file to begin writing to it
            fp.startWriting();

           for (int i=0; i<numObjs; i++) {
            
               //Create instances of myFirst and mySecond with random values
               myFirst = new MyAllTypesFirst(randVals.randInt(), randVals.randLong(), randVals.randString(), randVals.randBoolean());
               mySecond = new MyAllTypesSecond(randVals.randDouble(), randVals.randFloat(), randVals.randShort(), randVals.randChar());
               
               //Add the created objects to the list
               createdObjects.add(myFirst);
               createdObjects.add(mySecond);

            //Write these objects to the checkpoint file
            ((StoreI) cpointRef).writeObj(myFirst, "XML");
            ((StoreI) cpointRef).writeObj(mySecond, "XML");

           }
            
            //Close the file for writing
            fp.closeWriting();
            
            //Reopen the file for reading
            fp.startReading();
            
            SerializableObject myRecordRet;
            
            Vector<SerializableObject> readObjs = new Vector<SerializableObject>();
            
           // create a data structure to store the returned ojects
           for (int j=0; j<2*numObjs; j++) {
               
                //Read an object from the checkpoint file, then add it to the vector
               myRecordRet = ((RestoreI) cpointRef).readObj("XML");
               readObjs.add(myRecordRet);

           }
            //Close the file
            fp.closeReading();
            for(int i = 0; i < readObjs.size(); i++) {
                System.out.println(readObjs.get(i).toString());
            }


            if(readObjs.size() == createdObjects.size()) {
                System.out.println("0 Mismatched objects");
            }

        }
        else {
            fp.startReading();
            
            Vector<SerializableObject> readObjs = new Vector<SerializableObject>();
            
            SerializableObject myRecordRet;
            for(int i = 0; i < numObjs; i++) {
                myRecordRet = ((RestoreI) cpointRef).readObj("XML");
                readObjs.add(myRecordRet);
            }
            fp.closeReading();
            for(int i = 0; i < readObjs.size(); i++) {
                System.out.println(readObjs.get(i).toString());
            }
        }
    }
}