package com.projet.stock.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private boolean completed;

}
