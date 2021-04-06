package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {

    //
    // state
    //

    List<Record> removed;
    List<Record> changed;
    List<Record> added;

    //
    // factory
    //
    private Result(){}

    public static Result init() {
        Result result = new Result();
        result.removed = new ArrayList<>();
        result.changed = new ArrayList<>();
        result.added = new ArrayList<>();
        return result;
    }

    //
    // api
    //

    public void setHeader(Record record) {

    }

    public void addChanged(Record record) {
        changed.add(record);
    }

    public List<Record> getChanged() {
        return this.changed;
    }

    public void addRemoved(Record record) {
        removed.add(record);
    }

    public List<Record> getRemoved() {
        return this.removed;
    }

    public void addAdded(Record record) {
        added.add(record);
    }

    public List<Record> getAdded() {
        return this.added;
    }

    public static void printId(Record record) {
        System.out.println(record.getId());
    }

}
