import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfIndirectObject;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.FileOutputStream;
import java.io.IOException;
 
public class ImgToPdf {
 
    public PdfContentByte manipulatePdf(String srcPdf, String srcImg, String dest) throws IOException, DocumentException {
        PdfReader reader = new PdfReader(srcPdf);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        Image image = Image.getInstance(srcImg);
        PdfImage stream = new PdfImage(image, "", null);
        stream.put(new PdfName(srcPdf), new PdfName(srcPdf+"WithImg"));
        PdfIndirectObject ref = stamper.getWriter().addToBody(stream);
        image.setDirectReference(ref.getIndirectReference());
        image.setAbsolutePosition(36, 400);
        PdfContentByte over = stamper.getOverContent(1);
        over.addImage(image);
        stamper.close();
        reader.close();
        return over;
    }
}