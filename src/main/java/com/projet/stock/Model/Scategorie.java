package com.projet.stock.Model;

import javax.persistence.*;

@Entity
@Table(name = "scategorie")
public class Scategorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String code_categ;
    private String libelle;
    private long id_cat;

    public Scategorie() {
    }

    public Scategorie(long id, String code, String code_categ, String libelle) {
        this.id = id;
        this.code = code;
        this.code_categ = code_categ;
        this.libelle = libelle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode_categ() {
        return code_categ;
    }

    public void setCode_categ(String code_categ) {
        this.code_categ = code_categ;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Scategorie{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", code_categ='" + code_categ + '\'' +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
