package org.example;

import java.util.Arrays;
import java.util.List;

public class Engine {

    public static Result compare(String source, String target) {

        Result res = Result.init();

        List<String> sourceRecords = Arrays.asList(source.split("\n"));
        List<String> targetRecords = Arrays.asList(target.split("\n"));

        if (sourceRecords.isEmpty() || targetRecords.isEmpty()) {
            //
            // exit when empty
            //
            System.err.println("nothing to compare");
            return res;
        }

        for (int i = 0; i < sourceRecords.size(); i++) {
            //
            // compare source records to target
            //
            Record sourceRecord = Record.of(sourceRecords.get(i).split(","));

            if (i == 0) {
                //
                // sniff header
                //
                res.setHeader(sourceRecord);
                continue;
            }

            //
            // search for component in target list
            //
            String sourceId = sourceRecord.getId();
            Record targetRecord = null;
            boolean found = false;
            for (int j = 1; j < targetRecords.size(); j++) {
                Record checkRecord = Record.of(targetRecords.get(j).split(","));
                String targetId = checkRecord.getId();
                if (sourceId.equals(targetId)) {
                    //
                    // target record found
                    //
                    if (found) { System.err.println("duplicate found : " + targetId);}
                    targetRecord = checkRecord;
                    found = true;
                }
            }

            //
            // target record not found: added (present in source but not in target)
            //

            if (!found) {
                res.addAdded(sourceRecord);
            }

            //
            // compare source to target
            //

            if (found) {
                Record changedRecord = Record.of(sourceRecords.toArray(new String[0]));
                List<String> sourceRecordContent = sourceRecord.getRow();
                List<String> targetRecordContent = targetRecord.getRow();
                boolean anyDifferent = false;
                for (int ii = 0; ii < sourceRecordContent.size(); ii++) {
                    String sourceRecordVal = sourceRecordContent.get(ii);
                    String targetRecordVal = targetRecordContent.get(ii);
                    boolean valIsId = (ii == 0);
                    if (valIsId) {
                        changedRecord.setContentAt(sourceRecordVal, ii);
                    }
                    boolean recordsAreDifferent = (!sourceRecordVal.equals(targetRecordVal));
                    if (recordsAreDifferent) {
                        anyDifferent = true;
                        changedRecord.setContentAt(targetRecordVal, ii);
                    } else if (!valIsId) {
                        changedRecord.setContentAt("", ii);
                    }
                }
                if (anyDifferent) {
                    res.addChanged(changedRecord);
                }
            }

            //
            // search for removed records (present in target but not in source)
            //

            // for targetRecord

                // get targetId

                // search for targetId in sourceRecords

                // found ? void : added;
        }

        //
        // summarize results
        //
        System.out.println("removed : " + res.getRemoved().size());
        Result.printHeader(res.header);
        res.getRemoved().forEach(Result::printRow);
        System.out.println("");

        System.out.println("changed : " + res.getChanged().size());
        Result.printHeader(res.header);
        res.getChanged().forEach(Result::printRow);
        System.out.println("");

        System.out.println("added : " + res.getAdded().size());
        Result.printHeader(res.header);
        res.getAdded().forEach(Result::printRow);
        System.out.println("");

        return res;
    }

}
