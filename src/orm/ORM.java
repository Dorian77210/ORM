package orm;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;

import java.io.File;

import java.util.List;

// local libs
import org.json.JSONObject;

// personnal imports
import json.JSONReader;

import orm.query.SQLQuery;
import orm.query.clause.AbstractClause;
import orm.query.clause.SelectClause;

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
     * The current connection for the database
     */
    private Connection currentConnection;

    private static final ORM instance = new ORM();

    private ORM()
    {
        // nothing for the moment
    }

    /**
     * Get the instance of the current ORM
     * @return The instance of the current ORM
     */
    public static final ORM instance()
    {
        return instance;
    }

    /**
     * Establish a connection with the database
     * @param jsonPath The path of the JSON file config
     * 
     * @return <code>true</code> if the connection has been established, <code>false</code>
     */
    public boolean connect(String jsonPath) 
    {
        return this.connect(new File(jsonPath));
    }

    /**
     * Establish a connection with the database
     * @param file The JSON config file
     * @return <code>true</code> if the connection has been established, <code>false</code>
     */
    public boolean connect(File file)
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

        return this.connect(url, user, password);
    }

    /**
     * Establish a connection with the database
     * @param hostname The hostname of the database
     * @param user The user name for the database
     * @param password The password for the databse
     * @return <code>true</code> if the connection has been established, <code>false</code>
     */
    private boolean connect(String hostname, String user, String password)
    {
        // try to get a connection with the database
        try
        {
            this.currentConnection = DriverManager.getConnection(hostname, user, password);
        } catch(SQLException connectionException)
        {
            System.err.println("Not enable to get a connection with your database");
            connectionException.printStackTrace();
            return false;
        }
 
        return true;
    }

    public boolean close()
    {
        try
        {
            this.currentConnection.close();
        } catch(SQLException closeException)
        {
            return false;
        }

        return true;
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
        } catch(ClassNotFoundException notFoundException)
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
}