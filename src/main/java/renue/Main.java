package renue;

import renue.config.AppConfiguration;
import renue.dto.RowResultDto;
import renue.loader.Loader;
import renue.loader.LoaderImpl;
import renue.parser.CsvParserImpl;
import renue.printer.Printer;
import renue.printer.PrinterImpl;
import renue.provider.ProviderImpl;
import renue.searcher.Searcher;
import renue.searcher.SearcherImpl;

import java.util.List;
import java.util.Scanner;

import static renue.Constants.QUIT_COMMAND;

public class Main {
    private static final String SEARCH_LOG = "Количество найденных строк: %d, затраченное время на поиск: %d мс%n";
    private static final String INPUT_LOG = "Введите строку:";

    public static void main(String[] args) {
        AppConfiguration appConfiguration = AppConfiguration.of(args);

        Scanner scanner = new Scanner(System.in);

        Loader loader = new LoaderImpl(appConfiguration.getColumnIdx(), new CsvParserImpl(), new ProviderImpl(Constants.CSV_FILE_NAME));
        Searcher searcher = new SearcherImpl(loader);
        Printer printer = new PrinterImpl();

        System.out.println(INPUT_LOG);

        String input;
        while (!QUIT_COMMAND.equals(input = scanner.nextLine())) {
            long before = System.currentTimeMillis();
            List<RowResultDto> searchResult = loader.load(searcher.search(input));
            long took = System.currentTimeMillis() - before;

            printer.print(searchResult, loader.getColumnType());

            System.out.printf(SEARCH_LOG, searchResult.size(), took);
            System.out.println(INPUT_LOG);
        }
    }
}