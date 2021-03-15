package by.tc.library.dao.connection;

import java.util.ResourceBundle;

public class DBResourceManager {
    private static final DBResourceManager dbResourceManager = new DBResourceManager();
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    public static DBResourceManager getInstance(){
        return dbResourceManager;
    }
    public String getValue(String key){
        return resourceBundle.getString(key);
    }
}
