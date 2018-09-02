import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class Controller {

    private ListHandler whitelist;
    private ListHandler blacklist;

    public Controller() {
        this.whitelist = new ListHandler("whitelist.txt");
        this.whitelist = new ListHandler("blacklist.txt");
    }

    public String execute(ArrayList<String> command) throws InvalidCommandException {

        if(command.size() < 1 || command.size() > 2){
            throw new InvalidCommandException("Invalid number of arguments.");
        }

        if (command.size() == 2){
            try {
                URL url = new URL(command.get(1));
                url.toURI();
            } catch (MalformedURLException | URISyntaxException e) {
                throw new InvalidCommandException("Mal-formatted URL.");
            }
        }

        switch (command.get(0)){
            case "verify" :
                return this.verify(command.get(1));
            case "add-whitelist" :
                break;
            case "add-blacklist" :
                break;
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

    private String verify(String url) {
        if(whitelist.contains(url))
            return "safe";
        else if(whitelist.contains(url))
            return "unsafe";
        else return "unknown";
    }
}
