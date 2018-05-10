package org.mytuc.dstruc.group12.helper;

public class DEBUG {
    private DEBUG() {
    }
    // TODO: extend DEBUG class with static method to concatenate log strings and save that one to a file
    // TODO: extend DEBUG class with static method to save that one to a given file
    private static boolean useOutput = true;

    public static void log(String logMessage) {
        if (useOutput)
            System.out.println(logMessage);
    }

    public static void setOutput(boolean status) {
        useOutput = status;
    }

    public static void logHeading(String headString) {
        if (!useOutput)
            return;
        System.out.println("\n# ".concat(getHeadingStripe( headString)));
        System.out.println("|      " + headString+"      |");
        System.out.println("# ".concat(getHeadingStripe( headString)));
    }
    private static String getHeadingStripe(String headingString){
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < headingString.length() + 10; i++)
            s.append('-');
        return s.append(" #").toString();
    }
}
