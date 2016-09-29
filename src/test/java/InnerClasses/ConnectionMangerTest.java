package InnerClasses;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by abijah on 9/28/16.
 */
public class ConnectionMangerTest {

    @Test

    public void reachMaxTest(){
        ConnectionManager cm = new ConnectionManager(3);
        cm.makeConnection("1", "HTTP");
        cm.makeConnection("1", "HTTP");
        cm.makeConnection("1", "HTTP");

        Assert.assertEquals("should be a null", null, cm.makeConnection("1", "HTTP"));

    }
    @Test
    public void customProtocolDefault(){
        ConnectionManager cm = new ConnectionManager(3);
        Connection c = cm.customConnection("1",5);
        Assert.assertEquals("should be HTTP", "HTTP",c.getProtocol() );
    }

    @Test

    public void closeTest(){
        ConnectionManager cm = new ConnectionManager(3);
        Connection c1 = cm.makeConnection("1", "HTTP");
        Connection c2 =cm.makeConnection("1", "HTTP");
        Connection c3= cm.makeConnection("1", "HTTP");
        Connection c4= cm.makeConnection("1", "HTTP");

        Assert.assertEquals("should be a null", null, c4);
        c1.close();
        c4 = cm.makeConnection("1", "HTTP");
        Assert.assertNotEquals("should be a null", null, c4);
    }
}
