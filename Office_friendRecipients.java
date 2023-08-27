package email;

import java.io.Serializable;

public class Office_friendRecipients extends Recipients implements Serializable {
    private String name;
    private String email;
    private String designation;
    private String birthDay;
    private final String status="Office_friend";

    public Office_friendRecipients(String name,String email,String designation){
        this.name=name;
        this.email=email;
        this.designation=designation;
    }
    @Override
    public void setName(String name) {this.name=name;}
    @Override
    public String getName() {return this.name;}
    @Override
    public void setEmail(String email) {this.email=email;}
    @Override
    public String getEmail() {return this.email;}
    @Override
    public void makeRecipien() {EmailCollection.AddNewRecipiet(this);}//---------------------------------------------
    public void setDesignation(String designation){this.designation=designation;}
    public String getDesignation(){
        return this.designation;
    }
    public void setBirthDay(String w){this.birthDay=w;}
    public String getBirthDay(){return this.birthDay;}
    public String getStatus(){return this.status;}
    public void birthdayGreeting(String toEmail,String subject,String content){
        System.out.println("Today have office friend Birth Day,wait for sending birth day Greetings ");
        Email birthdayWish=new Email(toEmail, subject, content);
        birthdayWish.send(toEmail, subject, content);
    }

}
