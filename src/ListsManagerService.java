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

    public String addToWhiteList(String url) {
        return "Successfully added to whitelist";
    }

    public String addToBlackList(String url) {
        return "Successfully added to blacklist";
    }
}
