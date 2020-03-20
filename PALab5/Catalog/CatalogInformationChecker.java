package Catalog;

import DocumentElements.DocumentElement;
import java.util.*;

public class CatalogInformationChecker {
    public static void validateCatalogName(String catalogName){
        if(catalogName.length() > 50 || catalogName.length() < 0)
            throw new InvalidCatalogInfoException(catalogName);
    }

    public static void validateNewDocument(List<DocumentElement> documentElementList, DocumentElement newDocument){
        int i;
        for(i=0; i<documentElementList.size(); i++){
            if(documentElementList.get(i).getDocumentID() == newDocument.getDocumentID())
                throw new InvalidDocumentListException(newDocument);
        }
    }
}
