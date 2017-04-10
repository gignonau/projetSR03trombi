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
	public Response get(@PathParam("id") int id) throws JsonProcessingException  {
		Etudiant a= EtudiantDAO.find(id);
	    
		if( a == null){
			a =new Etudiant(-1,"","","","","");
	    }        
	       
	    return Response.ok(Translator.toJson(a)).build();
	 }
	
	@GET
	@Path("/{nom}/nom")
	@Produces("application/json")
    public Response get(@PathParam("nom") String nom) throws JsonProcessingException  {
		

		List<Etudiant> a= EtudiantDAO.find(nom);
        return Response.ok(Translator.toJsonLE(a)).build();
    }
	
	
	@GET
	@Path("/{id}/UV")
	@Produces("application/json")
    public Response getUV(@PathParam("id") int id) throws JsonProcessingException  {
		
		Etudiant e = EtudiantDAO.find(id);
	    
		if( e == null){
			e = new Etudiant(-1,"","","","","");
	    } 
		
		List<UV> a= UVDAO.findAllUVFromEtudiant(e);
			
        return Response.ok(Translator.toJsonLU(a)).build();
    }
	
	@GET
	@Path("/{id}/edt")
	@Produces("application/json")
    public Response getEdt(@PathParam("id") int id) throws JsonProcessingException  {
		
		Etudiant e = EtudiantDAO.find(id);
	    
		if( e == null){
			e =new Etudiant(-1,"","","","","");
	    } 
		
		List<SeanceUV> a= SeanceDAO.findAllSeanceUVFromEtudiant(e);
			
        return Response.ok(Translator.toJsonLS(a)).build();
    }
	
	 
	
	@POST
	@Path("/{nom}/{prenom}/{branche}/{filiere}/{mail}")
    public Response post(@PathParam("nom") String nom,@PathParam("prenom") String prenom,@PathParam("branche") String branche,@PathParam("filiere") String filiere,@PathParam("mail") String mail) {
        
		Etudiant a = new Etudiant(0,nom, prenom,branche, filiere, mail);
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

