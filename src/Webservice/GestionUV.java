package Webservice;


import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import Beans.*;
import DAO.*;

import com.fasterxml.jackson.core.JsonProcessingException;


@Path("/UV")
public class GestionUV {
	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response get(@PathParam("id") String id) throws JsonProcessingException  {
		UV a= UVDAO.find(id);
	    
		if( a == null){
			a =new UV("OO00","","");
	    }        
	       
	    return Response.ok(Translator.toJson(a)).build();
	}
	
	
	@GET
	@Produces("application/json")
	public Response get() throws JsonProcessingException  {
		List<UV> a= UVDAO.findAll();
	         
	       
	    return Response.ok(Translator.toJsonLU(a)).build();
	}
	
	
	
}