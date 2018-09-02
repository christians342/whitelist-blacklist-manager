public class ListsManagerService {

    private ListHandler whitelist;
    private ListHandler blacklist;

    public ListsManagerService() {
        this.whitelist = new ListHandler("whitelist.txt");
        this.blacklist = new ListHandler("blacklist.txt");;
    }

    public String verify(String url) {
        if(whitelist.contains(url))
            return "safe";
        else if(whitelist.contains(url))
            return "unsafe";
        else return "unknown";
    }

    public String addToWhiteList(String url) throws InvalidCommandException {
        if(blacklist.contains(url))
            throw new InvalidCommandException("Cannot add an element in whitelist if it is already in blacklist.");
        if(whitelist.contains(url))
            throw new InvalidCommandException("Url already in whitelist.");
        whitelist.add(url);
        return "Successfully added to whitelist.";
    }

    public String addToBlackList(String url) throws InvalidCommandException {
        if(whitelist.contains(url))
            throw new InvalidCommandException("Cannot add an element in blacklist if it is already in whitelist.");
        if(blacklist.contains(url))
            throw new InvalidCommandException("Url already in blacklist.");
        blacklist.add(url);
        return "Successfully added to blacklist.";
    }

    public String showWhiteList() {
        return whitelist.getUrls();
    }

    public String showBlackList() {
        return blacklist.getUrls();
    }

    public String removeFromWhiteList(String url) {
        whitelist.remove(url);
        return "Successfully removed from whitelist.";
    }

    public String removeFromBlackList(String url) {
        blacklist.remove(url);
        return "Successfully removed from blacklist.";
    }
}
