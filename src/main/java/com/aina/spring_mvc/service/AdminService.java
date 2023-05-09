/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aina.spring_mvc.service;

import com.aina.spring_mvc.hibernate.HibernateDao1;
import com.aina.spring_mvc.model.Admin;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LEGION
 */
@Service
public class AdminService {
    @Autowired 
    HibernateDao1 dao;

    public boolean loginAdmin(Admin admin){
        List<Admin> list = null;
        Boolean b = null;
        try{
            list = new ArrayList<>();
            list = dao.findAll(admin);
            if(admin.getNom().equals(list.get(0).getNom()) && admin.getMdp().equals(list.get(0).getMdp())){
                b = Boolean.TRUE;
            }
            else{
                b = Boolean.FALSE;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return b;
    }
    
}
