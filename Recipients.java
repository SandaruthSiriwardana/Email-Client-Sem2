package email;


public abstract class Recipients {

    public abstract void setName(String name);
    public  abstract String getName();
    public abstract void setEmail(String email);
    public abstract String getEmail();
    public abstract void makeRecipien();
    public abstract String getStatus();
    public void sendEmail(String toEmail,String subject,String content){
        Email newOne=new Email(toEmail, subject, content); // make email
        newOne.send(toEmail,subject,content);
    }
}

