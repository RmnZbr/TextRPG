package ru.zhenabomzha.myTextRPG.input;

import java.util.Scanner;

public class ConsoleUserInput implements InputService {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getUserInput() {
        return scanner.nextLine();
    }
}
