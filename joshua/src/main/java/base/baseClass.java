package base;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.apache.logging.log4j.Logger;

public class baseClass {
    public static Logger log = LogManager.getLogger();

    @BeforeSuite
    public void setUp() {
        log.info("Hello, log has started.");
    }

    @AfterSuite
    public void tearDown() throws Exception {
        log.info("Goodbye, log has ended.");
    }

}