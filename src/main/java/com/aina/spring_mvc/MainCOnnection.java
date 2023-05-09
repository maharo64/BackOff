/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aina.spring_mvc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author LEGION
 */

public class MainCOnnection {
    
    
    public static void main(String[] args){
       String host = "containers-us-west-141.railway.app";
        String port ="5931";
        String username ="postgres";
        String password = "nOb71FFAG3R3TLI1fnCm";
        Connection conn = null;
        try{
             Class.forName("org.postgresql.Driver");
             //conn = DriverManager.getConnection("jdbc:postgresql://surus.db.elephantsql.com:5432/apnaszzh", "apnaszzh", "5zNvuy3djQngMsG_-hiSMzarYuAXwow7");
             conn = DriverManager.getConnection("jdbc:postgresql://balarama.db.elephantsql.com:5432/ymwvlgnn", "ymwvlgnn", "g1dZXsnUPR0hpMqZg4qSul0umQKeMhrM");
             
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
