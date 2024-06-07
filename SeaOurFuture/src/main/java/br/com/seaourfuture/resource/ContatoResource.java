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

import br.com.seaourfuture.bo.ContatoBO;
import br.com.seaourfuture.model.Contato;

@Path("/contato")
public class ContatoResource {

    private ContatoBO contatoBO = new ContatoBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Contato> selecionarRs() throws ClassNotFoundException, SQLException {
        return (ArrayList<Contato>) contatoBO.selecionarBo();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs(Contato contato, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException {
        contatoBO.inserirBo(contato);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(contato.getId()));
        return Response.created(builder.build()).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException {
        contatoBO.deletarBo(id);
        return Response.ok().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs(Contato contato, @PathParam("id") int id) throws ClassNotFoundException, SQLException {
        contatoBO.atualizarBo(contato);
        return Response.ok().build();
    }
}
