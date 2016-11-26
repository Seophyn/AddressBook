import java.io.IOException;
import java.util.logging.*;

public class LogSettings {
    private Logger logger = Logger.getLogger("");
    private FileHandler logFile;

    public LogSettings(){
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
    }
}
