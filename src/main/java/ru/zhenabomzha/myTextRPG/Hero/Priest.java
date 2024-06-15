package ru.zhenabomzha.myTextRPG.Hero;

import ru.zhenabomzha.myTextRPG.Ability.Ability;
import ru.zhenabomzha.myTextRPG.Ability.LifeSteal;
import ru.zhenabomzha.myTextRPG.enums.heroClass.HeroClass;

public class Priest extends Hero {

    private static final LifeSteal lifeSteal = new LifeSteal();

    public Priest() {
        super(HeroClass.PRIEST, 75, 10,  lifeSteal);
    }


    @Override
    public void useAbility() {

    }
}
