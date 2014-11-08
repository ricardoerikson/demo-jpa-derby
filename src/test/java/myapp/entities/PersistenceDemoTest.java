package myapp.entities;

import static org.junit.Assert.assertTrue;

import java.sql.DriverManager;
import java.sql.SQLNonTransientConnectionException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PersistenceDemoTest {

    private static final Logger LOGGER = LogManager.getLogger(PersistenceDemoTest.class);
    private static EntityManagerFactory emFactory;
    private static EntityManager em;

    @BeforeClass
    public static void setUp() throws Exception {
        LOGGER.info("Starting memory database for unit tests.");
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            DriverManager.getConnection("jdbc:derby:memory:unit-testing-jpa;create=true").close();
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("Exception during database startup");
        }

        LOGGER.info("Building EntityManager for unit tests");
//        try {
            emFactory = Persistence.createEntityManagerFactory("Demo");
            em = emFactory.createEntityManager();
//        } catch (Exception e) {
//            LOGGER.error("Exception during JPA EntityManager instanciation.");
//        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        LOGGER.info("Shutting Hibernate JPA layer.");
        if (em != null)
            em.close();
        if (emFactory != null)
            emFactory.close();

        LOGGER.error("Stopping memory database.");

        try {
            DriverManager.getConnection("jdbc:derby:memory:unit-testing-jpa;shutdown=true").close();
        } catch (SQLNonTransientConnectionException e) {
            if (e.getErrorCode() != 45000)
                throw e;
        }
    }

    @Test
    public void testPersistence()  {
//        try {
            em.getTransaction().begin();

            Pessoa p1 = new Pessoa();
            p1.setName("Ricardo");
            Pessoa p2 = new Pessoa();
            p2.setName("Erikson");

            em.persist(p1);
            em.persist(p2);

            assertTrue(em.contains(p1));
            assertTrue(em.contains(p2));

            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            e.printStackTrace();
//            LOGGER.error("Exception during testPersistence");
//        }
    }

}
