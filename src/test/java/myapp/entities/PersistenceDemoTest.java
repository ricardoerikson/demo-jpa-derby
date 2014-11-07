package myapp.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class PersistenceDemoTest {

    
    private static final Logger LOGGER = LogManager.getLogger(PersistenceDemoTest.class);

    @BeforeClass
    public static void setUp() {
	LOGGER.info("");
    }

    @AfterClass
    public static void tearDown() {

    }

}
