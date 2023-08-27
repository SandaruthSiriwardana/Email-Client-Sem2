package email;

public class Office_friendRecipientsController extends RecipientsController {

    @Override
    public Recipients RecipientsFactory(String x, String y, String z) {
        return new Office_friendRecipients(x,y,z);
    }
    public void makeRecipient(String name, String email, String designation,String birthDay){
        Recipients Recipt=RecipientsFactory(name, email, designation);
        Office_friendRecipients convet =(Office_friendRecipients)Recipt;
        convet.setBirthDay(birthDay);
        Recipt.makeRecipien();

    }
}


