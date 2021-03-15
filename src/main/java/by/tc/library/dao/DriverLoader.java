package by.tc.library.dao;


public class DriverLoader {

    private static final DriverLoader instance = new DriverLoader();

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    private DriverLoader(){}
    public static DriverLoader getInstance(){
        return instance;
    }
}
