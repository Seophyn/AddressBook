package Main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class LogSettings {
    private Logger logger = Logger.getLogger("");
    private FileHandler logFile;

   /* public LogSettings(){
        LogManager.getLogManager().reset();
        try{
            logFile = new FileHandler("log.log", true);
            logger.setLevel(Level.FINEST);
            logger.addHandler(logFile);
            SimpleFormatter formatter = new SimpleFormatter();
            logFile.setFormatter(formatter);
        } catch (SecurityException | IOException e){
            e.printStackTrace();
            logger.severe("Error when attempting to log to file.");
        }
    }*/

    public void setupLogging(){
        String loggingFilePath = "C:\\Users\\Jimmy\\Desktop\\AddressBook\\src\\logging.properties";
        try(FileInputStream fileInputStream = new FileInputStream(loggingFilePath)){
            LogManager.getLogManager().readConfiguration(fileInputStream);
            }catch(IOException e){
            logger.log(Level.SEVERE, "Blabla", e);
            throw new RuntimeException("could not load log properties");
        }
    }
}
