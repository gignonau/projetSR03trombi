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
	
	@POST
	@Path("/UV/{codeUV}/jour/{jour}/horaireD/{hd}/horaireF/{hf}/salle/{salle}/type/{type}/responsable/{responsable}")
	public Response post(@PathParam("codeUV") String codeUV,
						@PathParam("jour") String jour,
						@PathParam("hd") String hd,
						@PathParam("hf") String hf,
						@PathParam("salle") String salle,
						@PathParam("type") String type,
						@PathParam("responsable") String resp) {
        
		SeanceUV a = new SeanceUV(0,codeUV,jour, hd,hf,salle,type,resp);
		int res = SeanceDAO.insert(a);
        return Response.ok("Success ? : " +res).build();
    }
	
	
	@GET
	@Produces("application/json")
	public Response get() throws JsonProcessingException  {
		List<SeanceUV> a= SeanceDAO.findAll();
	         
	       
	    return Response.ok(Translator.toJsonLS(a)).build();
	}
	
	
	
}
