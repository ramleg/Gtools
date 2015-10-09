package com.corp.globant.config;

import com.corp.globant.config.Config;
import com.corp.globant.MODEL.beans.*;
import com.google.gson.Gson;
import java.io.*;
import java.util.logging.*;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author ramiro.acoglanis
 */
public class Init implements ServletContextListener{
    
    public static Config config;
    
    public void contextInitialized(ServletContextEvent e){
        
        String path = getClass().getResource(File.separator).getPath();
        
        try {  
            BufferedReader br = new BufferedReader(new FileReader(path + "config.json"));
            config = new Gson().fromJson(br, Config.class);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Error loading Config File!!");
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("initialized.....ok");
    }
    
    public void contextDestroyed(ServletContextEvent e){
        System.out.println("goodbye");
    }
}
