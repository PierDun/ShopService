package rest.resource;

import rest.dto.VehicleDto;
import rest.mapper.VehicleMapper;
import rest.model.Vehicle;
import rest.service.ShopService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/shop")
public class ShopResource {
    ShopService shopService = new ShopService();

    @GET
    @Path("/search/by-type/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllWithType (@PathParam("type") String type) {
        List<VehicleDto> dtos = shopService.getVehiclesWithType(type);
        return Response.status(Response.Status.OK).entity(dtos).build();
    }

    @POST
    @Path("/add-wheels/{vehicle-id}/{number-of-wheels}")
    public Response addWheels (@PathParam("vehicle-id") String id, @PathParam("number-of-wheels") String wheels) {
        VehicleDto dto = shopService.getVehicle(Integer.parseInt(id));
        shopService.addWheels(dto, Integer.parseInt(wheels));
        return shopService.updateVehicle(dto);
    }
}
