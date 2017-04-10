package Webservice;


import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import Beans.*;
import DAO.*;

import com.fasterxml.jackson.core.JsonProcessingException;


@Path("/SeanceUV")
public class GestionSeanceUV {
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response get(@PathParam("id") int id) throws JsonProcessingException  {
		SeanceUV a= SeanceDAO.find(id);
	    
		if( a == null){
			a =new SeanceUV(-1,"","","","","","","");
	    }        
	       
	    return Response.ok(Translator.toJson(a)).build();
	}
	
	
	@GET
	@Produces("application/json")
	public Response get() throws JsonProcessingException  {
		List<SeanceUV> a= SeanceDAO.findAll();
	         
	       
	    return Response.ok(Translator.toJsonLS(a)).build();
	}
	
	
	
}
