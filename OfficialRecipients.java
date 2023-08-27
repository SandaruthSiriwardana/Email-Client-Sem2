package email;
import java.io.*;
public class OfficialRecipients extends Recipients implements Serializable{
    private String designation;
    private String name;
    private String email;
    private final String status="Official";

    public OfficialRecipients(String name, String email, String designation) {
        this.name=name;
        this.email=email;
        this.designation=designation;
    }

    public void setDesignation(String designation){this.designation=designation;}

    public String getStatus(){
        return this.status;
    }

    public String getDesignation(){
        return this.designation;
    }
    @Override
    public void setName(String name) {
        this.name=name;
    }
    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public void setEmail(String email) {
        this.email=email;
    }
    @Override
    public String getEmail() {
        return this.email;
    }
    @Override
    public void makeRecipien() {
        EmailCollection.AddNewRecipiet(this);
    } // serialize the recipe objects



}
