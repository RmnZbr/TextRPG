package ru.zhenabomzha.myTextRPG.gameInfo;

import ru.zhenabomzha.myTextRPG.Hero.Hero;

public class GameInfo {

    private String playerNickname;
    private Hero hero;
    private int playerLevel;

    public GameInfo(String playerNickname, int playerLevel) {
        this.playerNickname = playerNickname;
        this.playerLevel = playerLevel;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setPlayerNickname(String playerNickname) {
        this.playerNickname = playerNickname;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public String getPlayerNickname() {
        return playerNickname;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }


}
