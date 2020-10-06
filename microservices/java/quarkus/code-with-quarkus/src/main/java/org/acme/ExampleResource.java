package org.acme;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.acme.model.Beneficiario;
import org.acme.service.BeneficiarioService;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import io.quarkus.panache.common.Parameters;

@Path("/beneficiario")
public class ExampleResource {

	@Inject
	BeneficiarioService beneficiarioService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Beneficiario> beneficiario() {
		return beneficiarioService.findAll();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") final long id) {
		return Response.status(Status.OK).entity(Beneficiario.findById(id)).build();
	}

	@Transactional
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(@RequestBody Beneficiario beneficiarioRequest) {
		beneficiarioRequest.setId(null);
		beneficiarioRequest.persist();
		return Response.status(Status.CREATED).entity(beneficiarioRequest).build();
	}

	@Transactional
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response put(@PathParam("id") final long id, @RequestBody Beneficiario personFromRequest) {

		personFromRequest.setId(id);
		
		Parameters parameters = new Parameters();
		parameters.and("id", id);
		parameters.and("nomeBeneficiario", personFromRequest.getNomeBeneficiario());
		
		personFromRequest.update("update Beneficiario set nomeBeneficiario = :nomeBeneficiario where id=:id", parameters);
		
		return Response.status(Status.OK).entity(personFromRequest).build();
	}
	
	@Transactional
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") final long id) {
		Beneficiario.deleteById(id);
		return Response.status(Status.OK).entity(Response.noContent()).build();
	}
	
	/*
	 * @DeleteMapping("/{id}") public ResponseEntity<?> delete(@PathVariable("id")
	 * final long id) { return beneficiarioRepository.findById(id).map(p -> {
	 * beneficiarioRepository.deleteById(id); return ResponseEntity.ok().build();
	 * }).orElseThrow(() -> new BeneficiarioNotFoundException(id)); }
	 */
}