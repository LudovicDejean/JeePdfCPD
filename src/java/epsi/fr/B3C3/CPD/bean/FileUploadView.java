package epsi.fr.B3C3.CPD.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.System.in;
import static java.lang.System.out;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.shaded.commons.io.FilenameUtils;
import org.primefaces.shaded.commons.io.IOUtils;

@Named
@RequestScoped
public class FileUploadView {

    private UploadedFile file;
    private String cheminImg = "";
    private String afficheImg = "VaChercherImageServlet";
    private String destination = "C:\\temp\\";
    
    @PostConstruct
    public void Init(){
        
    }
    
    public String getAfficheImg() {
        return afficheImg;
    }

    public UploadedFile getFile() {
        return file;
    }
 
    public String getCheminImg() {
        return cheminImg;
    }

    public void setTexteTest(String texteTest) {
        this.cheminImg = texteTest;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getDestination() {
        return destination;
    }

    public void upload() throws IOException {
        if (file != null) {
            this.cheminImg = destination + file.getFileName();
            
            FacesMessage message = new FacesMessage("Votre fichier", file.getFileName() + " a bien été envoyé");
            FacesContext.getCurrentInstance().addMessage(null, message);
            String filename = FilenameUtils.getName(file.getFileName());
            InputStream input = file.getInputstream();
            OutputStream output = new FileOutputStream(new File(destination, filename));
            System.out.println("desti: " + destination + " - name " + filename);
            // Copy the contents of the file to the output stream
            try {
                IOUtils.copy(input, output);
            } finally {
                IOUtils.closeQuietly(input);
                IOUtils.closeQuietly(output);
            }
        }
    }

    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
