/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import epsi.fr.B3C3.CPD.classe.ImageToPDF;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Legion
 */
@Named(value = "aleaBean")
@SessionScoped
public class AleaBean implements Serializable {

    private UploadedFile file;
    private String cheminImg = "";
    private String destination = "C:\\temp\\";
    private String fusionImage;
    private String trierImage;
    private String signerImage;


    public AleaBean() {

    }

    @PostConstruct
    public void init() {

        fusionImage = "fusion.png";
        trierImage = "trier.png";
        signerImage = "signer.png";
    }

    public String getFusionImage() {
        return fusionImage;
    }

    public void setFusionImage(String fusionImage) {
        this.fusionImage = fusionImage;
    }

    public String getTrierImage() {
        return trierImage;
    }

    public void setTrierImage(String trierImage) {
        this.trierImage = trierImage;
    }

    public String getSignerImage() {
        return signerImage;
    }

    public void setSignerImage(String signerImage) {
        this.signerImage = signerImage;
    }
    
    

    public void appelFonction(){
        ImageToPDF pdf = new ImageToPDF();
        
        pdf.writeUsingIText();
    }
    public void readPDf(){
        ImageToPDF pdf = new ImageToPDF();
        pdf.ReadPdf();
    }
    
    public void upload(FileUploadEvent event) {

        file = event.getFile();
        if (file != null) {

            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }

        try {
            copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String fileName, InputStream in) {
        try {

            OutputStream out = new FileOutputStream(new File(destination + fileName));
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
