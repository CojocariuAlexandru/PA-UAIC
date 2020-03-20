package DocumentElements;

import java.util.*;

public class DocumentElement {
    private int documentID_;
    private String documentName_;
    private String documentPath_; // path to document - locally or via URL
    private Map<String, String> documentTags_; // tagName -> tagValue | ex: publishingDate -> 1999
    private DocumentViewer documentViewer;

    public DocumentElement(int documentID, String documentPath) {
        documentID_ = documentID;
        documentPath_ = documentPath;

        documentTags_ = new HashMap<>();
        documentViewer = new DocumentViewer();
    }

    public void setDocumentID(int newDocumentID) {
        documentID_ = newDocumentID;
    }

    public void setDocumentName(String newDocumentName) {
        documentName_ = newDocumentName;
    }

    public void setDocumentPath(String newDocumentPath) {
        documentPath_ = newDocumentPath;
    }

    public void addDocumentTag(String tagTitle, String tagValue) {
        documentTags_.put(tagTitle, tagValue);
    }

    public int getDocumentID() {
        return documentID_;
    }

    public String getDocumentName() {
        return documentName_;
    }

    public String getDocumentPath() {
        return documentPath_;
    }

    public Map<String, String> getDocumentTags(){
        return documentTags_;
    }

    public void viewDocument(){
        documentViewer.viewDocument(this);
    }
}
