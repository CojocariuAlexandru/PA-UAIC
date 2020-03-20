package Catalog;

import DocumentElements.DocumentElement;

import java.io.*;
import java.util.*;
// Serialization/Deserialization: https://www.tutorialspoint.com/java/java_serialization.htm

public class CatalogSaveLoad {
    public static void CatalogSaver(Catalog serializedCatalog) {
        try {
            // open file and writing stream
            FileOutputStream streamToExternalFile = new FileOutputStream("/src/CatalogStorage.ser");
            ObjectOutputStream objectStream = new ObjectOutputStream(streamToExternalFile);

            objectStream.writeObject(serializedCatalog);
            objectStream.close();
            streamToExternalFile.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Catalog CatalogLoader() {
        try {
            Catalog savedCatalog;

            //open file and reading stream
            FileInputStream streamToExternalFile = new FileInputStream("/src/CatalogStorage.ser");
            ObjectInputStream objectStream = new ObjectInputStream(streamToExternalFile);

            savedCatalog = (Catalog) objectStream.readObject();
            objectStream.close();
            streamToExternalFile.close();

            return savedCatalog;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Catalog class not found");
            c.printStackTrace();
            return null;
        }
    }

    public static void CatalogSaveInPlainText(Catalog catalogToBeTranscribed) {
        int i;
        String pathToFileStrorage = "./src/catalogGeneralInfo.txt";
        try {
            String transcribedCatalogName = catalogToBeTranscribed.getCatalogName();
            FileWriter fileWriter = new FileWriter(pathToFileStrorage);

            fileWriter.write("Catalog: " + transcribedCatalogName + "\n");
            for(i=0; i<catalogToBeTranscribed.getDocumentList().size(); i++){
                fileWriter.write("Document element " + (i+1) + ":\n");
                fileWriter.write("Document's name: " + catalogToBeTranscribed.getDocumentList().get(i).getDocumentName() + '\n');
                fileWriter.write("Document's path: " + catalogToBeTranscribed.getDocumentList().get(i).getDocumentPath() + '\n');
                fileWriter.write("Document's ID: " +   catalogToBeTranscribed.getDocumentList().get(i).getDocumentID()   + '\n');
                fileWriter.write("Document's tags: " + catalogToBeTranscribed.getDocumentList().get(i).getDocumentTags() + '\n');
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    public static void CatalogSaveInHTML(Catalog catalogToBeTranscribed) {
        int i;
        String pathToFileStrorage = "./src/catalogGeneralInfo.txt";
        try {
            String transcribedCatalogName = catalogToBeTranscribed.getCatalogName();
            FileWriter fileWriter = new FileWriter(pathToFileStrorage);

            fileWriter.write("<h1>Catalog: </h1>" + transcribedCatalogName + "\n");
            for(i=0; i<catalogToBeTranscribed.getDocumentList().size(); i++){
                fileWriter.write("<ul>");
                fileWriter.write("<li>Document element " + (i+1) + ":</li>\n");
                fileWriter.write("<li>Document's name: " + catalogToBeTranscribed.getDocumentList().get(i).getDocumentName() + ":</li>\n");
                fileWriter.write("<li>Document's path: " + catalogToBeTranscribed.getDocumentList().get(i).getDocumentPath() + ":</li>\n");
                fileWriter.write("<li>Document's ID: " +   catalogToBeTranscribed.getDocumentList().get(i).getDocumentID()   + ":</li>\n");
                fileWriter.write("<li>Document's tags: " + catalogToBeTranscribed.getDocumentList().get(i).getDocumentTags() + ":</li>\n");
                fileWriter.write("</ul>");
            }

            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
