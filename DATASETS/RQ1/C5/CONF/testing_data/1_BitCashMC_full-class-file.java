

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Session {
    Profile profile;
    public static String prefix = "[STUDENT]";

public void saveAcc() throws IOException, InterruptedException {

    System.out.println(prefix + " Saving your profile \""+ this.profile.name + "\" now.. Please do not close the program.");
    java.io.FileOutputStream fOutput = new FileOutputStream("C:/Users/musky/Dropbox/javapractice/StudentManager/student_manager/storage/" + this.profile.name + ".student");
    java.io.ObjectOutputStream output = new ObjectOutputStream(fOutput);
    output.writeObject(this.profile);
    fOutput.close();
    output.close();
    Thread.sleep(800);
    System.out.println(prefix + " Successfully saved your profile to your cache!");

}

public void loadAcc(String name) throws InterruptedException {
    System.out.println(prefix + " Attempting to load your profile \"" + name + "\" now.. Please do not close the program.");
    try {
        java.io.FileInputStream fInput = new FileInputStream("C:/Users/musky/Dropbox/javapractice/StudentManager/student_manager/storage/" + name + ".student");
        java.io.ObjectInputStream input = new ObjectInputStream(fInput);
        
        this.profile = (Profile) input.readObject();

        fInput.close();
        input.close();
    } catch (IOException | ClassNotFoundException e) {
        System.err.println("An error occured whilst trying to load your student profile. Creating you a new one.. (incomplete)");
    }
    Thread.sleep(800);
    System.out.println(prefix + " Successfully loaded your profile!");
}

public void newAcc(String name) throws InterruptedException {
    System.out.println(prefix + " Creating your profile now, Name: " + name);
    this.profile = new Profile(name);
    Thread.sleep(800);
    System.out.println(prefix + " You have successfully created a new profile!");

}

public void start() throws InterruptedException {
    Scanner input = new Scanner(System.in);

    outer: while (true) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("Welcome to the bitcash.org universal student management dashboard.");
        System.out.println(" ");
        System.out.println("----------------------------------------------------------------------");

        System.out.println("Would you like to load an existing profile, or create a new one? Type:");
        System.out.println("N: New Account");
        System.out.println("L: Load Account");

        if (input.hasNext()) {

            switch (input.next()) {

                case "N":
                    System.out.println(prefix + " Please enter your profile name:");
                    if (input.hasNext()) {
                        this.newAcc(input.next());
                        break outer;
                    }

                case "L":
                    System.out.println(prefix + " Please enter the name of the profile to load:");
                    if (input.hasNext()) {
                        this.loadAcc(input.next());
                        break outer;
                    }
                
                default:
                System.out.println("invalid arg try again ");
                continue;
            }

        } else {
            System.out.println(prefix + " You entered an invalid argument, please try again.");
            continue;
        }
    }
    input.close();
    this.homePage();

}

public void homePage() {
    Scanner input = new Scanner(System.in);

    outer: while (true) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                         LANDING PAGE");
        System.out.println("                    Good day, " + this.profile.name);
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Please select what you would like to do:");
        System.out.println("B: Buy & access your books");
        System.out.println("G: Access your grades dashboard");
        System.out.println("P: Customize your profile details");
        System.out.println("M: Manage your account balance");
        System.out.println("S: Save your profile");
        
        if (input.hasNext()) {
            switch (input.next()) {
                case "B":
                this.booksPage();
                break outer;

                default:
                System.out.println("invalid args try again");
                break outer;
            }
        } else {
            System.out.println(prefix + " You entered an invalid argument, please try again.");
            continue; 
        }

    }
    
    input.close();
}
public void booksPage() {
    System.out.println("----------------------------------------------------------------------");
    System.out.println("                         BOOKS DASHBOARD");
    System.out.println("                    Good day, " + this.profile.name);
    System.out.println("----------------------------------------------------------------------");
    System.out.println("Please select what you would like to do:");
    System.out.println("B: Buy a book");
    System.out.println("C: Check your unlocked books");
    System.out.println("R: Read a book");
}

public static void main(String[] args) throws InterruptedException {
    Session instance1 = new Session();
    instance1.start();
}
}
