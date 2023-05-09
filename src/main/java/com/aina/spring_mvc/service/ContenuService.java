/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aina.spring_mvc.service;

import com.aina.spring_mvc.hibernate.HibernateDao1;
import com.aina.spring_mvc.model.Contenu;
import com.aina.spring_mvc.model.Validite;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LEGION
 */
@Service
public class ContenuService {
    
    @Autowired 
    HibernateDao1 dao;    
    
        public List<Contenu> getAllContenuValide(Contenu contenu){
        List<Contenu> list = null;
        try{
            list = new ArrayList<>();
            list = dao.findAllContenuValide(contenu); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
        
        
    public List<Contenu> getAllContenuNonValide(Contenu contenu){
        List<Contenu> list = null;
        try{
            list = new ArrayList<>();
            list = dao.findAllContenuInvalide(contenu); 
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }    
    
    public void changerValidite(Contenu contenu){
        Contenu contenu1 = null;
        Validite validite = null;
        try{
            validite = new Validite();
            contenu = (Contenu) dao.findById(contenu);
            contenu1 = new Contenu();
            contenu1.setId(contenu.getId());
            contenu1.setTitre(contenu.getTitre());
            contenu1.setDaty(contenu.getDaty());
            contenu1.setImage(contenu.getImage());
            contenu1.setContenu(contenu.getContenu());
            validite.setId(2);
            contenu1.setValidite(validite);
            dao.update(contenu1);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
