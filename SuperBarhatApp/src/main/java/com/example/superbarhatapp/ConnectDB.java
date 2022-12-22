package com.example.superbarhatapp;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ConnectDB {
    Connection dbConnect;
    private static final String host = "127.0.0.1";
    private static final String port ="3306";
    private static   final String nameDB = "model1";
    private static   final String userDB = "root";
    private static   final String passDB = "admin_123";


    public Connection getDbConnection() throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + host + ":"
                + port + "/" + nameDB;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnect = DriverManager.getConnection(connectionString,
                userDB , passDB);
        return dbConnect;
    }

    //Метод Авторизации(проверка наличия логина и пароля в БД)
    public ResultSet getUser(String login, String password){
        ResultSet resSet = null;

        //Формирование запроса
        String select = "SELECT * FROM "+nameDB+".workers WHERE login = ? and password = ?";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            prSt.setString(1, login);
            prSt.setString(2, password);
            resSet = prSt.executeQuery();

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resSet;
    }

    public ResultSet getTableWorkers(){
        ResultSet resSet = null;
        String select = "SELECT post_id, fio, login, password, last_login, Type_login FROM "+userDB+".workers";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(select);
            resSet = prSt.executeQuery();


        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return resSet;
    }
    public void updateTime(String login) throws SQLException{
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String update = "update model1.workers set last_login = '"+simpleDateFormat.format(date)+"' where login = '"+login+"';";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(update);
            prSt.executeUpdate(update);

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
