package email;

import java.io.Serializable;

public class PersonalRecipients extends Recipients implements Serializable {
    private String name;
    private String nickName;
    private String email;
    private String birthDay;
    private final String status="Personal";

    public PersonalRecipients(String name,String nickName,String email){
        this.name=name;
        this.email=email;
        this.nickName=nickName;
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
    public void setNickName(String nickName){
        this.nickName=nickName;
    }
    public String getNickName(){
        return this.nickName;
    }
    @Override
    public void makeRecipien() {
        EmailCollection.AddNewRecipiet(this);
    }

    @Override
    public String getStatus() {
        return this.status;
    }

    public void setBirthDay(String birthDay){this.birthDay=birthDay;}

    public String getBirthDay(){return this.birthDay;}

    public void birthdayGreeting(String toEmail,String subject,String content){
        System.out.println("Today have one of personal friend Birth Day,wait for sending birth day Greetings ");
        Email birthdayWish=new Email(toEmail, subject, content);
        birthdayWish.send(toEmail, subject, content);
    }
}
