package br.com.seaourfuture.resource;

import java.sql.SQLException;
import java.text.ParseException;
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

import br.com.seaourfuture.bo.EmpresaBO;
import br.com.seaourfuture.excecoes.EmpresaDAOException;
import br.com.seaourfuture.model.Empresa; 


@Path("/empresa")
public class EmpresaResource { 

    private EmpresaBO empresaBo = new EmpresaBO(); 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Empresa> selecionarRs() throws ClassNotFoundException, SQLException, EmpresaDAOException { 
        return (ArrayList<Empresa>) empresaBo.selecionarBo(); 
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response inserirRs (Empresa empresa, @Context UriInfo uriInfo) throws ClassNotFoundException, SQLException, EmpresaDAOException, ParseException { 
        empresaBo.inserirBo(empresa); 
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(empresa.getId()));
        return Response.created(builder.build()).build();                    
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletarRs(@PathParam("id") int id) throws ClassNotFoundException, SQLException, EmpresaDAOException { 
        empresaBo.deletarBo(id); 
        return Response.ok().build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response atualizarRs (Empresa empresa, @PathParam("id") int id) throws ClassNotFoundException, SQLException, EmpresaDAOException { 
        empresaBo.atualizarBo(empresa); 
        return Response.ok().build();
    }
}
