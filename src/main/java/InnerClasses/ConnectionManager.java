package InnerClasses;

/**
 * Created by abijah on 9/27/16.
 */
public class ConnectionManager {

    int maxConnections;//initialize maximum connections
    int currentConnections = 0;//counts current connections

    public ConnectionManager(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public Connection makeConnection(String ip, String protocol) {
        if (currentConnections < maxConnections) {
            currentConnections++;
            return new ManagedConnection(ip, getPort(protocol), protocol);
        } else {
            return null;
        }

    }
    public Connection customConnection(String ip, int port, String protocol) {
        if (currentConnections <= maxConnections) {
            currentConnections++;
            return new ManagedConnection(ip, port, protocol);
        } else {
            return null;
        }
    }
    public Connection customConnection(String ip, int port){
        Connection returnvalue = customConnection(ip, port, "HTTP");
        return returnvalue;

    }

    private int getPort(String p) {
        if (p.equalsIgnoreCase("HTTP")) {
            return 80;

        } else if (p.equalsIgnoreCase("FTP")) {
            return 21;
        } else if (p.equalsIgnoreCase("TPS")) {
            return 10;
        }
        return 0;
    }


    private class ManagedConnection implements Connection {


        String ip;
        int port;
        String protocol;
        boolean isclosed=false;

        public ManagedConnection(String ip, int port, String protocol) {
            this.ip = ip;
            this.port = port;
            this.protocol = protocol;

        }

        public String getIp() {
            if (isclosed){
                return "Error 404";
            }
            else return ip;
        }


        public int getPort() {
            if (isclosed){
                return 404;
            }
            else return port;
        }


        public String getProtocol() {

            return protocol;
        }


        public String Connect() {
            if (isclosed){
                return "Error 404";
            }
            return "Connection was Successful";
        }

        public void close(){
            ConnectionManager.this.currentConnections--;
            isclosed=true;

        }
    }
}
