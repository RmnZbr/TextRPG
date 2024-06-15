package ru.zhenabomzha.myTextRPG.output;

import ru.zhenabomzha.myTextRPG.output.outputDto.OutputDto;

public class ConsoleOutputService implements OutputService {


    @Override
    public void print(OutputDto dto) {

        System.out.println(dto.getMessage());

    }
}
