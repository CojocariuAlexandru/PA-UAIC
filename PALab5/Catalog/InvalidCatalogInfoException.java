package Catalog;

public class InvalidCatalogInfoException extends RuntimeException {
    public InvalidCatalogInfoException(String catalogName){
        super("Invalid catalog name: catalog's name has more than 50 characters");
    }
}
