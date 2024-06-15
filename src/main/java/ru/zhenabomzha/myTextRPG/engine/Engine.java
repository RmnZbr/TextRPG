package ru.zhenabomzha.myTextRPG.engine;

import ru.zhenabomzha.myTextRPG.Hero.Mage;
import ru.zhenabomzha.myTextRPG.Hero.Priest;
import ru.zhenabomzha.myTextRPG.Hero.Warrior;
import ru.zhenabomzha.myTextRPG.battle.Battle;
import ru.zhenabomzha.myTextRPG.config.AppConfig;
import ru.zhenabomzha.myTextRPG.enums.errors.Errors;
import ru.zhenabomzha.myTextRPG.enums.titles.Titles;
import ru.zhenabomzha.myTextRPG.gameInfo.GameInfo;
import ru.zhenabomzha.myTextRPG.input.ConsoleUserInput;
import ru.zhenabomzha.myTextRPG.output.ConsoleOutputService;
import ru.zhenabomzha.myTextRPG.output.outputDto.OutputDto;
import ru.zhenabomzha.myTextRPG.parser.Parser;



public class Engine {

    private static final AppConfig appConfig = new AppConfig();


    public static void run() {
        showStaringTitles();
        enterPlayerNickname();
        showTitlesForChoosingArchetype();
        chooseArchetype();
        showFirstQuestTitles();
        battle();
    }

    public static ConsoleUserInput getInputService() {
        return appConfig.getImplementation(ConsoleUserInput.class);
    }

    public static ConsoleOutputService getOutputService() {
        return appConfig.getImplementation(ConsoleOutputService.class);
    }

    public static Parser getParser() {
        return appConfig.getImplementation(Parser.class);
    }

    public static GameInfo getGameInfo() {
        return appConfig.getImplementation(GameInfo.class);
    }

    private static void showStaringTitles() {
        getOutputService().print(new OutputDto(Titles.STARTING_TITLES.getTitles()));
    }

    private static String enterPlayerNickname() {
        String playerInput = getInputService().getUserInput();
        String parsedPlayerInput = getParser().parseNickname(playerInput);
        if (parsedPlayerInput.equals(Errors.MINIMUM_CHARACTERS_ERROR.getError()) || parsedPlayerInput.equals(Errors.MAXIMUM_CHARACTERS_ERROR.getError())) {
             getOutputService().print(new OutputDto(parsedPlayerInput));
             parsedPlayerInput = enterPlayerNickname();
        }
        getGameInfo().setPlayerNickname(parsedPlayerInput);
        return parsedPlayerInput;
    }

    private static void showTitlesForChoosingArchetype() {
        getOutputService().print(new OutputDto(getGameInfo().getPlayerNickname() + ", " + Titles.HEROES_INFO.getTitles()));
    }

    private static String chooseArchetype() {
        String playerChoice = getInputService().getUserInput();
        String parsedPlayerChoice = getParser().parsePlayerDecisionForArchetype(playerChoice);
        if (parsedPlayerChoice.equals(Errors.USER_INPUT_ERROR.getError())) {
            getOutputService().print(new OutputDto(parsedPlayerChoice));
            parsedPlayerChoice = chooseArchetype();
        }
        switch (parsedPlayerChoice) {
            case "1":
                getGameInfo().setHero(new Mage());
                return parsedPlayerChoice;
            case "2":
                getGameInfo().setHero(new Warrior());
                return parsedPlayerChoice;
            case "3":
                getGameInfo().setHero(new Priest());
                return parsedPlayerChoice;
        }
        return parsedPlayerChoice;
    }

    private static void showFirstQuestTitles() {
        getOutputService().print(new OutputDto(getGameInfo().getPlayerNickname() + ", отличный выбор!" +
                " Сегодня вся нечисть узнает кто самый крутой " + getGameInfo().getHero().getHeroClass().getHeroClass() +
                " на районе!\n" + Titles.FIRST_QUEST_TITLES.getTitles()));
    }

    private static void battle() {
        Battle battle = new Battle(getGameInfo().getHero().getHealth(), getGameInfo().getHero().getAttack());
        battle.battle();
    }
}
