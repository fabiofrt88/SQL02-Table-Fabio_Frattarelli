import java.sql.*;

public class Driver {
    public static void main(String[] args) {

        Connection connection = null;

        try {

            String url = "jdbc:mysql://localhost:3306/newdb";
            String user = "developer";
            String password = "developer";

            connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            String createTable = "CREATE TABLE IF NOT EXISTS `students` ( "
                    + "  `student_id` int(10) NOT NULL AUTO_INCREMENT, "
                    + "  `last_name` varchar(30) DEFAULT NULL, "
                    + "  `first_name` varchar(30) DEFAULT NULL, "
                    + "  `country` varchar(30) DEFAULT NULL, "
                    + "  PRIMARY KEY (`student_id`) "
                    + ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;";

            statement.execute(createTable);

            System.out.println("Table!");

            String students1 = "INSERT INTO newdb.students\n" +
                    "(student_id, last_name, first_name)\n" +
                    "VALUES(0, 'Rossi', 'Pino')";

            String students2 = "INSERT INTO newdb.students\n" +
                    "(student_id, last_name, first_name)\n" +
                    "VALUES(0, 'Verdi', 'Carlo')";

            String students3 = "INSERT INTO newdb.students\n" +
                    "(student_id, last_name, first_name)\n" +
                    "VALUES(0, 'Paoli', 'Gino')";

            String students4 = "INSERT INTO newdb.students\n" +
                    "(student_id, last_name, first_name)\n" +
                    "VALUES(0, 'Polo', 'Marco')";

            statement.executeUpdate(students1);
            statement.executeUpdate(students2);
            statement.executeUpdate(students3);
            statement.executeUpdate(students4);

            System.out.println("Popoulate table and parameters");

            statement.close();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
