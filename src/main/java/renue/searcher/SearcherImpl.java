package renue.searcher;

import renue.dto.ColumnType;
import renue.dto.RowReferenceDto;
import renue.loader.Loader;

import java.util.List;
import java.util.TreeMap;

public class SearcherImpl implements Searcher {

    private final Loader loader;
    private final TreeMap<String, List<RowReferenceDto>> rowReferences;

    public SearcherImpl(Loader loader) {
        this.loader = loader;
        this.rowReferences = loader.loadAll();
    }

    @Override
    public TreeMap<Integer, String> search(String searchString) {
        TreeMap<Integer, String> foundRowReferences = new TreeMap<>();
        searchString = searchString.toLowerCase();

        if (loader.getColumnType().equals(ColumnType.STRING) && !searchString.equals("\\n")) {
            searchString = "\"" + searchString;
        }

        for (String key : rowReferences.keySet()) {
            if (key.startsWith(searchString)) {
                for (RowReferenceDto rowReferenceDto : rowReferences.get(key)) {
                    foundRowReferences.put(rowReferenceDto.getIndex(), rowReferenceDto.getColumnContent());
                }
            } else {
                if (!foundRowReferences.isEmpty()) {
                    return foundRowReferences;
                }
            }
        }
        return foundRowReferences;
    }
}