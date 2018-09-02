import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class Controller {

    private ListsManagerService listsManagerService;

    public Controller() {
        this.listsManagerService = new ListsManagerService();
    }

    public String execute(ArrayList<String> command) throws InvalidCommandException {

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

        switch (command.get(0)){
            case "verify" :
                return this.listsManagerService.verify(command.get(1));
            case "add-whitelist" :
                return this.listsManagerService.addToWhiteList(command.get(1));
            case "add-blacklist" :
                return this.listsManagerService.addToBlackList(command.get(1));
            case "show-whitelist" :
                break;
            case "show-blacklist" :
                break;
            case "remove-whitelist" :
                break;
            case "remove-blacklist" :
                break;
            default:
                throw new InvalidCommandException("Command name not found.");
        }

        return "";
    }
}
