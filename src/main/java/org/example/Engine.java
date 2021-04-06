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
            // target record not found
            //
            if (!found) {
                res.addRemoved(sourceRecord);
            }

            //
            // compare source to target
            //

            if (found) {
                // todo: different? Engine.compare(sourceRecord, targetRecord)
                // for column in one/record

                // compare to same index in two/record

                // any differences? save
            }

            // other cases? - added
            //
            // search for added instances
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
        res.getRemoved().forEach(Result::printId);

        System.out.println("changed : " + res.getChanged().size());
        res.getChanged().forEach(Result::printId);

        System.out.println("added : " + res.getAdded().size());
        res.getAdded().forEach(Result::printId);

        return res;
    }

}
