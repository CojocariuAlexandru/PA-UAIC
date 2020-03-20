package Catalog;
import DocumentElements.DocumentElement;

public class InvalidDocumentListException extends RuntimeException {
    public InvalidDocumentListException(DocumentElement documentElement){
        super("The document list within a catalog cannot have duplicates (same ID twice). You attempted to insert the document with ID " + documentElement.getDocumentID() + " twice.");
    }
}
