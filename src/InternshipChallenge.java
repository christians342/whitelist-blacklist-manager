import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class InternshipChallenge {


    public static void main(String[] args){

        ArrayList<String> command = new ArrayList<String>(Arrays.asList(args));

        try {
            Controller controller = new Controller();
            System.out.println(controller.execute(command));
        } catch (InvalidCommandException e) {
            System.err.println(e.getReason());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("An error occurred while manipulating a file.");
        } finally {
            System.err.println("Exiting now...");
        }
    }

}
