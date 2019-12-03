package orm;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;

import java.util.List;

// local libs
import org.json.JSONObject;

// personnal imports
import json.JSONReader;

import orm.query.SQLQuery;
import orm.query.clause.AbstractClause;
import orm.query.clause.CreateTableClause;
import orm.query.clause.SelectClause;
import orm.query.clause.FromClause;
import orm.query.clause.InsertIntoClause;
import orm.query.clause.UpdateClause;
import orm.query.clause.DeleteClause;
import orm.query.clause.DropTableClause;
import orm.model.table.SQLTable;

/**
 * The class <code>ORM<code> is the base class of the ORM. It 
 * stores the current connection and enable the user to connect/deconnect 
 * him
 * @version 1.0
 * @author Dorian TERBAH
 */
public class ORM
{
    /**
     * Constant used to get the class of the Maria DB Driver
     */
    private static final String MARIA_DB_DRIVER = "org.mariadb.jdbc.Driver";
    /**
     * JSON key to get the hostname in the config file
     */
    private static final String HOSTNAME_JSON_KEY = "hostname";
    /**
     * JSON key to get the user in the config file
     */
    private static final String USER_JSON_KEY = "user";
    /**
     * JSON key to get the password in the config file
     */
    private static final String PASSWORD_JSON_KEY = "password";
    /**
     * JSON key to get the port in the config file
     */
    private static final String PORT_JSON_KEY = "port";
    /**
     * JSON key for the database to use
     */
    private static final String DATABASE_JSON_KEY = "database";

    /**
     * The current connection to the database
     */
    private static Connection currentConnection;

    private ORM()
    {
        // nothing for the moment
    }

    /**
     * Establish a connection with the database
     * @param jsonPath The path of the JSON file config
     * 
     * @return <code>true</code> if the connection has been established, <code>false</code>
     */
    public static boolean connect(String jsonPath) 
    {
        return connect(new File(jsonPath));
    }

    /**
     * Establish a connection with the database
     * @param file The JSON config file
     * @return <code>true</code> if the connection has been established, <code>false</code>
     */
    public static boolean connect(File file)
    {
        JSONObject json = JSONReader.readJSONFile(file);
        if(json == null)
        {
            return false;
        }

        // retrieve the information of the json
        String user = json.getString(USER_JSON_KEY);
        String password = json.getString(PASSWORD_JSON_KEY);
        String hostname = json.getString(HOSTNAME_JSON_KEY);
        String port = json.getString(PORT_JSON_KEY);
        String url = "jdbc:mysql://" + hostname + ":" + port;
        String database = json.getString(DATABASE_JSON_KEY);

        return connect(url, database, user, password);
    }

    /**
     * Establish a connection with the database
     * @param hostname The hostname of the database
     * @param database The database to use
     * @param user The user name for the database
     * @param password The password for the databse
     * @return <code>true</code> if the connection has been established, <code>false</code>
     */
    private static boolean connect(String hostname, String database, String user, String password)
    {
        // try to get a connection with the database
        try
        {
            ORM.currentConnection = DriverManager.getConnection(hostname, user, password);
        } catch(SQLException connectionException)
        {
            System.err.println("Not enable to get a connection with your database");
            connectionException.printStackTrace();
            return false;
        }

        try {
            Statement stmt = ORM.currentConnection.createStatement();
            stmt.execute("use " + database);
            stmt.close();
        } catch(SQLException chooseDatabaseException)
        {
            System.out.println(chooseDatabaseException.getMessage());
            return false;
        }

 
        return true;
    }

    /**
     * Close the connection to the database
     * @return <code>true</code> if the connection is closed, else <code>false</code>
     */
    public static boolean close()
    {
        try
        {
            ORM.currentConnection.close();
        } catch(SQLException closeException)
        {
            return false;
        }

        return true;
    }

    /**
     * Get the current connection
     * @return The current connection
     */
    public static Connection getConnection()
    {
        return ORM.currentConnection;
    }

    /**
     * Method that has to load the Maria Driver for the JVM
     * @return <code>true</code> if the driver has been loaded, <code>false</code> else
     */
    public static final boolean loadMariaDBDriver()
    {
        try
        {
            Class.forName(MARIA_DB_DRIVER);
        } catch(ClassNotFoundException notFoundException) 
        {
            return false;
        }

        return true;
    }

    /**
     * Method that load a SQL driver
     * 
     * @param driver The driver to use
     * @return <code>true</code> if the driver has been correctly loaded, <code>false</code> else
     */

    public static final boolean loadDriver(Driver driver)
    {
        try
        {
            Class.forName(driver.getClass().getCanonicalName());
            DriverManager.registerDriver(driver);
        } catch(ClassNotFoundException notFoundException)
        {
            return false;
        }
        catch(SQLException sqlException)
        {
            return false;
        }

        return true;
    }

    // ---------- Select methods ----------- //

    /**
     * Create a select clause for the current query
     * @param field The field to select 
     * @return The SQLQuery associated with the current query
     */
    public static SQLQuery select(String field)
    {
        AbstractClause select = new SelectClause(field);
        return new SQLQuery(select);
    }

    /**
     * Create a select clause for the current query
     * @param fields The fields to select
     * @return The SQLQuery associated with the current query
     */
    public static SQLQuery select(String ...fields)
    {
        AbstractClause select = new SelectClause(fields);
        return new SQLQuery(select);
    }

    /**
     * Create a select clause for the current query
     * @param fieldList The list of the fields to select
     * @return The SQLQuery associated with the current query
     */
    public static SQLQuery select(List<String> listFields)
    {
        AbstractClause select = new SelectClause(listFields);
        return new SQLQuery(select);
    }


    // ----------- Insert/Update methods --------- //

    /**
     * Create an insert clause for the current query
     * @param table The target table for the insertion
     * @return The current SQLQuery
     */
    public static SQLQuery insertInto(String table, String... columns)
    {
        return new SQLQuery(new InsertIntoClause(table, columns));
    }

    /**
     * Create an insert clause for the current query
     * @param table The target table for the insertion
     * @param columns The current SQLQuery
     * @return A new SQLQuery
     */
    public static SQLQuery insertInto(String table, List<String> columns)
    {
        return new SQLQuery(new InsertIntoClause(table, columns));
    }

    /**
     * Create an update clause for the current query
     * @param table The target table for the update
     * @return A new SQLQuery
     */
    public static SQLQuery update(String table)
    {
        return new SQLQuery(new UpdateClause(table));
    }

    /**
     * Create a delete clause for the current query
     * @param table The target table for the delete
     * @return A new SQLQuery
     */
    public static SQLQuery deleteFrom(String table)
    {
        return new SQLQuery(new DeleteClause(table));
    }

    // ------------ All method -------- //

    /**
     * Select all of the fields of a table
     * @param table The target table
     * @return The SQLQuery associated with the current query
     */
    public static SQLQuery all(String table)
    {
        return new SQLQuery(new SelectClause("*"), new FromClause(table));
    }

    // ----------- Table methods ---------- //

    /**
     * Create a new table in the database
     * @param table The new table to create
     * @return The SQLQuery associated with the current query
     */
    public static SQLQuery createTable(SQLTable table)
    {
        return new SQLQuery(new CreateTableClause(table));
    }
    
    /**
     * Drop a table in the database
     * @param tableName The name of the table
     * @return The SQLQuery associated with the current query
     */
    public static SQLQuery dropTable(String tableName)
    {
        return new SQLQuery(new DropTableClause(tableName));
    }
}