package genericCheckpointing.driver;

//import genericCheckpointing.util.ProxyCreator;

// import the other types used in this file

public class Driver {
    
    public static void main(String[] args) {
	
    //Initialize parameters
    String mode = args[0];
    int numObjs = 0;
    String file = args[2];
        
	if(args != 3) {
        System.err("Usage: <Mode> <NumObjs> <File>");
        System.exit(1);
    }
    
    if(args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")) {
        System.err("Usage: <Mode> <NumObjs> <File>");
        System.exit(1);
    }
        
    if(!(mode.equals("serdeser")) || !(mode.equals("deser"))) {
        System.err("Mode must be 'serdeser' or 'deser'");
        System.exit(1);
    }
        
    try{
        numObjs = Integer.parseInt(args[1]);
    }
    catch(NumberFormatException e) {
        System.err("NumObjs must be an int");
        System.exit(1);
    }
        
    
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

	// Use an if/switch to proceed according to the command line argument
	// For deser, just deserliaze the input file into the data structure and then print the objects
	// The code below is for "serdeser" mode
	// For "serdeser" mode, both the serialize and deserialize functionality should be called.

	// create a data structure to store the objects being serialized
        // NUM_OF_OBJECTS refers to the count for each of MyAllTypesFirst and MyAllTypesSecond
	for (int i=0; i<NUM_OF_OBJECTS; i++) {

	    // FIXME: create these object instances correctly using an explicit value constructor
	    // use the index variable of this loop to change the values of the arguments to these constructors
	    myFirst = new MyAllTypesFirst();
	    mySecond = new MyAllTypesSecond();

	    // FIXME: store myFirst and mySecond in the data structure
	    ((StoreI) cpointRef).writeObj(myFirst, "XML");
	    ((StoreI) cpointRef).writeObj(mySecond, "XML");

	}

	SerializableObject myRecordRet;

	// create a data structure to store the returned ojects
	for (int j=0; j<2*NUM_OF_OBJECTS; j++) {

	    myRecordRet = ((RestoreI) cpointRef).readObj("XML");
	    // FIXME: store myRecordRet in the vector
	}

	// FIXME: invoke a method on the handler to close the file (if it hasn't already been closed)

	// FIXME: compare and confirm that the serialized and deserialzed objects are equal. 
	// The comparison should use the equals and hashCode methods. Note that hashCode 
	// is used for key-value based data structures
    
    }
}