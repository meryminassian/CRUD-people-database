import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File_Writer.writeIn(); //for generating random 10 people by faker

        Scanner scanner = new Scanner(System.in);

        System.out.println("For adding a new person to the database press 1");
        System.out.println("For reading a person's info based on the id press 2");
        System.out.println("For updating a person's info based on the id press 3");
        System.out.println("For deleting a person's info based on the id press 4");
        System.out.println("For exit press -1");
        int press;
        while (!((press = scanner.nextInt()) == (-1))){
            Controller.controller(press);
        }


    }
}
