package org.example;

public class Record {

    private String[] content;

    private Record(){};

    public static Record of(String[] content) {
        Record record = new Record();
        record.content = content;
        return record;
    }

    public String getId() {
        int ID_POSITION = 0;
        return content[ID_POSITION];
    }
}
