package Webservice;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;

import DAO.*;
import Beans.*;

@Path("/linkage")
public class GestionLien {

	@POST
	@Path("/etudiant/{idEtu}/UV/{idUV}")
	public Response assignUVtoEtudiant(@PathParam("idEtu") String idEtu, @PathParam("idUV") String idUV) throws JsonProcessingException  {
		
		
	    Etudiant e = EtudiantDAO.find(idEtu);
	    UV u = UVDAO.find(idUV);
	    
	    int res = LienDAO.assignUVtoEtudiant(e, u);
	       
	    return Response.ok("Sucess ? :"+ res).build();
	}
	
	@DELETE
	@Path("/etudiant/{idEtu}/UV/{idUV}")
	public Response suppUVFromEtudiant(@PathParam("idEtu") String idEtu, @PathParam("idUV") String idUV) throws JsonProcessingException  {
		
		
	    Etudiant e = EtudiantDAO.find(idEtu);
	    UV u = UVDAO.find(idUV);
	    
	    int res = LienDAO.suppUVFromEtudiant(e, u);
	       
	    return Response.ok("Sucess ? :"+ res).build();
	}
	
	@POST
	@Path("/etudiant/{idEtu}/SeanceUV/{idSeance}")
	public Response assignSeanceUVtoEtudiant(@PathParam("idEtu") String idEtu, @PathParam("idSeance")int  idSeance) throws JsonProcessingException  {
		
		
	    Etudiant e = EtudiantDAO.find(idEtu);
	    SeanceUV u = SeanceDAO.find(idSeance);
	    
	    int res = LienDAO.assignSeanceUVtoEtudiant(e, u);
	       
	    return Response.ok("Sucess ? :"+ res).build();
	}
	
	@DELETE
	@Path("/etudiant/{idEtu}/SeanceUV/{idSeance}")
	public Response suppSeanceUVFromEtudiant(@PathParam("idEtu") String idEtu, @PathParam("idSeance")int  idSeance) throws JsonProcessingException  {
		
		
	    Etudiant e = EtudiantDAO.find(idEtu);
	    SeanceUV u = SeanceDAO.find(idSeance);
	    
	    int res = LienDAO.suppSeanceUVFromEtudiant(e, u);
	       
	    return Response.ok("Sucess ? :"+ res).build();
	}
	
	
	
	
}
