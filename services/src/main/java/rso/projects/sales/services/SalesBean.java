package rso.projects.sales.services;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import rso.projects.sales.Sale;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class SalesBean {

    private Logger log = Logger.getLogger(SalesBean.class.getName());

    @Inject
    private EntityManager em;

    public List<Sale> getSales(UriInfo uriInfo) {

        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery())
                .defaultOffset(0)
                .build();

        return JPAUtils.queryEntities(em, Sale.class, queryParameters);

    }

    public Sale getSale(String saleId) {

        Sale sale = em.find(Sale.class, saleId);

        if (sale == null) {
            throw new NotFoundException();
        }

        return sale;
    }

    public Sale createSale(Sale sale) {

        try {
            beginTx();
            em.persist(sale);
            commitTx();
        } catch (Exception e) {
            rollbackTx();
        }

        return sale;
    }

    public Sale putSale(String saleId, Sale sale) {

        Sale s = em.find(Sale.class, saleId);

        if (s == null) {
            return null;
        }

        try {
            beginTx();
            sale.setId(s.getId());
            sale = em.merge(sale);
            commitTx();
        } catch (Exception e) {
            rollbackTx();
        }

        return sale;
    }

    public void setSaleStatus(String salesId, String status) {

        Sale sale = em.find(Sale.class, salesId);

        if (sale == null) {
            throw new NotFoundException();
        }

        try {
            beginTx();
            sale.setStatus(status);
            sale = em.merge(sale);
            commitTx();
        } catch (Exception e) {
            rollbackTx();
        }

    }

    public boolean deleteSale(String saleId) {

        Sale sale = em.find(Sale.class, saleId);

        if (sale != null) {
            try {
                beginTx();
                em.remove(sale);
                commitTx();
            } catch (Exception e) {
                rollbackTx();
            }
        } else
            return false;

        return true;
    }

    private void beginTx() {
        if (!em.getTransaction().isActive())
            em.getTransaction().begin();
    }

    private void commitTx() {
        if (em.getTransaction().isActive())
            em.getTransaction().commit();
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive())
            em.getTransaction().rollback();
    }
}
