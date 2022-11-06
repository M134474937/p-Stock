package com.projet.stock.Repository;

import com.projet.stock.Model.Client;
import com.projet.stock.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
