/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.imageGrapper.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Narayan
 */
public class CSVHandler {
    
    public static void write(String fileName, String content) throws IOException{
       
        FileWriter writer=new FileWriter(fileName);
        writer.write(content);
        writer.close();
    
    }
    
}
