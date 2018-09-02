import java.util.ArrayList;
import java.util.Arrays;

public class InternshipChallenge {


    public static void main(String[] args){

        if(args.length > 2 || args.length < 1){
            System.err.println("Command not found. Exiting now...");
            return ;
        }

        ArrayList<String> command = new ArrayList<String>(Arrays.asList(args));

        Controller controller = new Controller();

        System.out.println(controller.execute(command));
    }

}
