package com.projet.stock.Controller;
import com.projet.stock.Model.Scategorie;
import com.projet.stock.Repository.ScategorieRepository;
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
public class ScategorieController {

    @Autowired
    ScategorieRepository ScategorieRepository;

    @GetMapping("/Scategories")
    public List<Scategorie> getAllScategories(){
        System.out.println("Get all Scategories ........");
        List<Scategorie> Scategories=new ArrayList<>();
        ScategorieRepository.findAll().forEach(Scategories:: add);
        return Scategories;
    }

    @GetMapping("/Scategorie/{id}")
    public ResponseEntity<Scategorie> getScategorieById(@PathVariable(value="id") long id) throws ResourceNotFoundException {
        Scategorie Scategorie=ScategorieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Scategorie not found"));
        return ResponseEntity.ok().body(Scategorie);
    }

    @PostMapping("/Scategorie")
    public ResponseEntity<String> saveScategorie(@Valid @RequestBody Scategorie Scategorie) throws ResourceNotFoundException {
        ScategorieRepository.save(Scategorie);
        return ResponseEntity.ok("is OK");
    }

    @DeleteMapping("/Scategorie/{id}")
    private Map<String, Boolean> deleteScategorie(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
        Scategorie Scategorie = ScategorieRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Impossible to delete Scategorie cause is not found"));
        ScategorieRepository.delete(Scategorie);
        Map<String,Boolean> response=new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return response;
    }

    @PutMapping("Scategorie/{id}")
    public ResponseEntity<Scategorie> updateScategorie(@PathVariable("id") long id ,@Valid @RequestBody Scategorie Scategorie) throws ResourceNotFoundException {
        Optional<Scategorie> Scategorie1 =ScategorieRepository.findById(id);
        if(Scategorie1.isPresent()) {
            Scategorie ancienScategorie =Scategorie1.get();
            ancienScategorie.setCode(Scategorie.getCode());
            ancienScategorie.setLibelle(Scategorie.getLibelle());
            ancienScategorie.setCode_categ(Scategorie.getCode_categ());
            return new ResponseEntity<>(ScategorieRepository.save(ancienScategorie), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
