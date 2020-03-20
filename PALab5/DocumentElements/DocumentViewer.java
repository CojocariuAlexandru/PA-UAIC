package DocumentElements;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;


public class DocumentViewer {
    //The document will be opened using the native operating system application
    public static void viewDocument(DocumentElement documentElement){
        File fileToBeOpened = new File(documentElement.getDocumentPath());
        Desktop desktop = Desktop.getDesktop();
        try{
            desktop.open(fileToBeOpened);
        }
        catch (IOException e){
            System.err.println("Fisierul cerut nu exista");
        }
    }
}
