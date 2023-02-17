package renue.searcher;

import java.util.TreeMap;

/**
 * Занимается поиском строк
 */
public interface Searcher {
    /**
     * Ищет строки, которые начинаются со строки searchString.
     * Найденные строки помещаются в TreeMap, где ключом является индекс строки в файле,
     * соответствующий найденной строке
     */
    TreeMap<Integer, String> search(String searchString);
}