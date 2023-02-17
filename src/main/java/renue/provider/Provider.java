package renue.provider;

import renue.dto.RowDto;

import java.util.stream.Stream;

public interface Provider {

    /**
     * Читает данные из файла в Stream<RowDto>
     */
    Stream<RowDto> stream();
}