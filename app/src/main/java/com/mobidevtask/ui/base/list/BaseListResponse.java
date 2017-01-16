package com.mobidevtask.ui.base.list;

import java.util.List;

/**
 * Created by Vyacheslav on 29.12.2016.
 */

public class BaseListResponse<T extends BaseListItem> {

    private int count;
    private String previous;
    private String next;
    private List<T> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
