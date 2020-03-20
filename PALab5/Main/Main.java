package com.company;

import Catalog.Catalog;
import DocumentElements.DocumentElement;
import User.CatalogUser;

/**
 * Creates instances: users, catalog, documents
 */

public class Main {
    //Create instances : users, catalog, documents
    public static CatalogUser catalogUser = new CatalogUser(/*nameUser=*/"Alexandru",/*idUser=*/201);
    public static Catalog catalog = new Catalog(/*catalogName=*/"freshestCatalog");
    public static DocumentElement firstScreenshot = new DocumentElement(/*documentID=*/1, /*documentPath=*/"./src/firstScreenshot.png");
    public static DocumentElement secondScreenshot = new DocumentElement(/*documentID=*/2, /*documentPath=*/"./src/secondScreenshot.png");

    public static void main(String[] args) {

        catalogUser.addAvailableCatalog(catalog);
        catalog.addNewDocument(firstScreenshot);
        catalog.addNewDocument(secondScreenshot);

        catalogUser.viewDocumentElement(/*catalogName=*/"freshestCatalog", /*documentID=*/2);

        catalogUser.saveCatalog("freshestCatalog", "plainText");


    }
}
