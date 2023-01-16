package rest.resource;

import rest.dto.VehicleDto;
import rest.mapper.VehicleMapper;
import rest.model.Vehicle;
import rest.model.enums.VehicleType;
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
        boolean contains = false;

        for (VehicleType vehicleType : VehicleType.values()) {
            if (vehicleType.name().equals(type)) {
                contains = true;
                break;
            }
        }

        if (contains) {
            List<VehicleDto> dtos = shopService.getVehiclesWithType(type);
            return Response.status(Response.Status.OK).entity(dtos).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("Vehicle Type: There is no such type").build();
        }
    }

    @POST
    @Path("/add-wheels/{vehicle-id}/{number-of-wheels}")
    public Response addWheels (@PathParam("vehicle-id") String id, @PathParam("number-of-wheels") String wheels) {
        new VehicleDto();
        VehicleDto dto;

        try {
            dto = shopService.getVehicle(Integer.parseInt(id));
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ID: The following value can't be a number").build();
        }

        try {
            shopService.addWheels(dto, Integer.parseInt(wheels));
        } catch (NumberFormatException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Number of Wheels: The following value can't be a number").build();
        }

        return shopService.updateVehicle(dto);
    }
}
