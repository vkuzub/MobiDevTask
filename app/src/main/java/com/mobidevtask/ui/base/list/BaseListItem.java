package com.mobidevtask.ui.base.list;

/**
 * Created by Vyacheslav on 29.12.2016.
 */

public class BaseListItem {

    private String url;
    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
