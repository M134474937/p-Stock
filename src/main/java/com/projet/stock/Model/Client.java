package com.projet.stock.Model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String code;
    private String libelle;
    private String contact;
    private String adresses;
    private String email;
    private String asuj;
    private String matfisc;
    private float solde_init;
    private String tel;
    private String timbre;
    private float solde;
    private String login;

    private String pwd;


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", libelle='" + libelle + '\'' +
                ", contact='" + contact + '\'' +
                ", adresses='" + adresses + '\'' +
                ", email='" + email + '\'' +
                ", asuj='" + asuj + '\'' +
                ", matfisc='" + matfisc + '\'' +
                ", solde_init=" + solde_init +
                ", tel='" + tel + '\'' +
                ", timbre='" + timbre + '\'' +
                ", solde=" + solde +
                ", login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }

    public Client(long id, String code, String libelle, String contact, String adresses, String email, String asuj, String matfisc, float solde_init, String tel, String timbre, float solde, String login,String pwd) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
        this.contact = contact;
        this.adresses = adresses;
        this.email = email;
        this.asuj = asuj;
        this.matfisc = matfisc;
        this.solde_init = solde_init;
        this.tel = tel;
        this.timbre = timbre;
        this.solde = solde;
        this.login = login;
        this.pwd=pwd;
    }

    public long getId() {
        return id;
    }

    public Client() {
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAdresses() {
        return adresses;
    }

    public void setAdresses(String adresses) {
        this.adresses = adresses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsuj() {
        return asuj;
    }

    public void setAsuj(String asuj) {
        this.asuj = asuj;
    }

    public String getMatfisc() {
        return matfisc;
    }

    public void setMatfisc(String matfisc) {
        this.matfisc = matfisc;
    }

    public float getSolde_init() {
        return solde_init;
    }

    public void setSolde_init(float solde_init) {
        this.solde_init = solde_init;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTimbre() {
        return timbre;
    }

    public void setTimbre(String timbre) {
        this.timbre = timbre;
    }

    public float getSolde() {
        return solde;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

}
