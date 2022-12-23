package rest.service;

import rest.dto.VehicleDto;
import rest.model.Vehicle;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ShopService {
    private final String REST_URI
            = "http://localhost:8080/CRUDWithRestAndJSP/api/vehicles";

    Client client = ClientBuilder.newClient();

    public VehicleDto getVehicle (int id) {
        return client
                .target(REST_URI)
                .path(String.valueOf(id))
                .request(MediaType.APPLICATION_JSON)
                .get(VehicleDto.class);
    }

    public List<VehicleDto> getVehiclesWithType (String type) {
        WebTarget webTarget = client.target("http://localhost:8080/CRUDWithRestAndJSP/api/vehicles?type=" + type);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        List<VehicleDto> dtos = invocationBuilder.get(new GenericType<List<VehicleDto>>(){});
        return dtos;
    }

    public Response updateVehicle(VehicleDto vehicle) {
        return client
                .target(REST_URI)
                .path(vehicle.getId().toString())
                .request(MediaType.APPLICATION_JSON)
                .put(Entity.entity(vehicle, MediaType.APPLICATION_JSON));
    }

    public void addWheels (VehicleDto vehicle, int wheels) {
        vehicle.setNumberOfWheels(vehicle.getNumberOfWheels() + wheels);
    }
}
