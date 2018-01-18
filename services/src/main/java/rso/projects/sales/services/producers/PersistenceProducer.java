package rso.projects.sales.services.producers;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.enterprise.context.ApplicationScoped;

public class PersistenceProducer {

    @PersistenceUnit(unitName = "sales-jpa")
    private EntityManagerFactory emf;

    @Produces
    @ApplicationScoped
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void disposeEntityManager(@Disposes EntityManager entityManager) {

        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
