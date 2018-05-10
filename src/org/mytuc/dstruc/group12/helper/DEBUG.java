package org.mytuc.dstruc.group12.helper;

public class DEBUG {
    private DEBUG() {}

    private static boolean useOutput = true;
    public static void log(String logMessage){
        if(useOutput)
            System.out.println( logMessage );
    }
    public void setOutput(boolean status){
        useOutput = status;
    }
}
