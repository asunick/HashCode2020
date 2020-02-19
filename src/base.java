import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class base {
    static File            inputfile;
    static FileReader      inputfr;
    static BufferedReader  inputbr;

    //This method prints "Hello Hashcode!" on the screen
    public static void main(String[] args) {
        ReturnType ln;
        System.out.println("Hello Hashcode!");
        openInputFile();
        ln=readLine();
        ln=readLine();
        ln=readLine();
    }


    //this method prepares the input file to be read
    static public void openInputFile(){
        try {
            inputfile   = new File(Constants.pathToFile);
            inputfr     = new FileReader(inputfile);
            inputbr     = new BufferedReader(inputfr);
        }
        catch(IOException e){
            System.err.println("Wrong input path! I'm exiting... ");
            e.printStackTrace();
            System.exit(1);
        }

    }

    //this method should be used to read a line of integers from a file
    static public ReturnType readLine() {
        String readed=null;
        try {
            readed=inputbr.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(readed==null){
            if(Constants.debug) System.out.println("(null) returned");
            return null;
        }

        //The parse from document is performed with Strings. Tmp allows us to convert a string into an int
        String[] tmp;
        tmp=readed.split(" ");

        //Initialising the returnType
        ReturnType returnType;
        returnType = new ReturnType(tmp.length);

        //Converts from String to int
        for(int i=0;i<tmp.length;i++){
            returnType.value[i]=Integer.parseInt(tmp[i]);
        }

        //if debug mode in on, the method prints the value returned
        if(Constants.debug) printLine(returnType);
        return returnType;
    }


    //this methos prints the velues inside rt
    static private void printLine(ReturnType rt){
        for(int i=0;i<rt.value.length;i++) System.out.println(rt.value[i]);
    }
}



//This class represents the return type of the methods in base class
class ReturnType{
    //here we use a int array to return data
    int[] value;
    //initializing the array
    ReturnType(int length){
        value=new int[length];
    }
}