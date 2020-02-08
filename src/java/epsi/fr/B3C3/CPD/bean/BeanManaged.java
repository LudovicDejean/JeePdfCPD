/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package epsi.fr.B3C3.CPD.bean;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.FileOutputStream;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import epsi.fr.B3C3.CPD.servlet.*;
import java.io.IOException;

/**
 *
 * @author dejea
 */
@Named(value = "beanManaged")
@Dependent
public class BeanManaged {

    /**
     * Creates a new instance of BeanManaged
     */
    public BeanManaged() {
        CreatePdf CreatePdf;
    }
    
  
}
