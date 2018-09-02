import java.util.ArrayList;
import java.util.Arrays;

public class InternshipChallenge {


    public static void main(String[] args){

        ArrayList<String> command = new ArrayList<String>(Arrays.asList(args));

        Controller controller = new Controller();

        try {
            System.out.println(controller.execute(command));
        } catch (InvalidCommandException e) {
            System.err.println(e.getReason());
            System.err.println("Exiting now...");
        }
    }

}
