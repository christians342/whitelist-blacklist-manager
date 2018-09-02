import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class Controller {

    private ListsManagerService listsManagerService;

    public Controller() throws IOException {
        this.listsManagerService = new ListsManagerService();
    }

    public String execute(ArrayList<String> command) throws InvalidCommandException, IOException {

        checkStructure(command);

        switch (command.get(0)){
            case "verify" :
                return listsManagerService.verify(command.get(1));
            case "add-whitelist" :
                return listsManagerService.addToWhiteList(command.get(1));
            case "add-blacklist" :
                return listsManagerService.addToBlackList(command.get(1));
            case "show-whitelist" :
                return listsManagerService.showWhiteList();
            case "show-blacklist" :
                return listsManagerService.showBlackList();
            case "remove-whitelist" :
                return listsManagerService.removeFromWhiteList(command.get(1));
            case "remove-blacklist" :
                return listsManagerService.removeFromBlackList(command.get(1));
            default:
                throw new InvalidCommandException("Command name not found.");
        }
    }

    private void checkStructure(ArrayList<String> command) throws InvalidCommandException {
        if(command.size() < 1 || command.size() > 2)
            throw new InvalidCommandException("Invalid number of arguments.");
        else if (command.size() == 2){
                try {
                    URL url = new URL(command.get(1));
                    url.toURI();
                } catch (MalformedURLException | URISyntaxException e) {
                    throw new InvalidCommandException("Mal-formatted URL.");
                }
            //Was going to escape the url here to avoid it messing up my text files
            //Found no good way to do it in plain Java (without external libs)
        }
    }
}
