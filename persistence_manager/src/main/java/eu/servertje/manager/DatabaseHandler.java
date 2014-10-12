package eu.servertje.manager;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;
import java.util.List;

/**
 * Author: ronald
 * Date:   9/10/14
 * Description:
 */
public class DatabaseHandler {

    private static final String SERVER_NAME = "localhost";
    private static final int    SERVER_PORT = 27017;
    private static final String DEFAULT_DB = "default_db";

    private static final DatabaseHandler instance;
    private MongoClient mongoClient;
    private DB db;
    private String serverName;
    private String dbName;
    private int port;

    static {
        instance = new DatabaseHandler();
    }

    /**
     *
     * @return
     */
    public static DatabaseHandler getInstance() {
        return instance;
    }


    public void create() throws UnknownHostException {
        if (mongoClient == null) {
            connect();
        }

        DBCollection coll = db.getCollection("test_collection");
        BasicDBObject obj = new BasicDBObject();
        obj.put("name", "Ronald de Haan");
        obj.put("age", 36);
        coll.insert(obj);
    }

    public void shutdown() {
        mongoClient.close();
    }

    // This should be renamed to list or something...
    public void getDatabaseNames() {
        List<String> dbNames = mongoClient.getDatabaseNames();
        for (String s : dbNames) {
            System.out.println("Database name is: " + s);
        }
    }

    private void connect() throws UnknownHostException {
        System.out.println("Connecting to mongoDb");
        this.mongoClient = new MongoClient(serverName, port);
        this.db = this.mongoClient.getDB(DEFAULT_DB);
    }

    /**
     * Private constructor
     */
    private DatabaseHandler() {
        // todo: fetch these values from some properties file
        this.port = SERVER_PORT;
        this.serverName = SERVER_NAME;
        this.dbName = DEFAULT_DB;
    }
}
