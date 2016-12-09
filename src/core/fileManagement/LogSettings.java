package core.fileManagement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class LogSettings {
    public LogSettings() {
        String loggingFilePath = "logging.properties";
        try (FileInputStream fileInputStream = new FileInputStream(loggingFilePath)) {
            LogManager.getLogManager().readConfiguration(fileInputStream);
        } catch (IOException e) {
            Logger logger = Logger.getLogger("");
            logger.log(Level.SEVERE, "Program crashed when trying to set up logging properties.", e);
            throw new RuntimeException("Could not load log properties");
        }
    }
}
