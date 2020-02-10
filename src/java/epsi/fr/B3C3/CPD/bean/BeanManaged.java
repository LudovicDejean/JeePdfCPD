/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.fr.B3C3.CPD.bean;

import java.io.File;
import java.io.FileOutputStream;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import epsi.fr.B3C3.CPD.servlet.*;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author dejea
 */
@Named(value = "beanManaged")
@SessionScoped
public class BeanManaged implements Serializable{

    private String trierImage;

    public String getTrierImage() {
        return trierImage;
    }

    public void setTrierImage(String trierImage) {
        this.trierImage = trierImage;
    }
    
    @PostConstruct
    public void init() {
       trierImage = "trier.png";
    }
    /**
     * Creates a new instance of BeanManaged
     */
    public BeanManaged() {
//        CreatePdf CreatePdf;
    }
           
    
    
    
}
