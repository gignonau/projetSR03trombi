package Webservice;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

import DAO.*;
import Beans.*;

@Path("/etudiant")
public class GestionEtudiant {
	
	
	@GET 
	@Path("/{id}")
	@Produces("application/json")
	public Response getWithLogin(@PathParam("id") String id) throws JsonProcessingException  {
		Etudiant a= EtudiantDAO.find(id);
	    
		if( a == null){
			a =new Etudiant("","","","","","");
	    }        
	       
	    return Response.ok(Translator.toJson(a)).build();
	 }
	
	@GET
	@Path("/nom/{nom}")
	@Produces("application/json")
    public Response getWithName(@PathParam("nom") String nom) throws JsonProcessingException  {
		

		List<Etudiant> a= EtudiantDAO.findWith(nom);
        return Response.ok(Translator.toJsonLE(a)).build();
    }
	
	
	@GET
	@Path("/{id}/UV")
	@Produces("application/json")
    public Response getUV(@PathParam("id") String id) throws JsonProcessingException  {
		
		Etudiant e = EtudiantDAO.find(id);
	    
		if( e == null){
			e = new Etudiant("","","","","","");
	    } 
		
		List<UV> a= UVDAO.findAllUVFromEtudiant(e);
			
        return Response.ok(Translator.toJsonLU(a)).build();
    }
	
	@GET
	@Path("/{id}/edt")
	@Produces("application/json")
    public Response getEdt(@PathParam("id") String id) throws JsonProcessingException  {
		
		Etudiant e = EtudiantDAO.find(id);
	    
		if( e == null){
			e =new Etudiant("","","","","","");
	    } 
		
		List<SeanceUV> a= SeanceDAO.findAllSeanceUVFromEtudiant(e);
			
        return Response.ok(Translator.toJsonLS(a)).build();
    }
	
	
	
	@POST
	@Path("/login/{login}/{nom}/{prenom}/{branche}/{filiere}/{mail}")
    public Response post(@PathParam("login") String login,@PathParam("nom") String nom,@PathParam("prenom") String prenom,@PathParam("branche") String branche,@PathParam("filiere") String filiere,@PathParam("mail") String mail) {
        
		Etudiant a = new Etudiant(login,nom, prenom,branche, filiere, mail);
		int res = EtudiantDAO.insert(a);
        return Response.ok("Success ? : " +res).build();
    }
	
	
    @GET
    @Produces("application/json")
    public Response get() throws JsonProcessingException {
    	List<Etudiant> lE = EtudiantDAO.findAll();
    	
        return Response.ok(Translator.toJsonLE(lE)).build();
    }
	
}

