package com.projet.stock.Controller;
import com.projet.stock.Model.Fournisseur;
import com.projet.stock.Repository.FournisseurRepository;
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
public class FournisseurController {

    @Autowired
    FournisseurRepository FournisseurRepository;

    @GetMapping("/Fournisseurs")
    public List<Fournisseur> getAllFournisseurs(){
        System.out.println("Get all Fournisseurs ........");
        List<Fournisseur> Fournisseurs=new ArrayList<>();
        FournisseurRepository.findAll().forEach(Fournisseurs:: add);
        return Fournisseurs;
    }

    @GetMapping("/Fournisseur/{id}")
    public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable(value="id") long id) throws ResourceNotFoundException {
        Fournisseur Fournisseur=FournisseurRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Fournisseur not found"));
        return ResponseEntity.ok().body(Fournisseur);
    }

    @PostMapping("/Fournisseur")
    public ResponseEntity<String> saveFournisseur(@Valid @RequestBody Fournisseur Fournisseur) throws ResourceNotFoundException {
        FournisseurRepository.save(Fournisseur);
        return ResponseEntity.ok("is OK");
    }

    @DeleteMapping("/Fournisseur/{id}")
    private Map<String, Boolean> deleteFournisseur(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
        Fournisseur Fournisseur = FournisseurRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Impossible to delete Fournisseur cause is not found"));
        FournisseurRepository.delete(Fournisseur);
        Map<String,Boolean> response=new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return response;
    }

    @PutMapping("Fournisseur/{id}")
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable("id") long id ,@Valid @RequestBody Fournisseur Fournisseur) throws ResourceNotFoundException {
        Optional<Fournisseur> Fournisseur1 =FournisseurRepository.findById(id);
        if(Fournisseur1.isPresent()) {
            Fournisseur ancienFournisseur =Fournisseur1.get();
            ancienFournisseur.setCode(Fournisseur.getCode());
            ancienFournisseur.setLibelle(Fournisseur.getLibelle());
            ancienFournisseur.setAdresses(Fournisseur.getAdresses());
            ancienFournisseur.setAsuj(Fournisseur.getAsuj());
            ancienFournisseur.setContact(Fournisseur.getContact());
            ancienFournisseur.setEmail(Fournisseur.getEmail());
            ancienFournisseur.setMatfisc(Fournisseur.getMatfisc());
            ancienFournisseur.setSolde(Fournisseur.getSolde());
            ancienFournisseur.setSolde_init(Fournisseur.getSolde_init());
            ancienFournisseur.setTimbre(Fournisseur.getTimbre());
            ancienFournisseur.setTel(Fournisseur.getTel());
            return new ResponseEntity<>(FournisseurRepository.save(ancienFournisseur), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
