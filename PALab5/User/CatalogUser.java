package User;

import Catalog.Catalog;

import java.util.*;

public class CatalogUser extends UserInformationChecker {
    private String userName_;
    private int userID_;
    private List<Catalog> accessibleCatalogs;

    public CatalogUser(String userName, int userID) {
        validateUserName(userName);
        validateUserID(userID);

        userName_ = userName;
        userID_ = userID;
        accessibleCatalogs = new ArrayList<>();
    }

    public String getUserName() {
        return userName_;
    }

    public int getUserID() {
        return userID_;
    }

    public void setUserName(String newNameForUser) {
        validateUserName(newNameForUser);
        userName_ = newNameForUser;
    }

    public void setUserID(int newIdForUser) {
        validateUserID(userID_);
        userID_ = newIdForUser;
    }

    public void printUserInformation() {
        System.out.println("User's name: " + userName_);
        System.out.println("User's ID: " + userID_);
    }

    public void addAvailableCatalog(Catalog newCatalog) {
        accessibleCatalogs.add(newCatalog);
    }

    //Return from the accesible catalogs to this user,
    //the one with name 'catalogNameSearch'
    public Catalog searchCatalogByName(String catalogNameSearch){
        int i;
        for(i=0; i<accessibleCatalogs.size(); i++)
            if(accessibleCatalogs.get(i).getCatalogName().compareTo(catalogNameSearch) == 0)
                return accessibleCatalogs.get(i);
        return null;
    }

    //Open from the catalog 'catalogName' the document with ID 'documentID'
    public void viewDocumentElement(String catalogName, int documentID){
        searchCatalogByName(catalogName).getDocumentByID(documentID).viewDocument();
    }

    public void saveCatalog(String catalogName, String method){
        Catalog catalogFoundByName;
        catalogFoundByName = searchCatalogByName(catalogName);
        catalogFoundByName.saveCatalog(method);
    }

    public Catalog loadCatalog(String method){
        if(method.compareTo("serialize") == 0){
            Catalog auxCatalog = new Catalog("abc");
            auxCatalog = auxCatalog.loadCatalog("serialize");
            return auxCatalog;
        }
        else{
            return null;
        }
    }
}
