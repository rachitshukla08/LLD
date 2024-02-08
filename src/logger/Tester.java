package logger;

import logger.data.LogLevel;
import logger.factory.LoggerFactory;

public class Tester {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger();
        try {
            logger.log(LogLevel.ERROR, "DB Query failed");
            logger.log(LogLevel.DEBUG, "Received empty response");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
