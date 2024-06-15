package ru.zhenabomzha.myTextRPG.Hero;

import ru.zhenabomzha.myTextRPG.Ability.CriticalDamage;
import ru.zhenabomzha.myTextRPG.enums.heroClass.HeroClass;

public class Warrior extends Hero {

    private static final CriticalDamage CRITICAL_DAMAGE = new CriticalDamage();
    
    public Warrior() {
        super(HeroClass.WARRIOR,80, 10, CRITICAL_DAMAGE);
    }


    @Override
    public void useAbility() {

    }
}
