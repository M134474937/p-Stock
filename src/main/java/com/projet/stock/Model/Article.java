package com.projet.stock.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String code;
    @NotBlank(message = "Libelle is important")
    private String libelle;
    private float pa;
    private int tva;
    private int fodec;
    private float pv;
    private float stkinit;
    private float stock;
    private long id_cat;
    private long id_scat;

    public Article() {
    }

    public Article(long id, String code, String libelle, float pa, int tva, int fodec, float pv, float stkinit, float stock) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.pa = pa;
        this.tva = tva;
        this.fodec = fodec;
        this.pv = pv;
        this.stkinit = stkinit;
        this.stock = stock;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPa() {
        return pa;
    }

    public void setPa(float pa) {
        this.pa = pa;
    }

    public int getTva() {
        return tva;
    }

    public void setTva(int tva) {
        this.tva = tva;
    }

    public int getFodec() {
        return fodec;
    }

    public void setFodec(int fodec) {
        this.fodec = fodec;
    }

    public float getPv() {
        return pv;
    }

    public void setPv(float pv) {
        this.pv = pv;
    }

    public float getStkinit() {
        return stkinit;
    }

    public void setStkinit(float stkinit) {
        this.stkinit = stkinit;
    }

    public float getStock() {
        return stock;
    }

    public void setStock(float stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                ", pa=" + pa +
                ", tva=" + tva +
                ", fodec=" + fodec +
                ", pv=" + pv +
                ", stkinit=" + stkinit +
                ", stock=" + stock +
                '}';
    }
}
