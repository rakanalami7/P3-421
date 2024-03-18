import java.util.Scanner;
import java.sql.* ;

public class Database {
    public static void main(String[] args) throws SQLException {
        new Database().startUserLoop();
    }

    private final Scanner scanner;
    private final Connection connection;
    private final Statement statement;
    public Database() throws SQLException {
        scanner= new Scanner(System.in);
        // Register the driver.  You must register the driver before you can use it.
        try { DriverManager.registerDriver ( new com.ibm.db2.jcc.DB2Driver() ) ; }
        catch (Exception cnfe){ System.out.println("Class not found"); }
        String url = "jdbc:db2://winter2024-comp421.cs.mcgill.ca:50000/comp421";

        //TODO do not hard code your password in the submission
        String your_userid = null;
        String your_password = null;

        if(your_userid == null && (your_userid = System.getenv("SOCSUSER")) == null)
        {
            System.err.println("Error!! do not have a password to connect to the database!");
            System.exit(1);
        }
        if(your_password == null && (your_password = System.getenv("SOCSPASSWD")) == null)
        {
            System.err.println("Error!! do not have a password to connect to the database!");
            System.exit(1);
        }

        connection = DriverManager.getConnection(url,your_userid,your_password);
        statement = connection.createStatement ( ) ;


    }

    private void parseUserInput(String input){
        try{
            int choice = Integer.parseInt(input);

            switch (choice){
                case 1->browse();
                case 2->purchase();
                case 3->join();
                case 4->opt4();
                case 5->opt5();
                case 6->terminateProgram(0);
                default -> throw new Exception();
            }

        }catch (Exception e){
            System.out.printf("Invalid input [%s], please enter a number ranging from 1 to 6\n",input);
        }
    }

    private void terminateProgram(int exitCode) throws SQLException {
        if(exitCode!=0){
            System.out.println("program terminating because of some error");
        }

        statement.close();
        connection.close();
        System.exit(exitCode);
    }

    public void startUserLoop(){
        System.out.println("started");
        while (true){
            System.out.println("""
                    Book Store Main Menu:
                        Please select one of the following options:
                        1. Browse available books
                        2. Purchase a book
                        3. Join our store membership
                        4. TODO
                        5. TODO
                        6. Quit
                    """);
            System.out.print(">>");
            parseUserInput(scanner.nextLine());
        }
    }

    private void browse(){
        //TODO andres

    }
    private void purchase(){
        //TODO andres

    }
    private void join(){
        //TODO andres

    }
    private void opt4(){
        //todo whoever chooses to do this
    }
    private void opt5(){
        //todo whoever chooses to do this
    }


}
