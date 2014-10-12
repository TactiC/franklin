package eu.servertje.model;

/**
 * Author: ronald
 * Date:   9/9/14
 * Description:
 */
public interface ContentService {

    void create(Content content);
    Content read();
    Content update();
    Content delete();
}
