package email;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BirthdayGreeting {
    private static final File f = new File("clientList.txt");
    public static void checkBirthDay(String d)
    {


        try {


            f.createNewFile();
        }


        catch (Exception ignored) {
        }


        if (f.length() != 0) {
            try {


                FileInputStream fis;

                fis = new FileInputStream("clientList.txt");//------------------------------
                ObjectInputStream ois = new ObjectInputStream(fis);

                Recipients c;
                boolean haveEmail=false;
                while (fis.available() != 0) {
                    c = (Recipients) ois.readObject();
                    String b= c.getStatus();

                    String C_date;
                    LocalDate Ldate = LocalDate.now(); // get current date
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                    C_date= formatter.format(Ldate);
                    String[] arrOfStr = C_date.split("/", 2);
                    String currentMD=arrOfStr[1];
                    String[] arrOfStrInp = d.split("/", 2);
                    String inputDM=arrOfStrInp[1];
                    //------------------------------------------print letter
                    if(b.equals("Office_friend")){
                        Office_friendRecipients mail=(Office_friendRecipients)c;
                        String[] arr = mail.getBirthDay().split("/", 2);
                        String DM=arr[1];

                        if(DM.equals(inputDM)){
                            haveEmail=true;
                            System.out.println("Office friend who celebrate their birth day that day "+c.getName());
                            if(currentMD.equals(inputDM) && C_date.equals(d)){
                                mail.birthdayGreeting(c.getEmail(),"Birthday Wish","Wish you a Happy Birthday.\n       ~~ Gotabaya Rajapakshe ~~ ");
                            }
                        }

                    }
                    if(b.equals("Personal")){
                        PersonalRecipients mail1=(PersonalRecipients) c;//---------------------------------------------
                        String[] arr1 = mail1.getBirthDay().split("/", 2);
                        String DM1=arr1[1];

                        if(DM1.equals(inputDM)){
                            haveEmail=true;
                            System.out.println("Personal friend who celebrate their birth day that day "+c.getName());
                            if(currentMD.equals(inputDM) && C_date.equals(d)){
                                mail1.birthdayGreeting(c.getEmail(),"Birthday Wish","Hugs and love on your birthday.\n      ~~ Gotabaya Rajapakshe ~~ ");
                            }
                        }

                    }
                }

                if(!haveEmail){
                    System.out.println("No any birthday in "+d);
                }
                ois.close();
                fis.close();


            }


            catch (Exception e) {


                System.out.println("Error Occurred in send wish" + e);


                e.printStackTrace();
            }
        }
    }

}
