package eu.servertje.model;

import java.io.Serializable;

/**
 * Author: ronald
 * Date:   9/10/14
 * Description:
 */
public class DefaultContent implements Content, Serializable {

    public DefaultContent() {}

    public DefaultContent(String title, ContentType type) {
        this.title = title;
        this.type = type;
    }

    private String title = "default";
    private ContentType type = ContentType.NONE;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public ContentType getType() {
        return type;
    }
}

