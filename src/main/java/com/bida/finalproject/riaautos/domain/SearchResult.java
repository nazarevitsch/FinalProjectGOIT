package com.bida.finalproject.riaautos.domain;

import java.util.List;

public class SearchResult {

    private List<String> ids;
    private int count;
    private int lastId;

    public SearchResult(){}

    public SearchResult(List<String> ids, int count, int lastId) {
        this.ids = ids;
        this.count = count;
        this.lastId = lastId;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "ids=" + ids +
                ", count=" + count +
                ", lastId=" + lastId +
                '}';
    }
}
