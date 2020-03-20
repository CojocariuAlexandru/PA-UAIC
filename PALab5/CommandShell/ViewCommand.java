package CommandShell;
import Catalog.Catalog;

import java.util.*;
import static com.company.Main.catalogUser;

public class ViewCommand implements Command {
    private String catalogName;
    private Catalog loadedCatalog;
    private int documentToBeViewedID = 1;

    public void readCommand(){
        Scanner reader = new Scanner(System.in);
        catalogName = reader.next();
    }
    public void executeCommand(){
        readCommand();
        loadedCatalog = catalogUser.searchCatalogByName(catalogName);
        loadedCatalog.getDocumentByID(documentToBeViewedID).viewDocument();
    }
}