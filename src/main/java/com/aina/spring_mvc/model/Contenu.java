/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aina.spring_mvc.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author LEGION
 */
@Entity
@Table(name="contenu")
public class Contenu extends BaseModel {
    
    @Column(name="titre")
    private String titre;
    @Column(name="daty")
    private Date daty;
    @Column(name="contenu")
    private String contenu;
    @ManyToOne
    @JoinColumn(name = "idvalidite")
    private Validite validite;
    @Column(name="image")
    private String image;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Validite getValidite() {
        return validite;
    }

    public void setValidite(Validite validite) {
        this.validite = validite;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    
    
    
    
    
    
    
    
}
