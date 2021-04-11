package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {

    //
    // state
    //

    Record header;

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
        header = record;
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

    public static void printRow(Record record) {
        printContent(record.getRow());
    }

    public static void printHeader(Record record) {
        printContent(record.getRow());
    }

    private static void printContent(List<String> content) {
        for (int i = 0; i < content.size(); i++) {
            if (i == 0) {
                System.out.print(content.get(i));
            } else {
                System.out.print("," + content.get(i));
            }
        }
        System.out.print("\n");
    }

}
