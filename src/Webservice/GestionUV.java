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
	@Path("/{id}/SeanceUV")
	@Produces("application/json")
	public Response getAllSeanceUV(@PathParam("id") String id) throws JsonProcessingException  {
		
	    UV a = UVDAO.find(id);
		if( a == null){
			a =new UV("OO00","","");
	    } 
		
		List<SeanceUV> e= SeanceDAO.findAllSeanceUVFromUV(a);
	       
	    return Response.ok(Translator.toJsonLS(e)).build();
	}
	@GET
	@Path("/{id}/etudiant")
	@Produces("application/json")
	public Response getAllEtudiant(@PathParam("id") String id) throws JsonProcessingException  {
		
	    UV a = UVDAO.find(id);
		if( a == null){
			a =new UV("OO00","","");
	    } 
		
		List<Etudiant> e= EtudiantDAO.findAllEtudiantFromUV(a);
	       
	    return Response.ok(Translator.toJsonLE(e)).build();
	}
	
	
	@POST
	@Path("/{code}/{responsable}/{intitule}")
    public Response post(@PathParam("code") String code, @PathParam("responsable") String responsable, @PathParam("intitule") String intitule) {
        
		UV u = new UV(code,responsable,intitule);
		int res = UVDAO.insert(u);
        return Response.ok("Success ? : " +res).build();
    }
	
	
	
	
	
	
	
	@GET
	@Produces("application/json")
	public Response get() throws JsonProcessingException  {
		List<UV> a= UVDAO.findAll();
	         
	       
	    return Response.ok(Translator.toJsonLU(a)).build();
	}
		
}