package epsi.fr.B3C3.CPD.bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import epsi.fr.B3C3.CPD.classe.ImageToPDF;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
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
    private String finalPath = "a";
    private String contentType;
    private String fusionImage;
    private String trierImage;
    private String signerImage;
    private StreamedContent dFile;
    
    
//    public String getFinalPath() throws UnsupportedEncodingException {
//        return URLEncoder.encode(finalPath, "UTF8");
//    }

    public String getFinalPath() {
        return finalPath;
    }

    public void setFinalPath(String finalPath) {
        this.finalPath = finalPath;
    }
    
    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getCheminImg() {
        return cheminImg;
    }

    public void setCheminImg(String cheminImg) {
        this.cheminImg = cheminImg;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setdFile(StreamedContent dFile) {
        this.dFile = dFile;
    }
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
    
    public void downloadAction(){
        contentType = FacesContext.getCurrentInstance().getExternalContext().getMimeType(destination+ "a.pdf");
    }
    
    public StreamedContent getdFile() throws IOException{
        return new DefaultStreamedContent(new FileInputStream(destination+"a.pdf"), contentType);        
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
            this.setFinalPath(destination+fileName);
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
