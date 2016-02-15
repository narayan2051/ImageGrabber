/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.imageGrapper;


import com.leapfrog.imageGrapper.util.Grabber;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Narayan
 */
public class Program {
    
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter URL:");
        Grabber grabber=new Grabber(scan.next());
        try{
        String content=(grabber.grab());
        String refPattern="graphics/model/(.*?)/thumb/(.*?)\\.jpg";
        Pattern pattern=Pattern.compile(refPattern);
        Matcher match=pattern.matcher(content);
           while(match.find()){
            String fullUrl="http://cybersansar.com/"+ match.group().replace(" ", "%20");
            
               System.out.println(fullUrl);
            fullUrl=fullUrl.replace("/thumb","");
            String folderPath=match.group(1);
            File file=new File(folderPath);
            if(!file.isDirectory()){
                file.mkdir();
            }
                    
            URL url=new URL(fullUrl);
            URLConnection conn=url.openConnection();
               
               InputStream is=conn.getInputStream();
               OutputStream os=new FileOutputStream(folderPath + "/"+match.group(2)+".jpg");
               byte[] data=new byte[1024];
               int i=0;
               
               while((i=is.read(data))!=-1){
                   
                   os.write(data,0,i);
                   
               }
               os.close();
               is.close();
               
            
            
        }
        }catch(IOException ioe){
            ioe.getMessage();
        }
        
        
     
        
}
}