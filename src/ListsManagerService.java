import java.io.IOException;

public class ListsManagerService {

    private ListHandler whiteList;
    private ListHandler blackList;

    public ListsManagerService() throws IOException {
        this.whiteList = new ListHandler("whitelist.txt");
        this.blackList = new ListHandler("blacklist.txt");
    }

    public String verify(String url) throws IOException {
        if(whiteList.contains(url))
            return "safe";
        else if(blackList.contains(url))
            return "unsafe";
        else return "unknown";
    }

    public String addToWhiteList(String url) throws InvalidCommandException, IOException {
        if(blackList.contains(url))
            throw new InvalidCommandException("Cannot add an element in whiteList if it is already in blackList.");
        if(whiteList.contains(url))
            throw new InvalidCommandException("Url already in whiteList.");

        whiteList.add(url);

        return "Successfully added to whiteList.";
    }

    public String addToBlackList(String url) throws InvalidCommandException, IOException {
        if(whiteList.contains(url))
            throw new InvalidCommandException("Cannot add an element in blackList if it is already in whiteList.");
        if(blackList.contains(url))
            throw new InvalidCommandException("Url already in blackList.");

        blackList.add(url);

        return "Successfully added to blackList.";
    }

    public String showWhiteList() throws IOException {
        return String.join("\n", whiteList.getUrls());
    }

    public String showBlackList() throws IOException {
        return String.join("\n", blackList.getUrls());
    }

    public String removeFromWhiteList(String url) throws IOException, InvalidCommandException {
        if(!whiteList.contains(url))
            throw new InvalidCommandException("Cannot remove element from whiteList if it is already not in whiteList.");
        whiteList.remove(url);
        return "Successfully removed from whiteList.";
    }

    public String removeFromBlackList(String url) throws IOException, InvalidCommandException {
        if(!blackList.contains(url))
            throw new InvalidCommandException("Cannot remove element from blackList if it is already not in blackList.");
        blackList.remove(url);
        return "Successfully removed from blackList.";
    }
}
