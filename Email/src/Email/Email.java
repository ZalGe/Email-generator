package Email;

import java.util.Scanner;

public class Email
{
    private String firsName;
    private String lastName;
    private String position;
    private String password;
    private int DefaultPasswordLenght = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String email;
    private String companySuffix = "school.com";

    // Constructor to receive first and last name
    public Email(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        firsName = sc.nextLine();
        System.out.println("Enter your last name: ");
        lastName = sc.nextLine();

        // Call a method asking for department
        this.position = setPos();

        // Combine elements to generate email
        email = firsName.toLowerCase() + "." + lastName.toLowerCase() + "@" + position + "." + companySuffix;

        // Call for a method that returns generated password
        this.password = setPass(DefaultPasswordLenght);
    }

    // Ask fo the position
    private String setPos(){
        System.out.print("New colleague" + firsName + "\nChoose from position codes:\n1 for Student\n2 for Teacher\n3 for Director\n0 for none\nEnter department code:");
        Scanner sc = new Scanner(System.in);
        int posChoice = sc.nextInt();
        if (posChoice == 1){ return "stu"; }
        else if (posChoice == 2) { return "tea"; }
        else if (posChoice == 3) { return "dir"; }
        else {return "guest";}
    }
    // Generate random password
    private String setPass(int lenght){
        String PassSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "1!@&#%ß";
        char [] password = new char[lenght];
        for (int i = 0; i<lenght; ++i)
        {
            int rand = (int) (Math.random() * PassSet.length());
            password[i] = PassSet.charAt(rand);
        }
        return new String(password);
    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity (){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword() {return password;}

    public String showInfo()
    {
        return "DISPLAY NAME: " + firsName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nPASSWORD : " + password +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + " MB";
    }
}
