package renue.provider;

import renue.dto.RowDto;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ProviderImpl implements Provider {
    private final String fileName;

    public ProviderImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Stream<RowDto> stream() {
        InputStream csv = getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        BufferedReader reader = new BufferedReader(new InputStreamReader(csv));

        AtomicInteger atomicInteger = new AtomicInteger();
        return reader.lines()
                .map(row -> new RowDto(row, atomicInteger.getAndIncrement()));
    }
}