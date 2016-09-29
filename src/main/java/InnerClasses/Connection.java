package InnerClasses;

/**
 * Created by abijah on 9/27/16.
 */
public interface Connection {

    String getIp();



    int getPort();



    String getProtocol();



     String Connect();

    void close();


}
