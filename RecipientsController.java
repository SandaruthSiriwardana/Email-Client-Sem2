package email;

public  abstract class RecipientsController {
    //private Recipients Recipe;
    // factory method
    public abstract Recipients RecipientsFactory(String name,String email,String designation);

    public void makeRecipient(String name, String email, String designation){
        Recipients Recipt=RecipientsFactory(name, email, designation);
        Recipt.makeRecipien();

    }
}
