package utility;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Tomáš Malčík
 */
public class NewHibernateUtil {
    
    private static SessionFactory sessionFactory;
    
    /**
     * Factory method for database session
     * @return Session
     */
    public static SessionFactory getSessionFactory() {
        if(sessionFactory==null){

            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml"); //hibernate config xml file name
            //cfg.getProperties().setProperty("hibernate.connection.url","jdbc:h2:"+System.getProperty("user.home") + File.separator + "Documents/Minigames/"+nazevDB);
            sessionFactory = cfg.buildSessionFactory();
        }
        return sessionFactory;
    }
    
    /**
     * Closes the connection with database
     */
    public static void shutDown() {
        try {
            sessionFactory.close();
            StandardServiceRegistryBuilder.destroy(sessionFactory.getSessionFactoryOptions().getServiceRegistry());
        //Seems like a bug, we need to explicitly destroy service registry!!
        }catch(Throwable t) {
            System.err.println("Exception while closing session factory: " + t);
        }
    }
}
