package email;

import java.io.*;

public class EmailCollection {
    private static final File f = new File("clientList.txt");
    public static void AddNewRecipiet(Recipients c)
    {

        if (c != null) {
            try {
                FileOutputStream fos;
                fos = new FileOutputStream("clientList.txt", true);//-------------------------------------

                if (f.length() == 0) {
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(c);
                    oos.close();
                }
                else {

                    EmailObjectOutputStream oos;
                    oos = new EmailObjectOutputStream(fos);
                    oos.writeObject(c);
                    oos.close();
                }

                fos.close();
                System.out.println("update clientList.txt");
            }


            catch (Exception e) {


                System.out.println("Error Occurred  in adding" + e);
            }


        }

    }
}

