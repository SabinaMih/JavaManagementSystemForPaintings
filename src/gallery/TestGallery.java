package gallery;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestGallery {
    // default constructor
    public TestGallery(){
    }

    public static void main(String[] args) {
        //initialise the variable that would be used to store the data from the file
        String artist = null;
        String title = null;
        double purchase_price = 0.0D;
        double selling_price = 0.0D;
        int year = 0;


        File inFile = new File("files", "gallery.txt");
        Gallery gallery = new Gallery();

        Scanner in;
        try {
            in = new Scanner(inFile);
            try {
                while(in.hasNextLine()) {
                    String line = in.nextLine();
                    Scanner lineScanner = new Scanner(line);
                    lineScanner.useDelimiter(",");

                    while(lineScanner.hasNext()) {
                        artist = lineScanner.next();
                        title = lineScanner.next();
                        purchase_price = Double.parseDouble(lineScanner.next());
                        selling_price = Double.parseDouble(lineScanner.next());
                        year = Integer.parseInt(lineScanner.next());

                    }
                    // call the addPanting method to add the data in the gallery obj
                    gallery.addPanting(artist, title, purchase_price, selling_price, year);
                }
            } catch (Throwable var16) {
                try {
                    in.close();
                } catch (Throwable var15) {
                    var16.addSuppressed(var15);
                }

                throw var16;
            }

            in.close();
        } catch (FileNotFoundException var17) {
            System.out.println("Problem: " + var17.getMessage());
        }

        // user choice menu
        System.out.println("\t\t\t\t\t\tWelcome to the Gallery Program");
        while(true) {
            while(true) {
                try {
                    System.out.println("********************************************************************************************");
                    System.out.println("Please press 1 to view the paintings");
                    System.out.println("Please press 2 to view the tax due on paintings");
                    System.out.println("Please press 3 to view the tax on profit");
                    System.out.println("Press 4 to quit");
                    in = new Scanner(System.in);
                    int choice = in.nextInt();
                    System.out.println("*********************************************************************************************");

                    switch (choice) {
                        case 1:
                            gallery.displayList();
                            break;
                        case 2:
                            gallery.calcGovernmentTax();
                            break;
                        case 3:
                            gallery.calcTaxOnProfit();
                            break;
                        case 4:
                            System.exit(0);
                    }
                    // catch invalid input such as string
                }catch (InputMismatchException ime){
                    System.out.println("Invalid input. Please enter a number (1, 2, 3, 4-exit):");
                }
            }
        }

    }
}
