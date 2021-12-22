import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RunApi {
    Properties properties;

    public String baseUri;
    public String basePath1;



    public void loadProperties(){
        FileInputStream fis = null;

        try{
            properties = new Properties();
            fis = new FileInputStream("C:\\Qa29\\BookStore\\src\\test\\resources\\config.properties");
            properties.load(fis);

            baseUri = properties.getProperty("web.baseUrl");
            System.out.println(baseUri);
            basePath1 = properties.getProperty("basePath1");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
