public class InvalidCommandException extends Throwable {

    private String reason;

    public InvalidCommandException(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
