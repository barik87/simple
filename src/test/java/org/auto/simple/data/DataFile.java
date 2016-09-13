package org.auto.simple.data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.auto.simple.utils.FileSystemUtils;

public class DataFile {

    private File file;

    public DataFile(String dataFilePath) {
        this.file = new File(dataFilePath);
    }

    public List<HashMap<String, String>> getDataTable() {
        List<HashMap<String, String>> result = new ArrayList<>();
        List<String> lines = FileSystemUtils.getContents(file);
        String[] keys = lines.get(0).split(",");
        for (int i = 1; i < lines.size(); i++) {
            String[] values = lines.get(i).split(",");
            HashMap<String, String> iteration = new HashMap<>();
            for (int j = 0; j < keys.length; j++) {
                if (j == keys.length - 1) {
                    keys[j] = StringUtils.trim(keys[j]);
                    values[j] = StringUtils.trim(values[j]);
                }
                iteration.put(keys[j], values[j]);
            }
            result.add(iteration);
        }
        return result;
    }

}
