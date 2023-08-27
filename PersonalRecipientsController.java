package email;

public class PersonalRecipientsController extends RecipientsController{
    @Override
    public Recipients RecipientsFactory(String name, String nikName, String email) {
        return new PersonalRecipients(name,nikName,email);
    }
    public void makeRecipient(String name, String nickName,String email,String birthDay){
        Recipients Recipt=RecipientsFactory(name, nickName, email);
        PersonalRecipients convet =(PersonalRecipients) Recipt;
        convet.setBirthDay(birthDay);
        Recipt.makeRecipien();
    }
}
