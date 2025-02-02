package ru.zhenabomzha.myTextRPG.enums.titles;

import ru.zhenabomzha.myTextRPG.engine.Engine;
import ru.zhenabomzha.myTextRPG.gameInfo.GameInfo;

public enum Titles {

    STARTING_TITLES("Доброго времени суток, Юнный Падаван!...\n" +
            "Сегодня ты отправишься в увлекательное путешествие по удивительным местам.\n" +
            "Тебя ждут невероятные битвы против различных монстров и всяких мерзких тварей. \n" +
            "Но прежде чем мы начнем, предлагаю познакомиться. Прошу подскажи как я могу к тебе обращаться."),
    HEROES_INFO("теперь тебе предстоит выбрать одного из трех представленных персонажей для игры.\n" +
            "Это Маг, Воин или Жрец.\n" +
            "Маг обладет способностью замораживать существо на 2 хода, чтобы оно не могло тебя атаковать.\n" +
            "Воин может проводить усиленную атаку раз в 3 хода.\n" +
            "А Жрец может похищать здоровье у существа и восполнять своё на количество украденного 1 раз за 2 хода.\n" +
            "Выбор за тобой. Пожалуйста выбери героя для начала нашего увлекательного путешествия.\n" +
            "1 - Маг\n2 - Воин\n3 - Жрец"),
    FIRST_QUEST_TITLES("Путешествие для спасения твоего народа начнется с пещеры пауков. Здесь обитает самый злобный " +
            "мегапаук. \nБудь осторожен! Очень много сильных воинов погибло в этой пещере. Будь ловок, и не забывай " +
            "использовать абилки для получения преимущества.\nГЛ ГЛ ГЛ!!!"),
     CHOOSE_ACTION_FOR_PLAYER("Вы желаете просто атаковать или использовать абилку?\n" +
             "1 - атаковать\n" +
             "2 - использовать абилку");


    private final String titles;

    Titles(String titles) {
        this.titles = titles;
    }

    public String getTitles() {
        return titles;
    }
}
