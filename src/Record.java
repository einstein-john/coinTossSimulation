import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Record {
    File outputOBJ = new File("record.txt");
    PrintWriter PW = new PrintWriter(new FileWriter(outputOBJ,true));

    public Record(String text) throws IOException {

        PW.println(text);
        PW.close();
    }


}
