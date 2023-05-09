/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aina.spring_mvc.controller;

import com.aina.spring_mvc.hibernate.HibernateDao1;
import com.aina.spring_mvc.model.Admin;
import com.aina.spring_mvc.model.Contenu;
import com.aina.spring_mvc.model.Validite;
import com.aina.spring_mvc.service.AdminService;
import com.aina.spring_mvc.service.ContenuService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;











/**
 *
 * @author LEGION
 */
@Controller
public class TesteController {
    @Autowired
    HibernateDao1 dao;
    
    @Autowired
    AdminService adminService;
    
    @Autowired
    ContenuService contenuService;
    
    @GetMapping("/IntelligenceArtificielle/AcceuilPage")
    public String getPageAcceuil(){
        return "acceuil";
    }
    
    @GetMapping("/IntelligenceArtificielle/LoginPage")
    public String getPageLoginAdmin(){
        return "login";
    }
    

    
    @PostMapping("/IntelligenceArtificielle/TraitLogin")
    public String traitLogin(@RequestParam("nom") String nom, @RequestParam("mdp") String mdp, HttpSession session){ 
        Admin admin = null;
        Boolean b = null;
        String redirect = null;
        try{
            admin = new Admin();
            admin.setNom(nom);
            admin.setMdp(mdp);
            admin.setId(1);
            b = adminService.loginAdmin(admin);
            if(b== true){
                admin = (Admin) dao.findById(admin);
                session.setAttribute("admin", admin);
                redirect="acceuil";
            }
            else{
                redirect = "login";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return redirect;
    }
    
    @GetMapping("/IntelligenceArtificielle/ContenuValidePage")
    public String getPageContenuValide(Model model){ 
        Contenu contenu = null;
        try{
            contenu = new Contenu();
             model.addAttribute("contenuvalide", contenuService.getAllContenuValide(contenu));
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "listeContenuValide";
    }
    
    @GetMapping("/IntelligenceArtificielle/ContenuNonValidePage")
    public String getPageContenuNonValide(Model model){ 
        Contenu contenu = null;
        try{
            contenu = new Contenu();
             model.addAttribute("contenunonvalide", contenuService.getAllContenuNonValide(contenu));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "listeContenuNonValide";
    }
    
    
    @GetMapping("/IntelligenceArtificielle/AjoutContenuPage")
    public String getPageContenuNonValide(){
        return "ajoutContenu";
    }
    
    
    @PostMapping("/IntelligenceArtificielle/TraitAjout")
    public String postImage(@RequestParam("sary") MultipartFile file, HttpSession session, @RequestParam("titre") String titre,
            @RequestParam("daty") Date date, @RequestParam("contenu") String contenu) throws IOException{
      ServletContext context = null;
        String path = null;
        String filename = null;
        Contenu contains = null;

        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        
        Validite validite = null;
        byte[] bytes = file.getBytes();

        try {
            validite = new Validite();
            contains = new Contenu();
            context = session.getServletContext();
            path = context.getRealPath("/resources/theme/img");

            filename = file.getOriginalFilename();

            fileOutputStream = new FileOutputStream(new File(path + File.separator + filename));

            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            bufferedOutputStream.write(bytes);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            contains.setTitre(titre);
            contains.setDaty(date);
            validite.setId(1);
            contains.setValidite(validite);
            contains.setContenu(contenu);
            contains.setImage("/resources/theme/img/" + filename);
            dao.save(contains);
    }
        catch(Exception e){
            e.printStackTrace();
        }
        return "acceuil";
    }
    
    @GetMapping("/IntelligenceArtificielle/Supprimer/{id}")
    public String validerStatut(@PathVariable(value="id") int idContenu){ 
        Contenu contenu = null;
        try{
            contenu = new Contenu();
            contenu.setId(idContenu);
            contenuService.changerValidite(contenu);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "acceuil";
    }
    
    @GetMapping("/IntelligenceArtificielle/pageModif/{id}")
    public String getModif(@PathVariable(value="id") int idContenu, Model model){
       Contenu contenu = null;
       try{
           contenu = new Contenu();
           contenu.setId(idContenu);
           contenu = (Contenu) dao.findById(contenu);
           model.addAttribute("contenu", contenu);
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return "updateContenu";
   }
    
    
    @PostMapping("/IntelligenceArtificielle/modifier/{id}")
    public String getModifier(@PathVariable(value="id") int idContenu, @RequestParam("titre") String titre,
             @RequestParam("contenu") String contenu){
       Contenu contenus = null;
       Validite validite = null;
       Contenu m = null;
       try{
           m = new Contenu();
           validite = new Validite();
           validite.setId(1);
           contenus = new Contenu();
           m.setId(idContenu);
           m = (Contenu) dao.findById(m);
           contenus.setId(idContenu);
           contenus.setTitre(titre);
           contenus.setDaty(m.getDaty());
           contenus.setValidite(validite);
           contenus.setImage(m.getImage());
           contenus.setContenu(contenu);
           dao.update(contenus);
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return "acceuil";
   } 
    
    
    @GetMapping("/IntelligenceArtificielle/detail/{id}")
    public String getDetail(@PathVariable(value="id") int idContenu, Model model){
       Contenu contenu = null;
       try{
           contenu = new Contenu();
           contenu.setId(idContenu);
           contenu = (Contenu) dao.findById(contenu);
           model.addAttribute("contenu", contenu);
       }
       catch(Exception e){
           e.printStackTrace();
       }
       return "listeContenu";
   }
    
    @GetMapping("/IntelligenceArtificielle/LogOut")
    public String LogOut(HttpSession session){
        try{
            session.invalidate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return "login";
    }
            
    
   
}
