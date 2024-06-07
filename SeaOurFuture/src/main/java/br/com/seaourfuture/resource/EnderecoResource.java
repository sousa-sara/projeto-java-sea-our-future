package br.com.seaourfuture.resource;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.seaourfuture.bo.EnderecoBO;
import br.com.seaourfuture.model.Endereco;


@Path("/endereco")
public class EnderecoResource {

	private EnderecoBO enderecoBo = new EnderecoBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Endereco> selecionarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<Endereco>) enderecoBo.selecionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs (Endereco endereco, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		enderecoBo.inserirBo(endereco);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(endereco.getId()));
		return Response.created(builder.build()).build();			
	}
	
	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		enderecoBo.deletarBo(id);
		return Response.ok().build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarRs (Endereco endereco, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
		enderecoBo.atualizarBo(endereco);
		return Response.ok().build();
		
		
	}

}
