package library.management.system;
import java.io.FileWriter;
import java.io.IOException;
public class Logs {
    public void log(String message){
        CurrentDateTime start = new CurrentDateTime();
        String currentDateTime = start.getDateTime();
        String currentDate = start.getDate();
        String outputPath = System.getProperty("user.dir")+"\\logs";
        
        try {
            FileWriter myWriter = new FileWriter(outputPath+"\\LOGS "+currentDate+".txt", true);
            myWriter.write(currentDateTime+" "+message+".\n");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
