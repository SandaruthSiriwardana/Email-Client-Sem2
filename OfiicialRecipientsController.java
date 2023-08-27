package email;

public class OfiicialRecipientsController extends RecipientsController {
    @Override
    public Recipients RecipientsFactory(String name,String email,String designation) {
        return new OfficialRecipients(name,email,designation);
    }

}

