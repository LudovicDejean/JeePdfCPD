/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import epsi.fr.B3C3.CPD.classe.ImageToPDF;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author Legion
 */
@Named(value = "aleaBean")
@SessionScoped
public class AleaBean implements Serializable {


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
}
