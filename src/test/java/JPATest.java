
import Pack.Topic;
import org.junit.Assert;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATest {

    public void performJPA() {

        // Creating objects representing some products
        Topic product1 = new Topic("ahmed","software",322);
        product1.setMax_Students(2332);
        product1.setDescription("Ahmed");

        Topic product2 = new Topic("khatt","software", 333);
        product2.setMax_Students(21313);
        product2.setDescription("Khattab");

        // Connecting to the database through EntityManagerFactory
        // connection details loaded from persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

        EntityManager em = emf.createEntityManager();

        // Creating a new transaction
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Persisting the product entity objects
        em.persist(product1);
        em.persist(product2);

        tx.commit();

        // Querying the contents of the database using JPQL query
        Query q = em.createQuery("SELECT topic FROM Topic topic");

        @SuppressWarnings("unchecked")
        List<Topic> results = q.getResultList();

        System.out.println("List of names\n----------------");

        for (Topic bud : results) {

            System.out.println(bud.getDescription() + " (phone numbers=" + bud.getMax_Students() + ")");
            Assert.assertTrue(bud.equals(product1) || bud.equals(product2));
        }

        // Closing connection
        em.close();

        emf.close();
    }
    public static void  main(String args[]){
        JPATest t = new JPATest();
        t.performJPA();
    }
}
