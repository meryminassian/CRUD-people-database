import com.opencsv.CSVReader;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {
    static Scanner in = new Scanner(System.in);

    public static void controller(int pressed) {
        if (pressed == 1) {
            Service.create(inputtingInfo());
        }
        if (pressed == 2) {
            System.out.println("input the id of the person, whose info you want to read");
            int id = in.nextInt();
            Service.read(id);
        }
        if (pressed == 3) {
            System.out.println("input the id of the person, whose info you want to change");
            int id = in.nextInt();
            int fieldIndex = updatedField();
            String newValue = updateDataTo();
            Service.update(id, fieldIndex, newValue );
        }
        if (pressed == 4){
            System.out.println("input the id of the person, whose info you want to delete");
            int id = in.nextInt();
            Service.delete(id);
        }
    }


    private static int  updatedField(){
        System.out.println("for updating name, press 1");
        System.out.println("for updating last name, press 2");
        System.out.println("for updating phone number, press 3");
        System.out.println("for updating email address, press 4");

        return in.nextInt();
    }
    private static String updateDataTo(){
        System.out.println("input the new value you want to change to");
        String newValue = in.next();
        return newValue;
    }

    private static Person inputtingInfo(){
        System.out.print("input the name: ");
        String name = in.nextLine();
        System.out.print("input the last name: ");
        String last_name = in.nextLine();
        System.out.print("input the phone number: ");
        String phone_number = in.nextLine();
        System.out.print("input the email address: ");
        String email = in.nextLine();
        Person newPerson = new Person(name, last_name, phone_number, email);
        return newPerson;
    }
}
