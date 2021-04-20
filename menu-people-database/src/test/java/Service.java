import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Service {

    public static void create(Person person) {
        //File_Writer.writeIn(); //for generating random 10 people by faker
        File_Writer.people.add(person);
        File_Writer.writeIn();

    }

    public static void read(int personID) {
        try (Reader reader = new FileReader(File_Writer.file)) {
            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
            csvParser.getRecords()
                    .stream()
                    .filter(each -> each.get("ID").equals(String.valueOf(personID)))
                    .forEach(each -> System.out.println(
                            each.get("ID") + " "
                                    + each.get("Name") + " "
                                    + each.get("Last name") + " "
                                    + each.get("Phone Number") + " "
                                    + each.get("Email")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void update(int id, int fieldsIndex, String updateTo) {

        //index 1-> name, 2-> last name, 3-> phone number, 4-> email
        if (fieldsIndex > 4 || fieldsIndex < 1) {
            return;
        }

        try (CSVReader reader = new CSVReader(new FileReader(File_Writer.file))) {
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] recordsArray = records.get(i);
                for (int j = 0; j < recordsArray.length; j++) {
                    if (recordsArray[0].equals(String.valueOf(id))) {
                        //System.out.print(recordsArray[j] + " ");
                        records.get(i)[fieldsIndex] = updateTo;
                        //System.out.println(recordsArray[j] + " ");
                    }
                }
            }
            try (CSVWriter writer = new CSVWriter(new FileWriter(File_Writer.file))) {
                writer.writeAll(records);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        try (CSVReader reader = new CSVReader(new FileReader(File_Writer.file))) {
            List<String[]> records = reader.readAll();
            for (int i = 0; i < records.size(); i++) {
                String[] recordsArray = records.get(i);
                if(recordsArray[0].equals(String.valueOf(id))){
                    records.remove(i);
                }
            }

            try (CSVWriter writer = new CSVWriter(new FileWriter(File_Writer.file))) {
                writer.writeAll(records);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
