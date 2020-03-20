package CommandShell;
import Catalog.Catalog;

import java.util.*;
import static com.company.Main.catalogUser;

public class LoadCommand implements Command {
    String catalogName;
    Catalog loadedCatalog;

    public void readCommand(){
        Scanner reader = new Scanner(System.in);
        catalogName = reader.next();
    }
    public void executeCommand(){
        readCommand();
        loadedCatalog = catalogUser.searchCatalogByName(catalogName);
        loadedCatalog = loadedCatalog.loadCatalog("serialize");
    }
}
