package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class CSVRead {

    public String[] CSVTestDataRead()
    {
        String line = "";
        String splitBy = ";";
        String[] datas = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/TestData.csv"));
            while ((line = br.readLine()) != null)
            {
                datas = line.split(splitBy);
            }
            return datas;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
