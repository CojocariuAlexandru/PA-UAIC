package Catalog;

import DocumentElements.DocumentElement;

import javax.print.Doc;
import java.util.*;

public class Catalog {
    private String catalogName_;
    private List<DocumentElement> documentsAvailable_;
    CatalogInformationChecker catalogInformationChecker_;
    CatalogSaveLoad catalogSaverLoader_;

    public Catalog(String catalogName) {
        catalogInformationChecker_.validateCatalogName(catalogName);
        catalogName_ = catalogName;

        documentsAvailable_ = new ArrayList<>();
        catalogInformationChecker_ = new CatalogInformationChecker();
        catalogSaverLoader_ = new CatalogSaveLoad();
    }

    public void setCatalogName(String newCatalogName) {
        catalogInformationChecker_.validateCatalogName(newCatalogName);
        catalogName_ = newCatalogName;
    }

    public void addNewDocument(DocumentElement newDocument) {
        //Check if 'newDocument' can be appended to 'documentsAvailable' list
        catalogInformationChecker_.validateNewDocument(documentsAvailable_, newDocument);
        documentsAvailable_.add(newDocument);
    }

    public List<DocumentElement> getDocumentList() {
        return documentsAvailable_;
    }

    //Search in the catalog and return the document
    //that has ID = 'searchID'
    public DocumentElement getDocumentByID(int searchID){
        int i;
        for(i=0; i<documentsAvailable_.size(); i++)
            if(documentsAvailable_.get(i).getDocumentID() == searchID)
                return documentsAvailable_.get(i);
        return null;
    }

    public String getCatalogName() {
        return catalogName_;
    }

    public void saveCatalog(String method){
        if(method.compareTo("serialize") == 0){
            catalogSaverLoader_.CatalogSaver(this);
        }
        else if(method.compareTo("plainText") == 0){
            catalogSaverLoader_.CatalogSaveInPlainText(this);
        }
    }

    public Catalog loadCatalog(String method){
        return catalogSaverLoader_.CatalogLoader();
    }

}
