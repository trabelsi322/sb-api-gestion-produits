package soa.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import soa.entities.Categorie;
import soa.repository.CategorieRepository;

@RestController // pour déclarer un service web de type REST
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/categories")  //    http://localhost:8080/produits
public class CategorieRESTController {
    @Autowired // pour l'injection de dépendances
    private CategorieRepository categorieRepos;

    //  Message d'accueil
    //  http://localhost:8080/produits/index  (GET)
    @GetMapping(value ="/index" )
    public String accueil() {
        return "BienVenue au service Web REST 'produits'.....";
    }

    //  Afficher la liste des produits
    //  http://localhost:8080/produits/ (GET)

    @GetMapping(
            // spécifier le path de la méthode
            value= "/",
            // spécifier le format de retour en XML
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )
    public  List<Categorie> getAllCategories() {
        return categorieRepos.findAll();

    }

}