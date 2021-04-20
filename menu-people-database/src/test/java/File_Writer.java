import com.github.javafaker.Faker;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class File_Writer {

    public static File file = new File("people-database.csv");
    private static Faker faker = new Faker();

    private static List<Person> generatePeople(){
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String mail = faker.internet().emailAddress(firstName.toLowerCase() + String.valueOf(faker.number().digits(2)));
            String phoneNumber = faker.phoneNumber().cellPhone();
            people.add(new Person(firstName, lastName,
                    phoneNumber, mail));
        }
        return people;
    }

    public static List<Person> people = generatePeople();

    public static void writeIn() {
        try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(file),
                CSVFormat.DEFAULT.withHeader("ID", "Name", "Last name", "Phone Number", "Email"))) {

            for (int i = 0; i < people.size(); i++) {
                csvPrinter.printRecord(
                        people.get(i).getId(),
                        people.get(i).getName(),
                        people.get(i).getSurname(),
                        people.get(i).getPhoneNumber(),
                        people.get(i).getEmail());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

