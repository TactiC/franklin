package eu.servertje.manager;

import eu.servertje.model.Content;
import eu.servertje.model.ContentService;
import eu.servertje.model.DefaultContent;

import java.net.UnknownHostException;

/**
 * Author: ronald
 * Date:   9/9/14
 * Description:
 */
public class ContentServiceImpl implements ContentService {

    private DatabaseHandler databaseHandler;

    public ContentServiceImpl() {
        this.databaseHandler = DatabaseHandler.getInstance();
    }

    @Override
    public void create(Content content) {
        System.out.printf("Create content: title: %s type: %s ",
                content.getTitle(),
                content.getType());
        try {
            this.databaseHandler.create();
        } catch (UnknownHostException e) {
            //todo: do something funky with this exception
            e.printStackTrace();
        }
        System.out.println("Listing all known databases");
    }

    @Override
    public Content read() {
        System.out.println("Read content");

        return new DefaultContent();
    }

    @Override
    public Content update() {
        System.out.println("Update content");
        return new DefaultContent();
    }

    @Override
    public Content delete() {
        System.out.println("Delete content");
        return new DefaultContent();
    }
}
