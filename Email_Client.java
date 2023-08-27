package email;
// your index number - 200607V
//import libraries

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Email_Client {
    public static ArrayList<Recipients> objArr = new ArrayList<>();
    public static void readFile()
    {
        File f = new File("clientList.txt");
        try {
            f.createNewFile();
        }
        catch (Exception ignored) {
        }
        if (f.length() != 0) {

            try {
                FileInputStream fis;

                fis = new FileInputStream("clientList.txt");
                ObjectInputStream ois = new ObjectInputStream(fis);

                Recipients c;
                while (fis.available() != 0) {                  // check if already save or not
                    c = (Recipients) ois.readObject();
                    objArr.add(c);
                }
                ois.close();
                fis.close();
            }
            catch (Exception e) {
                System.out.println("Error Occurred in reading file" + e);
                e.printStackTrace();
            }
        }
    }

    static void addRecipt(String input){    // store details in clientList.txt file

        String[] arr= input.split(":", 2);
        String type=arr[0];
        boolean have=false;
        switch (type) {
            case "Official" -> {

                String[] offarr1 = arr[1].split(",", 3);
                for(Recipients i:objArr){
                    if(i.getEmail().equals(offarr1[1])){
                        have=true;
                    }
                }
                if(!have){
                    System.out.println("Updating email receipt list...");
                    OfiicialRecipientsController newEmail = new OfiicialRecipientsController();
                    newEmail.makeRecipient(offarr1[0], offarr1[1], offarr1[2]);
                }else {
                    System.out.println("Already saved this email");
                }

            }
            case "Office_friend" -> {
                String[] offarr2 = arr[1].split(",", 4);
                for(Recipients i:objArr){
                    if(i.getEmail().equals(offarr2[1])){
                        have=true;
                    }
                }
                if(!have){
                    System.out.println("Updating email receipt list...");
                    Office_friendRecipientsController newOFFfriend = new Office_friendRecipientsController();
                    newOFFfriend.makeRecipient(offarr2[0], offarr2[1], offarr2[2], offarr2[3]);
                }else {
                    System.out.println("Already saved this email");
                }

            }
            case "Personal" -> {
                String[] offarr3 = arr[1].split(",", 4);
                for(Recipients i:objArr){
                    if(i.getEmail().equals(offarr3[2])){
                        have=true;
                    }
                }
                if(!have){
                    System.out.println("Updating email receipt list...");
                    PersonalRecipientsController newPesonal = new PersonalRecipientsController();
                    newPesonal.makeRecipient(offarr3[0], offarr3[1], offarr3[2], offarr3[3]);
                }else {
                    System.out.println("Already saved this email");
                }

            }
            default -> System.out.println("Invalid receipt type");
        }
    }
    public static void proccesingEmail(String x, String y, String z){
        boolean save=false;
        objArr.clear();
        readFile();
        for (Recipients i:objArr){
            String temp=i.getEmail();
            if(temp.equals(x)) {
                save=true;
                i.sendEmail(x, y, z);
                break;
            }
        }
        if(!save){
            System.out.println("Invalid email, Check again");
        }
    }

    public static void main(String[] args) {
        boolean x=true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient(Official,Office_friend,Personal)\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent in given date\n"
                + "5 - Printing out the number of recipient objects in the application\n"
                + "6 - Exit");
        while (x){
            int option=0;
            readFile();
            try {
                int o = scanner.nextInt();
                option=o;
            }catch (Exception e){
                System.out.println("You must input integer");
                break;}


            switch(option){
                case 1:
                    System.out.println("***  input format  ***");
                    System.out.println("Official: nimal,nimal@gmail.com,ceo\n"+"Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12\n"+"Personal: sunil,<nick-name>,sunil@gmail.com,2000/10/10");

                    System.out.print("Add new client :");
                    scanner.nextLine();
                    String inp1=scanner.nextLine();// input format - Official: nimal,nimal@gmail.com,ceo
                    addRecipt(inp1);
                    // Use a single input to get all the details of a recipient
                    // code to add a new recipient
                    // store details in clientList.txt file
                    // Hint: use methods for reading and writing files
                    break;
                case 2:
                    // input format - email, subject, content
                    System.out.println("input format - <email>, <subject>, <content>");
                    System.out.println("next line - \\n");
                    scanner.nextLine();
                    String inp2=scanner.nextLine();
                    String[] arrOfStr = inp2.split(",", 3);
                    proccesingEmail(arrOfStr[0],arrOfStr[1],arrOfStr[2]);

                    // code to send an email

                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Enter date in the format yyyy/MM/dd: ");
                    String dateStr1 = scanner.nextLine();
                    BirthdayGreeting.checkBirthDay(dateStr1);
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print recipients who have birthdays on the given date
                    break;
                case 4:// check mails
                    scanner.nextLine();
                    System.out.print("Enter date in the format yyyy/MM/dd: ");
                    String dateStr2 = scanner.nextLine();
                    AddEmailDetails.readDetailsFile(dateStr2);
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print the details of all the emails sent on the input date
                    break;
                case 5:
                    objArr.clear();
                    readFile();
                    System.out.println(objArr.size());
                    break;
                case 6:
                    x=false;
                    System.out.println("The program has executed successfully");
                    break;
                default:
                    System.out.println("Invalid input Try again");

            }}

        // start email client
        // code to create objects for each recipient in clientList.txt
        // use necessary variables, methods and classes

    }
}

// create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)
