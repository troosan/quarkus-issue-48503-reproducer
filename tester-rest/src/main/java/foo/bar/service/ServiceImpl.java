package foo.bar.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import foo.bar.model.ServiceResponse;

@Path("/")
public class ServiceImpl {

	@GET
	public RestResponse<ServiceResponse> hello() {
		ServiceResponse response = new ServiceResponse();
		response.setTest("Hello World");
		return ResponseBuilder.ok(response).build();
	}

}
