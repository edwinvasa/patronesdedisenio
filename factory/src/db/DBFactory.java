package db;

import db.IDBAdapter;
import impl.MySQLAdapter;
import impl.PostgresAdapter;
import util.PropertiesUtil;

import java.util.Properties;

public class DBFactory {

    private static final String DB_FACTORY_URL = "META-INF/DBFactory.properties";
    private static final String DEFAULT_DB_CLASS = "defaultDBClass";

    public static IDBAdapter getDBAdapter(DBType dbType){
        switch(dbType) {
            case MySQL:
                return new MySQLAdapter();
            case PostgreSQL:
                return new PostgresAdapter();
            default:
                throw new IllegalArgumentException("No esta soportado");
        }
    }

    public static IDBAdapter getDefaultDBAdapter(){
        try{
            Properties prop = PropertiesUtil.loadProperty(DB_FACTORY_URL);
            String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS);
            System.out.println("defaultDBClass = " + defaultDBClass);
            return (IDBAdapter) Class.forName(defaultDBClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
