package Primary;

import java.io.*;
import java.util.*;

public class name_generator {
    // File paths for first and last names within the "Data" package
    private static final String FIRST_NAME_FILE = "/Data/american_first";
    private static final String LAST_NAME_FILE = "/Data/american_last";

    public static void main(String[] args) {
        String randomName = generateRandomName("american");
        System.out.println("Random Name: " + randomName);
    }

    public static String generateRandomName(String nameType) {
        // Read first names and last names from files based on the nameType
        List<String> firstNames;
        List<String> lastNames;

        try (
            // Use InputStreams to read the resource files
            InputStream firstNameStream = name_generator.class.getResourceAsStream(FIRST_NAME_FILE);
            InputStream lastNameStream = name_generator.class.getResourceAsStream(LAST_NAME_FILE);
            // Create BufferedReaders to read lines from the input streams
            BufferedReader firstNameReader = new BufferedReader(new InputStreamReader(firstNameStream));
            BufferedReader lastNameReader = new BufferedReader(new InputStreamReader(lastNameStream))
        ) {
            // Read lines from the input streams into ArrayLists
            firstNames = new ArrayList<>();
            lastNames = new ArrayList<>();

            String line;
            while ((line = firstNameReader.readLine()) != null) {
                firstNames.add(line);
            }

            while ((line = lastNameReader.readLine()) != null) {
                lastNames.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: Unable to read name files.";
        }

        // Generate random indices for first and last names
        Random rand = new Random();
        int randomFirstNameIndex = rand.nextInt(firstNames.size());
        int randomLastNameIndex = rand.nextInt(lastNames.size());

        // Get the random first and last names
        String randomFirstName = firstNames.get(randomFirstNameIndex);
        String randomLastName = lastNames.get(randomLastNameIndex);

        // Combine the first and last names
        return randomFirstName + " " + randomLastName;
    }
}




