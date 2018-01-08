package rso.projects.sales.api.v1.resources;

import rso.projects.sales.Sale;
import rso.projects.sales.services.SalesBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import org.eclipse.microprofile.metrics.annotation.Metered;

@ApplicationScoped
@Path("/sales")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SalesResource {

    @Context
    private UriInfo uriInfo;

    @Inject
    private SalesBean salesBean;

    @GET
    @Metered
    public Response getSales() {

        List<Sale> sales = salesBean.getSales(uriInfo);

        return Response.ok(sales).build();
    }

    @GET
    @Path("/{saleId}")
    public Response getSale(@PathParam("saleId") String saleId) {

        Sale sale = salesBean.getSale(saleId);

        if (sale == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(sale).build();
    }

    @POST
    public Response createSale(Sale sale) {

        if (sale.getProductId() == null || sale.getProductId().isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {
            sale = salesBean.createSale(sale);
        }

        if (sale.getId() != null) {
            return Response.status(Response.Status.CREATED).entity(sale).build();
        } else {
            return Response.status(Response.Status.CONFLICT).entity(sale).build();
        }
    }

    @PUT
    @Path("{saleId}")
    public Response putSale(@PathParam("saleId") String saleId, Sale sale) {

        sale = salesBean.putSale(saleId, sale);

        if (sale == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        } else {
            if (sale.getId() != null)
                return Response.status(Response.Status.OK).entity(sale).build();
            else
                return Response.status(Response.Status.NOT_MODIFIED).build();
        }
    }

    @DELETE
    @Path("{saleId}")
    public Response deleteSale(@PathParam("saleId") String saleId) {

        boolean deleted = salesBean.deleteSale(saleId);

        if (deleted) {
            return Response.status(Response.Status.GONE).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
