package ru.zhenabomzha.myTextRPG.config;

import ru.zhenabomzha.myTextRPG.enums.errors.Errors;
import ru.zhenabomzha.myTextRPG.gameInfo.GameInfo;
import ru.zhenabomzha.myTextRPG.input.ConsoleUserInput;
import ru.zhenabomzha.myTextRPG.output.ConsoleOutputService;
import ru.zhenabomzha.myTextRPG.parser.Parser;

import java.security.PublicKey;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class AppConfig {

    private final HashMap<Class, Object> appConfig = new HashMap<>();

    public <T> T getImplementation(Class<T> clazz) {
        return Optional.ofNullable(appConfig.get(clazz))
                .map(clazz::cast)
                .orElseThrow(() -> new RuntimeException(Errors.GET_CLASS_ERROR.getError()));
    }

    public AppConfig() {
        configureInputService();
        configureOutputService();
        configureParser();
        configureGameInfo();
    }

    private void configureInputService() {
        ConsoleUserInput consoleUserInput = new ConsoleUserInput();
        appConfig.put(consoleUserInput.getClass(), consoleUserInput);
    }

    private void configureOutputService() {
        ConsoleOutputService consoleOutputService = new ConsoleOutputService();
        appConfig.put(consoleOutputService.getClass(), consoleOutputService);
    }

    private void configureParser() {
        Parser parser = new Parser();
        appConfig.put(parser.getClass(), parser);
    }

    private void configureGameInfo() {
        GameInfo gameInfo = new GameInfo("default", 1);
        appConfig.put(gameInfo.getClass(), gameInfo);
    }
}
