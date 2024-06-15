package ru.zhenabomzha.myTextRPG.enums.errors;

public enum Errors {

    GET_CLASS_ERROR("Запрошенного класса нет в мапе!"),
    MINIMUM_CHARACTERS_ERROR("Вы ввели недостаточное количество символов, попробуйте снова."),
    MAXIMUM_CHARACTERS_ERROR("Вы ввели слишком большое количество символов. Ограничение составлет - 15 символов, поробуйте снова."),
    USER_INPUT_ERROR("Вы ввели неккоректную команду, попробуйте снова");

    private final String error;

    Errors(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
