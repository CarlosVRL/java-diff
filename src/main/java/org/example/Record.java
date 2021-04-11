package org.example;

import java.util.Arrays;
import java.util.List;

public class Record {

    private String[] row;

    private Record(){};

    public static Record of(String[] content) {
        Record record = new Record();
        record.row = content;
        return record;
    }

    public String getId() {
        int ID_POSITION = 0;
        return row[ID_POSITION];
    }

    public List<String> getRow() {
        return Arrays.asList(row);
    }

    public void setContentAt(String val, int at) {
        row[at] = val;
    }
}
