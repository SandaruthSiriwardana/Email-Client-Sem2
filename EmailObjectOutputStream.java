package email;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


public class EmailObjectOutputStream extends ObjectOutputStream {

    EmailObjectOutputStream() throws IOException
    {

        // Super keyword refers to parent class instance
        super();
    }


    public EmailObjectOutputStream(OutputStream o) throws IOException
    {
        super(o);
    }

    // Method of this class
    public void writeStreamHeader() throws IOException
    {
        return;
    }
}
