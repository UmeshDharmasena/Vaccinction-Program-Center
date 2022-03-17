import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

// https://www.w3schools.com/java/java_classes.asp
public class Task_1 {
    static String selection;
    static String patient;
    static Integer Vaccinations = 150;
    static String[] booths = { "empty", "empty", "empty", "empty", "empty", "empty" };
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println(
                " 100 or VVB: View all Vaccination Booths \n 101 or VEB: View all Empty Booths \n 102 or APB: Add Patient to a Booth \n 103 or RPB: Remove Patient from a Booth \n 104 or VPS: View Patients Sorted in alphabetical order \n 105 or SPD: Store Program Data into file \n 106 or LPD: Load Program Data from file \n 107 or VRV: View Remaining Vaccinations \n 108 or AVS: Add Vaccinations to the Stock \n 999 or EXT: Exit the Program");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while (true) {
            do {
                System.out.println("Type in your selection :");
                selection = sc.nextLine();
                System.out.println("                                                                                ");
            } while (!selection.equalsIgnoreCase("100") && !selection.equalsIgnoreCase("VVB")
                    && !selection.equalsIgnoreCase("101") && !selection.equalsIgnoreCase("VEB")
                    && !selection.equalsIgnoreCase("102") && !selection.equalsIgnoreCase("APB")
                    && !selection.equalsIgnoreCase("103") && !selection.equalsIgnoreCase("RPB")
                    && !selection.equalsIgnoreCase("104") && !selection.equalsIgnoreCase("VPS")
                    && !selection.equalsIgnoreCase("105") && !selection.equalsIgnoreCase("SPD")
                    && !selection.equalsIgnoreCase("106") && !selection.equalsIgnoreCase("LPD")
                    && !selection.equalsIgnoreCase("107") && !selection.equalsIgnoreCase("VRV")
                    && !selection.equalsIgnoreCase("108") && !selection.equalsIgnoreCase("AVS")
                    && !selection.equalsIgnoreCase("999") && !selection.equalsIgnoreCase("EXT"));

            switch (selection) {
                case "100":
                case "VVB":
                    VVB();
                    break;
                case "101":
                case "VEB":
                    VEB();
                    break;
                case "102":
                case "APB":
                    APB();
                    break;
                case "103":
                case "RPB":
                    RPB();
                    break;
                case "104":
                case "VPS":
                    VPS();
                    break;
                case "105":
                case "SPD":
                    SPD();
                    break;
                case "106":
                case "LPD":
                    LPD();
                    break;
                case "107":
                case "VRV":
                    System.out.println("\nVaccinations remaining in stock:" + Vaccinations);
                    break;
                case "108":
                case "AVS":
                    AVS();
                    break;
                case "999":
                case "EXT":
                    EXT();
            }
            if (Vaccinations == 20) {
                System.out.println("Warning : only 20 Vaccinations remain!");
            }
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }

    // View all Vaccination Booths
    public static void VVB() {
        for (int i = 0; i < 6; i++) {
            if (booths[i] == "empty") {
                System.out.println("Booth " + (i + 1) + " is : empty");
            } else {
                System.out.println("Booth " + (i + 1) + " is occupied by : " + booths[i]);
            }
        }
    }

    // View all Empty Booths
    public static void VEB() {
        for (int i = 0; i < 6; i++) {
            if (booths[i] == "empty") {
                System.out.println("Booth " + (i + 1) + " is : empty");
            }
        }
    }

    // Add Patient to a Booth
    public static void APB() {
        VEB();
        System.out.println("Select a booth from the above mentioned booths :");
        Integer number = sc.nextInt();
        System.out.println("                                                                                ");
        System.out.println("Enter patient First name :");
        sc.nextLine();
        patient = sc.nextLine();
        booths[number - 1] = patient;
        System.out.println("Patient " + patient + " is assigned to booth number " + number);
        Vaccinations -= 1;
    }

    // Remove Patient from a booth
    public static void RPB() {
        System.out.println("Enter booth number 1 - 6 :");
        String Number = sc.nextLine();
        System.out.println("                                                                                ");
        Integer value = Integer.parseInt(Number);
        patient = booths[value - 1];
        booths[value - 1] = "empty";
        System.out.println("Patient " + patient + " is has been removed from booth number " + Number);
    }

    // View Patients Sorted in alphabetical order
    public static void VPS() {
        // https://www.javatpoint.com/bubble-sort-in-java
        String[] arr = { booths[0], booths[1], booths[2], booths[3], booths[4], booths[5] };
        for (int j = 0; j < 6 - 1; j++) {
            for (int i = j + 1; i < 6; i++) {
                if ((arr[j].toLowerCase()).compareTo((arr[i]).toLowerCase()) > 0) {
                    String temp1 = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp1;
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("Patient " + (i + 1) + " : " + arr[i]);
        }
    }

    // Store Program Data into file
    public static void SPD() {
        // https://www.w3schools.com/java/java_files_create.asp
        try {
            String str = "";
            FileWriter writer = new FileWriter("Textfile1.txt");
            for (int i = 0; i < 6; i++) {
                str = "Booth " + (i + 1) + " :" + booths[i];
                writer.write(str + "\n");
            }
            writer.close();
            System.out.println("Successfully updated file.");
        } catch (IOException except) {
            System.out.println("Error");
            except.printStackTrace();
        }
    }

    // Load Program Data from file
    public static void LPD() {
        // https://www.w3schools.com/java/java_files_read.asp
        // https://beginnersbook.com/2013/12/java-string-substring-method-example/
        try {
            File line = new File("Textfile1.txt");
            Scanner reader = new Scanner(line);
            for (int i = 0; i < 6; i++) {
                String data = reader.nextLine();
                data = data.substring(9);
                if (data.equals("empty")) {
                    booths[i] = "empty";
                } else {
                    booths[i] = data;
                }
            }
            reader.close();
            System.out.println("Successfully updated Array.");
        } catch (IOException except) {
            System.out.println("Error");
            except.printStackTrace();
        }
    }

    // Add Vaccinations to the Stock
    public static void AVS() {
        System.out.println("Enter number of Vaccinations to be added to stock : ");
        Scanner vacc = new Scanner(System.in);
        Integer add = vacc.nextInt();
        Vaccinations = Vaccinations + add;
    }

    // Exit the Program
    public static void EXT() {
        System.exit(0);
    }
}