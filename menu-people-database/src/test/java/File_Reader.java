//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVRecord;
//
//import java.io.*;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//
//public class File_Reader {
//
//    public static void read(int personID){
//        try (Reader reader = new FileReader(File_Writer.file)) {
//            CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
//            csvParser.getRecords()
//                    .stream()
//                    .filter(each -> each.get("ID").equals(String.valueOf(personID)))
//                    .forEach(each -> System.out.println(
//                              each.get("ID") + " "
//                            + each.get("Name") + " "
//                            + each.get("Last name") + " "
//                            + each.get("Phone Number") + " "
//                            + each.get("Email")));
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
//
//
