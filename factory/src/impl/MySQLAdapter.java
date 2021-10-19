package impl;

import db.IDBAdapter;
import util.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySQLAdapter implements IDBAdapter {


    //ruta donde se encuentra el archivo .properties con las datos de conexion a la BD
    private static final String DB_PROPERTIES = "META-INF/DBMySql.properties";

    //propiedades de los archivos properties
    private static final String DB_NAME = "dbname";
    private static final String DB_HOST = "host";
    private static final String DB_PORT = "port";
    private static final String DB_USER = "user";
    private static final String DB_PASSWORD = "password";

    //bloque estatico para registrar el driver de Postgres
    static {
        try{
            new com.mysql.jdbc.Driver();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        try {
            String connectionString = createConnectionString();
            Connection connection = DriverManager.getConnection(connectionString);
            System.out.println("connection class = " + connection.getClass().getName());
            return null;
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String createConnectionString() {
        Properties prop = PropertiesUtil.loadProperty(DB_PROPERTIES);
        String host = prop.getProperty(DB_HOST);
        String db = prop.getProperty(DB_NAME);
        String port = prop.getProperty(DB_PORT);
        String user = prop.getProperty(DB_USER);
        String password = prop.getProperty(DB_PASSWORD);

        String connectionString = "jdbc:postgresql://" + host + ":" + port + "/"
                + db + "?user=" + user + "&password=" + password;
        System.out.println("connectionString = " + connectionString);
        return connectionString;
    }
}
