package webservices;

import manage.ManageLivre;
import beans.Livre;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.codehaus.jettison.json.JSONObject;
import java.util.List;

@Path("/livres")
public class LivreRessource {

    // Read
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Livre> handleGetAllLivres() {
        return ManageLivre.getAllBook();
    }

    // Read
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Livre handleGetABook(@PathParam("id") Integer id) {
        return ManageLivre.getABook(id);
    }

    // Create
    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public String handleCreateABook(String incomingData) {
        try {
            JSONObject obj = new JSONObject(incomingData);
            String titre = obj.getString("titre");
            String annee = obj.getString("annee");
            String auteur = obj.getString("auteur");
            String prix = obj.getString("prix");
            String img = obj.getString("image");
            return ManageLivre.createABook(titre, annee, auteur, prix, img);
        } catch (Exception e) {
            return "error " + e.toString();
        }
    }

    // Update
    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_JSON)
    public String handleUpdateABook(String incomingData) {
        try {
            JSONObject obj = new JSONObject(incomingData);
            String id = obj.getString("id");
            String titre = obj.getString("titre");
            String annee = obj.getString("annee");
            String auteur = obj.getString("auteur");
            String prix = obj.getString("prix");
            String img = obj.getString("image");
            return ManageLivre.updateABook(id, titre, annee, auteur, prix, img);
        } catch (Exception e) {
            return "error " + e.toString();
        }
    }

    // Read
    @GET
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String handleDeleteABook(@PathParam("id") Integer id) {
        return ManageLivre.deleteABook(id);
    }
}