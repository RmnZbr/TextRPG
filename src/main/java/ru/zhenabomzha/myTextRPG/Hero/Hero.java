package ru.zhenabomzha.myTextRPG.Hero;

import ru.zhenabomzha.myTextRPG.Ability.Ability;
import ru.zhenabomzha.myTextRPG.enums.heroClass.HeroClass;

public abstract class Hero {

    HeroClass heroClass;
    static int health;
    static int attack;
    Ability ability;

    public Hero(HeroClass heroClass, int health, int attack,Ability ability) {
        this.heroClass = heroClass;
        Hero.health = health;
        Hero.attack = attack;
        this.ability = ability;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public Ability getAbility() {
        return ability;
    }

    public abstract void useAbility();
}
