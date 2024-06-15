package ru.zhenabomzha.myTextRPG.Hero;

import ru.zhenabomzha.myTextRPG.Ability.Ability;
import ru.zhenabomzha.myTextRPG.Ability.Freeze;
import ru.zhenabomzha.myTextRPG.enums.heroClass.HeroClass;

public class Mage extends Hero {

    private static final Ability Freeze = new Freeze();

    public Mage() {
        super(HeroClass.MAGE, 100, 15, Freeze);
    }

    @Override
    public void useAbility() {

    }
}
