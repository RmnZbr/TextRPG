package ru.zhenabomzha.myTextRPG.enums.heroClass;

public enum HeroClass {

    MAGE("Маг"),
    WARRIOR("Воин"),
    PRIEST("Жрец");

    private final String heroClass;

    HeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public String getHeroClass() {
        return heroClass;
    }
}
