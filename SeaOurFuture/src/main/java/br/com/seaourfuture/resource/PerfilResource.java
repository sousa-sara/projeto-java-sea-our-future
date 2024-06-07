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

import br.com.seaourfuture.bo.PerfilBO;
import br.com.seaourfuture.model.Perfil;

@Path("/perfil")
public class PerfilResource {

	private PerfilBO perfilBo = new PerfilBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Perfil> selecionarRs() throws ClassNotFoundException, SQLException {
		return (ArrayList<Perfil>) perfilBo.selecionarBo();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Perfil perfil, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
		perfilBo.inserirBo(perfil);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(perfil.getId()));
		return Response.created(builder.build()).build();
	}

	@DELETE
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
		perfilBo.deletarBo(id);
		return Response.ok().build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizarRs(Perfil perfil, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
		perfilBo.atualizarBo(perfil);
		return Response.ok().build();

	}

}
