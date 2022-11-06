package com.projet.stock.Controller;
import com.projet.stock.Model.Categorie;
import com.projet.stock.Repository.CategorieRepository;
import com.projet.stock.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategorieController {

    @Autowired
    CategorieRepository CategorieRepository;

    @GetMapping("/categories")
    public List<Categorie> getAllCategories(){
        System.out.println("Get all Categories ........");
        List<Categorie> categories=new ArrayList<>();
        CategorieRepository.findAll().forEach(categories:: add);
        return categories;
    }

    @GetMapping("/categorie/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable(value="id") long id) throws ResourceNotFoundException {
        Categorie categorie=CategorieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Categorie not found"));
        return ResponseEntity.ok().body(categorie);
    }

    @PostMapping("/categorie")
    public ResponseEntity<String> saveCategorie(@Valid @RequestBody Categorie Categorie) throws ResourceNotFoundException {
        CategorieRepository.save(Categorie);
        return ResponseEntity.ok("is OK");
    }

    @DeleteMapping("/categorie/{id}")
    private Map<String, Boolean> deleteCategorie(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
        Categorie Categorie = CategorieRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Impossible to delete Categorie cause is not found"));
        CategorieRepository.delete(Categorie);
        Map<String,Boolean> response=new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return response;
    }

    @PutMapping("categorie/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable("id") long id ,@Valid @RequestBody Categorie categorie) throws ResourceNotFoundException {
        Optional<Categorie> Categorie1 =CategorieRepository.findById(id);
        if(Categorie1.isPresent()) {
            Categorie ancienCategorie =Categorie1.get();
            ancienCategorie.setCode(categorie.getCode());
            ancienCategorie.setLibelle(categorie.getLibelle());
            return new ResponseEntity<>(CategorieRepository.save(ancienCategorie), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
