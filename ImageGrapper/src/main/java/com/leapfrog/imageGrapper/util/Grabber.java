/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.imageGrapper.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Narayan
 */
public class Grabber {
    
    private String webUrl;

    public Grabber(String webUrl) {
        this.webUrl = webUrl;
    }

    public Grabber() {
    }
    
    
    public  String grab() throws IOException{
  
        URL uri= new URL(webUrl);
        
        URLConnection conn= uri.openConnection();
        
            BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder builder=new StringBuilder();
            String line="";
            while((line=reader.readLine())!=null){
                builder.append(line);
                
            }
            return builder.toString();
    } 
    
    public void setWebGrabber( String webUrl){
        this.webUrl=webUrl;
    }
        
    }
    

