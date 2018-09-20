import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class CRUD {
    public static Connection connection = null;
    static Statement statement = null;
    static ResultSet resultSet = null;

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        boolean goLoop = true;
        while(goLoop)
        {
            System.out.print("C = 1  ,  R = 2  .  U = 3  ,  D = 4  ,  EXIT = -1   \n선택하세요 : ");

            switch (scanner.nextInt()) {
                case 1:
                    CreateData();
                    break;

                case 2:
                    ReadData();
                    break;

                case 3:
                    UpdateData();
                    break;

                case 4:
                    DeleteData();
                    break;

                case -1:
                    goLoop = false;
                    break;
            }
        }
        System.out.println("종료합니다.");
    }

    public static void CreateData()
    {
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/crud?autoReconnect=true&useSSL=false", "root","12341234");
            statement = connection.createStatement();

            preparedStatement = connection.prepareStatement( " INSERT INTO crud.info2 (id, name, number)" + " values (?, ?, ?)");

            Scanner scanner = new Scanner(System.in);
            System.out.print("ID : ");
            int id = scanner.nextInt();
            System.out.print("name : ");
            String name = scanner.next();
            System.out.print("number : ");
            String number = scanner.next();

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,number);
            preparedStatement.executeUpdate();

            System.out.println("Create 완료");
            preparedStatement.close();
            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("클래스 찾기 불가." + cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        finally {
            if(connection != null) try { connection.close(); } catch (SQLException se) {}
            if(statement != null) try { statement.close(); } catch (SQLException se){}
            if(preparedStatement != null) try { preparedStatement.close(); } catch (SQLException se){}
        }
    }

    public static void ReadData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/crud?autoReconnect=true&useSSL=false", "root","12341234");
            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM crud.info2");
            System.out.println("ID 이름  전홥번호");
            System.out.println("------------------");

            while(resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String number = resultSet.getString("number");
                System.out.println(id + " " + name + " " + number);
            }

            System.out.println("Read 완료");

            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("클래스 찾기 불가." + cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        finally {
            if(connection != null) try { connection.close(); } catch (SQLException se) {}
            if(statement != null) try { statement.close(); } catch (SQLException se){}
            if(resultSet != null) try { resultSet.close(); } catch (SQLException se){}
        }
    }

    public static void UpdateData() {
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/crud?autoReconnect=true&useSSL=false", "root","12341234");
            statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);
            System.out.print("ID : ");
            int id = scanner.nextInt();
            System.out.print("name : ");
            String name = scanner.next();
            System.out.print("number : ");
            String number = scanner.next();

            preparedStatement = connection.prepareStatement(  " UPDATE crud.info2 SET name = ?, number = ? WHERE id = ?");

            preparedStatement.setString(1,name);
            preparedStatement.setString(2,number);
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();

            System.out.println("Update 완료");
            preparedStatement.close();
            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("클래스 찾기 불가." + cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        finally {
            if(connection != null) try { connection.close(); } catch (SQLException se) {}
            if(statement != null) try { statement.close(); } catch (SQLException se){}
            if(preparedStatement != null) try { preparedStatement.close(); } catch (SQLException se){}
        }
    }

    public static void DeleteData() {
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/crud?autoReconnect=true&useSSL=false", "root","12341234");
            statement = connection.createStatement();

            Scanner scanner = new Scanner(System.in);
            System.out.print("ID : ");
            int id = scanner.nextInt();

            preparedStatement = connection.prepareStatement(  "DELETE FROM crud.info2 WHERE id = ?");

            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

            System.out.println("Delete 완료");
            preparedStatement.close();
            statement.close();
            connection.close();
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("클래스 찾기 불가." + cnfe.getMessage());
        }
        catch (SQLException se) {
            System.out.println(se.getMessage());
        }
        finally {
            if(connection != null) try { connection.close(); } catch (SQLException se) {}
            if(statement != null) try { statement.close(); } catch (SQLException se){}
            if(preparedStatement != null) try { preparedStatement.close(); } catch (SQLException se){}
        }
    }
}