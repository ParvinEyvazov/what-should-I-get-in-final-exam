import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author ParvinEyvazov
 */

public class main {

    public static TreeMap<String, Double> average_of_letters = new TreeMap<>();
    public static DecimalFormat df = new DecimalFormat("#.##");

    public static void main(String[] args) {

        //average by letters that decided by University
        average_of_letters.put("AA", 87.5);
        average_of_letters.put("BA", 80.5);
        average_of_letters.put("BB", 73.5);
        average_of_letters.put("CB", 66.5);
        average_of_letters.put("CC", 59.5);
        average_of_letters.put("DC", 52.5);
        average_of_letters.put("DD", 45.5);
        average_of_letters.put("FD", 34.5);


        if (args.length != 1) {
            System.err.println("usage: java main <file_name>");
            System.exit(-1);
        }

        String fileName = args[0];
        try {
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String result = "";
            FileWriter logger = new FileWriter("result.txt", false);

            String subject;
            ArrayList<String> grades = new ArrayList<>();

            while ((subject = br.readLine()) != null) {
                result += subject + "\n";
                String st_in;
                while ((st_in = br.readLine()) != null) {
                    if (st_in.equals("--")) {
                        result += calculateFinalGrades(grades);
                        grades.clear();
                        break;
                    } else {
                        grades.add(st_in);
                    }

                }
                result += "\n";
            }
            logger.write(result);
            logger.flush();
            logger.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String calculateFinalGrades(ArrayList<String> grades) {
        double current_average = 0.0;
        double exam_percentage = 100.0;
        final String[] result = new String[1];
        result[0] = "";

        for (int i = 0; i < grades.size(); i++) {
            String[] tokens = grades.get(i).split("[(,)]");
            double percentage = Double.parseDouble(tokens[1]);
            double grade = Double.parseDouble(tokens[2]);
            exam_percentage -= percentage;
            current_average += ((percentage * grade) / 100);
        }
        double final_current_average = current_average;
        double final_exam_percentage = exam_percentage;
        result[0] = "";
        average_of_letters.forEach((letter, letter_average) -> {
            double needed_average = letter_average - final_current_average;
            double needed_grade = (needed_average * 100) / final_exam_percentage;
            result[0] += "For " + letter + " --> " + df.format(needed_grade) + " and more";
            result[0] += needed_grade < 35.0 ? " (lower than 35 rule)\n" : "\n";
        });
        return result[0];
    }
}
