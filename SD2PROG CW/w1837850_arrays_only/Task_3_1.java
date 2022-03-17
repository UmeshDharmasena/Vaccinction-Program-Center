import java.util.Scanner;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

// https://www.w3schools.com/java/java_classes.asp
public class Task_3_1 {
    static String selection;
    static String patient;
    static Integer Vaccinations = 150;
    static String[] Abooths = { "empty", "empty" };
    static String[] Sbooths = { "empty", "empty" };
    static String[] Pbooths = { "empty", "empty" };
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
        for (int i = 0; i < 2; i++) {
            if (Abooths[i] == "empty") {
                System.out.println("Booth " + (i + 1) + " is : empty");
            } else {
                System.out.println("Booth " + (i + 1) + " is occupied by : " + Abooths[i]);
            }
        }
        for (int i = 0; i < 2; i++) {
            if (Sbooths[i] == "empty") {
                System.out.println("Booth " + (i + 3) + " is : empty");
            } else {
                System.out.println("Booth " + (i + 3) + " is occupied by : " + Sbooths[i]);
            }
        }
        for (int i = 0; i < 2; i++) {
            if (Pbooths[i] == "empty") {
                System.out.println("Booth " + (i + 5) + " is : empty");
            } else {
                System.out.println("Booth " + (i + 5) + " is occupied by : " + Pbooths[i]);
            }
        }
    }

    // View all Empty Booths
    public static void VEB() {
        for (int i = 0; i < 2; i++) {
            if (Abooths[i] == "empty") {
                System.out.println("Booth " + (i + 1) + " is : empty");
            }
        }
        for (int i = 0; i < 2; i++) {
            if (Sbooths[i] == "empty") {
                System.out.println("Booth " + (i + 3) + " is : empty");
            }
        }
        for (int i = 0; i < 2; i++) {
            if (Pbooths[i] == "empty") {
                System.out.println("Booth " + (i + 5) + " is : empty");
            }
        }
    }

    // Add Patient to a Booth
    public static void APB() {
        System.out.println("We have the following Vaccinations : \nAstraZeneca \nSinopharm \nPfizer");
        System.out.println("Which Vaccination do you want?");
        String choice = sc.nextLine();
        switch (choice) {
            case "AstraZeneca":
                for (int i = 0; i < 2; i++) {
                    if (Abooths[i] == "empty") {
                        System.out.println("Booth " + (i + 1) + " is : empty");
                    }
                }
                System.out.println("Select a booth from the above mentioned booths :");
                Integer number = sc.nextInt();
                System.out.println("                                                                                ");
                System.out.println("Enter patient First name :");
                sc.nextLine();
                String firstname = sc.nextLine();
                System.out.println("Enter patient Surname :");
                String surname = sc.nextLine();
                System.out.println("                                                                                ");
                patient = (firstname + "#" + surname + "#" + choice);
                Abooths[number - 1] = patient;
                System.out.println("Patient " + firstname + " " + surname + " " + "Vaccinated with " + choice
                        + " is assigned to booth number " + number);
                Vaccinations -= 1;
                break;
            case "Sinopharm":
                for (int i = 0; i < 2; i++) {
                    if (Sbooths[i] == "empty") {
                        System.out.println("Booth " + (i + 3) + " is : empty");
                    }
                }
                System.out.println("Select a booth from the above mentioned booths :");
                number = sc.nextInt();
                System.out.println("                                                                                ");
                System.out.println("Enter patient First name :");
                sc.nextLine();
                firstname = sc.nextLine();
                System.out.println("Enter patient Surname :");
                surname = sc.nextLine();
                patient = (firstname + "#" + surname + "#" + choice);
                System.out.println("                                                                                ");
                Sbooths[number - 3] = patient;
                System.out.println("Patient " + firstname + " " + surname + " " + "Vaccinated with " + choice
                        + " is assigned to booth number " + number);
                Vaccinations -= 1;
                break;
            case "Pfizer":
                for (int i = 0; i < 2; i++) {
                    if (Pbooths[i] == "empty") {
                        System.out.println("Booth " + (i + 5) + " is : empty");
                    }
                }
                System.out.println("Select a booth from the above mentioned booths :");
                number = sc.nextInt();
                System.out.println("                                                                                ");
                System.out.println("Enter patient First name :");
                sc.nextLine();
                firstname = sc.nextLine();
                System.out.println("Enter patient Surname :");
                surname = sc.nextLine();
                patient = (firstname + "#" + surname + "#" + choice);
                System.out.println("                                                                                ");
                Pbooths[number - 5] = patient;
                System.out.println("Patient " + firstname + " " + surname + " " + "Vaccinated with " + choice
                        + " is assigned to booth number " + number);
                Vaccinations -= 1;
                break;
        }

    }

    // Remove Patient from a booth
    public static void RPB() {
        System.out.println("Enter booth number 1 - 6 :");
        String Number = sc.nextLine();
        System.out.println("                                                                                ");
        switch (Number) {
            case "1":
            case "2":
                Integer value = Integer.parseInt(Number);
                patient = Abooths[value - 1];
                Abooths[value - 1] = "empty";
                System.out.println("Patient " + patient + " is has been removed from booth number " + Number);
                break;

            case "3":
            case "4":
                value = Integer.parseInt(Number);
                patient = Sbooths[value - 3];
                Sbooths[value - 3] = "empty";
                System.out.println("Patient " + patient + " is has been removed from booth number " + Number);
                break;

            case "5":
            case "6":
                value = Integer.parseInt(Number);
                patient = Pbooths[value - 5];
                Pbooths[value - 5] = "empty";
                System.out.println("Patient " + patient + " is has been removed from booth number " + Number);
                break;
        }
    }

    // View Patients Sorted in alphabetical order
    public static void VPS() {
        // https://www.javatpoint.com/bubble-sort-in-java
        String[] arr = { Abooths[0], Abooths[1], Sbooths[0], Sbooths[1], Pbooths[0], Pbooths[1] };
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
            FileWriter writer = new FileWriter("Textfile3_1.txt");
            for (int i = 0; i < 2; i++) {
                str = "Booth " + (i + 1) + " :" + Abooths[i];
                writer.write(str + "\n");
            }
            for (int i = 0; i < 2; i++) {
                str = "Booth " + (i + 3) + " :" + Sbooths[i];
                writer.write(str + "\n");
            }
            for (int i = 0; i < 2; i++) {
                str = "Booth " + (i + 5) + " :" + Pbooths[i];
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
            File line = new File("Textfile3_1.txt");
            Scanner reader = new Scanner(line);
            for (int i = 0; i < 2; i++) {
                String data = reader.nextLine();
                data = data.substring(9);
                if (data.equals("empty")) {
                    Abooths[i] = "empty";
                } else {
                    Abooths[i] = data;
                }
            }
            for (int i = 0; i < 2; i++) {
                String data = reader.nextLine();
                data = data.substring(9);
                if (data.equals("empty")) {
                    Sbooths[i] = "empty";
                } else {
                    Sbooths[i] = data;
                }
            }
            for (int i = 0; i < 2; i++) {
                String data = reader.nextLine();
                data = data.substring(9);
                if (data.equals("empty")) {
                    Pbooths[i] = "empty";
                } else {
                    Pbooths[i] = data;
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