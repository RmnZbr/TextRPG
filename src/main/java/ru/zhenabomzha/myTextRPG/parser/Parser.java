package ru.zhenabomzha.myTextRPG.parser;

import ru.zhenabomzha.myTextRPG.engine.Engine;
import ru.zhenabomzha.myTextRPG.enums.errors.Errors;

public class Parser {

    public static final int MINIMUM_CHARACTERS = 1;
    public static final int MAXIMUM_CHARACTERS = 15;

    public String parseNickname(String userInput) {

//        String[] splittedUserInput = userInput.split("\\s+");
        try {
            if (userInput.length() < MINIMUM_CHARACTERS) {
                throw new RuntimeException(Errors.MINIMUM_CHARACTERS_ERROR.getError());
            }
            if (userInput.length() > MAXIMUM_CHARACTERS) {
                throw new RuntimeException(Errors.MAXIMUM_CHARACTERS_ERROR.getError());
            }
        } catch (RuntimeException ex) {
           return ex.getMessage();
        }
        return userInput;
    }

    public String parsePlayerDecisionForArchetype(String playerDecision) {
        try {
            if (!playerDecision.equals("1") && !playerDecision.equals("2") && !playerDecision.equals("3")) {
                throw new RuntimeException(Errors.USER_INPUT_ERROR.getError());
            }
        } catch (RuntimeException ex) {
            return ex.getMessage();
        }
        return playerDecision;
    }

    public String parsePlayerDecisionForBattle(String playerDecision) {
        try {
            if (!playerDecision.equals("1") && !playerDecision.equals("2")) {
                throw new RuntimeException(Errors.USER_INPUT_ERROR.getError());
            }
        } catch (RuntimeException ex) {
            return ex.getMessage();
        }
        return playerDecision;
    }
}
