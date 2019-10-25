package webservices;

import manage.ManageUtilisateur;
import beans.Utilisateur;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONObject;
import java.util.List;

@Path("/utilisateur")
public class UtilisateurRessource {

    // Read
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Utilisateur> handleGetAllUtilisateur() {
        return ManageUtilisateur.getAllUtilisateur();
    }

    // Read
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Utilisateur handleGetAUtilisateur(@PathParam("id") Integer id) {
        return ManageUtilisateur.getAUtilisateur(id);
    }

    // Create
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public String handleCreateAUtilisateur(String incomingData) {
        try {
            JSONObject obj = new JSONObject(incomingData);
            String login = obj.getString("login");
            String pass = obj.getString("pass");
            return ManageUtilisateur.createUtilisateur(login, pass);
        } catch (Exception e) {
            return "error " + e.toString();
        }
    }

    // Update
    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public String handleUpdateAUtilisateur(String incomingData) {
        try {
            JSONObject obj = new JSONObject(incomingData);
            String id = obj.getString("id");
            String login = obj.getString("login");
            String pass = obj.getString("pass");
            return ManageUtilisateur.updateAUtilisateur(id, login, pass);
        } catch (Exception e) {
            return "error " + e.toString();
        }
    }

    // Read
    @GET
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String handleDeleteAUtilisateur(@PathParam("id") Integer id) {
        return ManageUtilisateur.deleteAUtilisateur(id);
    }

    // Test if the user is in base
    @POST
    @Path("/testAuth")
    @Produces(MediaType.APPLICATION_JSON)
    public String handleTestAuthUtilisateur(String incomingData) {
        try {
            JSONObject obj = new JSONObject(incomingData);
            String login = obj.getString("login");
            String pass = obj.getString("pass");
            return ManageUtilisateur.isUser(login, pass);
        } catch (Exception e) {
            return "error " + e.toString();
        }
    }
}