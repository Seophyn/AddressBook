package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class LogSettings {
    private Logger logger = Logger.getLogger("");
    public void setupLogging(){
        String loggingFilePath = "C:\\Users\\Jimmy\\Desktop\\AddressBook\\src\\logging.properties";
        try(FileInputStream fileInputStream = new FileInputStream(loggingFilePath)){
            LogManager.getLogManager().readConfiguration(fileInputStream);
            }catch(IOException e){
            logger.log(Level.SEVERE, "Program crashed when trying to set up logging properties.", e);
            throw new RuntimeException("Could not load log properties");
        }
    }
}
