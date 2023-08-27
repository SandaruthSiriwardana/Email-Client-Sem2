package email;

import java.io.*;


public  class AddEmailDetails {
    private Email c;
    private static File f = new File("email.txt"); //--------------------
    public AddEmailDetails(Email c){
        this.c=c;
    }

    public static boolean addDetails(Email c) {
        boolean status = false;
        if (c != null) {
            try {
                FileOutputStream fos = null;
                fos = new FileOutputStream("email.txt", true);//-------------------------------------

                if (f.length() == 0) {
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(c);
                    oos.close();
                }
                else {

                    EmailObjectOutputStream oos = null;
                    oos = new EmailObjectOutputStream(fos);
                    oos.writeObject(c);

                    oos.close();
                }

                fos.close();
                System.out.println("update email.txt");
            }


            catch (Exception e) {


                System.out.println("Error Occurred  in adding -" + e);
            }


            status = true;
        }

        return status;
    }
    public static boolean readDetailsFile(String d)
    {

        boolean status = false;


        try {


            f.createNewFile();
        }


        catch (Exception e) {
        }


        if (f.length() != 0) {

            try {


                FileInputStream fis = null;

                fis = new FileInputStream("email.txt");//------------------------------
                ObjectInputStream ois = new ObjectInputStream(fis);

                Email c = null;
                boolean haveEmail=false;
                while (fis.available() != 0) {
                    c = (Email) ois.readObject();
                    String Curntdate= c.getDate();

                    //------------------------------------------print letter
                    if(Curntdate.equals(d)){
                        haveEmail=true;
                        System.out.println("To :"+c.getToEmail());
                        System.out.println("At :"+c.getTime());
                        System.out.println("Subject :"+c.getSubject());
                        System.out.println("Content :");
                        System.out.println(c.getContent());
                        System.out.println("--------------------------------------------");

                    }
                }

                if(!haveEmail){
                    System.out.println("No emails sent on "+d);
                }
                ois.close();
                fis.close();


                status = true;
            }


            catch (Exception e) {


                System.out.println("Error Occurred" + e);


                e.printStackTrace();
            }
        }
        return status;
    }

}

