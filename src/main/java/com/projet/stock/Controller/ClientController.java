package com.projet.stock.Controller;
import com.projet.stock.Model.Client;
import com.projet.stock.Repository.ClientRepository;
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
public class ClientController {

    @Autowired
    ClientRepository ClientRepository;

    @GetMapping("/Client")
    public List<Client> getAllClients(){
        System.out.println("Get all Clients ........");
        List<Client> Clients=new ArrayList<>();
        ClientRepository.findAll().forEach(Clients:: add);
        return Clients;
    }


    @GetMapping("/Client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value="id") long id) throws ResourceNotFoundException {
        Client Client=ClientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Client not found"));
        return ResponseEntity.ok().body(Client);
    }

    @PostMapping("/Client")
    public ResponseEntity<String> saveClient(@Valid @RequestBody Client Client) throws ResourceNotFoundException {
        ClientRepository.save(Client);
        System.out.println("Client is added");
        return ResponseEntity.ok("is OK");
    }

    @DeleteMapping("/Client/{id}")
    private Map<String, Boolean> deleteClient(@PathVariable(value = "id") long id) throws ResourceNotFoundException{
        Client Client = ClientRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Impossible to delete Client cause is not found"));
        ClientRepository.delete(Client);
        Map<String,Boolean> response=new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return response;


    }

    @PutMapping("Client/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable("id") long id ,@Valid @RequestBody Client client) throws ResourceNotFoundException {
        Optional<Client> Client1 =ClientRepository.findById(id);
        if(Client1.isPresent()) {
            Client ancienClient =Client1.get();
            ancienClient.setCode(client.getCode());
            ancienClient.setLibelle(client.getLibelle());
            ancienClient.setAdresses(client.getAdresses());
            ancienClient.setAsuj(client.getAsuj());
            ancienClient.setContact(client.getContact());
            ancienClient.setEmail(client.getEmail());
            ancienClient.setLogin(client.getLogin()); ;
            ancienClient.setMatfisc(client.getMatfisc());
            ancienClient.setSolde(client.getSolde());
            ancienClient.setSolde_init(client.getSolde_init());
            ancienClient.setTimbre(client.getTimbre());
            ancienClient.setTel(client.getTel());
            return new ResponseEntity<>(ClientRepository.save(ancienClient), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
