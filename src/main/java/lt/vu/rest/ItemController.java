package lt.vu.rest;

import lombok.Getter;
import lombok.Setter;
import lt.vu.decorators.IDeleter;
import lt.vu.decorators.ItemDeleter;
import lt.vu.entities.Item;
import lt.vu.interceptors.LoggedInvocation;
import lt.vu.persistence.ItemDAO;
import lt.vu.rest.contracts.ItemDto;
import lt.vu.services.ItemService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/items")
public class ItemController {

    @Inject
    @Setter
    @Getter
    private ItemService itemService;

    @Inject
    private EntityManager em;

    @Inject
    private ItemDAO itemDAO;

    @Inject
    private ItemDeleter itemDeleter;

    @LoggedInvocation
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get() {
        List<ItemDto> itemsDto = new ArrayList<>();
        for(Item item : itemService.getAll())
            itemsDto.add(new ItemDto(item));
        return Response.ok(itemsDto).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") final Integer id) {
        return Response.ok(new ItemDto(itemService.get(id))).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(ItemDto itemDto) {
        return Response.ok(new ItemDto(itemService.createFrom(itemDto))).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer id, ItemDto itemDTO) {
        return Response.ok(new ItemDto(itemService.updateFrom(itemDTO, id))).build();
    }

    @Path("/{id}/optimistic")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Response updateOptimistic(@PathParam("id") final Integer id, ItemDto itemDTO) throws InterruptedException {
            return Response.ok(new ItemDto(itemService.updateFromOptimistic(itemDTO, id))).build();
    }

    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response delete(@PathParam("id") final Integer id) {
        return Response.ok(new ItemDto(itemDeleter.deleteById(id))).build();
    }
}
