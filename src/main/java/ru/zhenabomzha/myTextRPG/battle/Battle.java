package ru.zhenabomzha.myTextRPG.battle;

import ru.zhenabomzha.myTextRPG.Ability.Freeze;
import ru.zhenabomzha.myTextRPG.Ability.CriticalDamage;
import ru.zhenabomzha.myTextRPG.Ability.LifeSteal;
import ru.zhenabomzha.myTextRPG.engine.Engine;
import ru.zhenabomzha.myTextRPG.enums.errors.Errors;
import ru.zhenabomzha.myTextRPG.enums.titles.Titles;
import ru.zhenabomzha.myTextRPG.output.outputDto.OutputDto;

import java.util.HashMap;

public class Battle {

    private final HashMap<String, Class> mapForAbility = new HashMap<>();
    private int playerHealthInBattle;
    private int playerAttackInBattle;
    private int monsterHealth;
    private int monsterAttack;

    public Battle(int playerHealthInBattle, int playerAttackInBattle) {
        this.playerHealthInBattle = playerHealthInBattle;
        this.playerAttackInBattle = playerAttackInBattle;
        this.monsterHealth = (int) (playerHealthInBattle * 1.25);
        this.monsterAttack = (int) (playerAttackInBattle * 1.25);
        mapForAbility.put("Freeze", Freeze.class);
        mapForAbility.put("CriticalDamage", CriticalDamage.class);
        mapForAbility.put("LifeSteal", LifeSteal.class);
    }

    public void battle() {

        showStartingTittlesForBattle();
        showBattleInfo();
        getChooseForPlayer();
        String userChoice = validationUserChoice(Engine.getInputService().getUserInput());
        action(userChoice);

    }

    private void showStartingTittlesForBattle() {
        Engine.getOutputService().print(new OutputDto(String.format("%s, начнем битву!",
                Engine.getGameInfo().getPlayerNickname())));
    }

    private void showBattleInfo() {
        Engine.getOutputService().print(new OutputDto(String.format("Здоровье твоего героя - %d\n" +
                        "Атака твоего героя - %d\n" +
                        "Здоровье монстра - %d\n" +
                        "Атака монстра - %d",
                playerHealthInBattle, playerAttackInBattle, monsterHealth,
                monsterAttack)));
    }

    private void getChooseForPlayer() {
        Engine.getOutputService().print(new OutputDto(Titles.CHOOSE_ACTION_FOR_PLAYER.getTitles()));
    }

    private String validationUserChoice(String userChoice) {
        String userDecision = Engine.getParser().parsePlayerDecisionForBattle(userChoice);
        if (userDecision.equals(Errors.USER_INPUT_ERROR.getError())) {
            Engine.getOutputService().print(new OutputDto(userDecision));
            userDecision = validationUserChoice(Engine.getInputService().getUserInput());
        }
        return userDecision;
    }

    private void action(String userChoice) {
        if(userChoice.equals("1")) {
            monsterHealth = monsterHealth - playerAttackInBattle;
        } else {
            Engine.getGameInfo().getHero().useAbility();
        }
    }

    private void useAbility(Class aClass) {

    }

    private void useAbility(CriticalDamage criticalDamage) {

    }

    private void useAbility(LifeSteal lifeSteal) {

    }
}
