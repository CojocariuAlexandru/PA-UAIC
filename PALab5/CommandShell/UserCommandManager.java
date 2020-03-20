package CommandShell;

import java.util.*;


public class UserCommandManager {
    private ListCommand documentLister;
    private LoadCommand documentLoader;
    private ViewCommand documentViewer;
    private Scanner commandReader;
    private String typeOfCommand;

    public UserCommandManager() {
        documentLister = new ListCommand();
        documentLoader = new LoadCommand();
        documentViewer = new ViewCommand();
        commandReader = new Scanner(System.in);
    }

    public void startReadingCommands() {
        while (1 == 1) {
            typeOfCommand = commandReader.next();
            if (typeOfCommand.compareTo("load") == 0) {
                documentLoader.readCommand();
                documentLoader.executeCommand();
            } else if (typeOfCommand.compareTo("list") == 0) {
                documentLister.readCommand();
                documentLister.executeCommand();
            } else if (typeOfCommand.compareTo("view") == 0) {
                documentViewer.readCommand();
                documentViewer.executeCommand();
            } else {
                break;
            }
        }
    }
}
