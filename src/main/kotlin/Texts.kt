enum class Texts(val text: String) {

    MENU_SELECT("Введите номер пункта меню:"),
    MENU_WRONG_INPUT("Ошибка ввода, необходимо ввести число"),
    MENU_WRONG_NUMBER("Неверно выбран пункт меню, выберете из предложеных"),

    ARCHIVE_LIST("Список архивов:"),
    ARCHIVE_LIST_EMPTY("<архивов нет>"),
    ARCHIVE_CREATE("Создать архив"),
    ARCHIVE_CREATED("Архив создан"),
    ARCHIVE_ENTER_TITLE("Введите название архива:"),
    ARCHIVE_EXIT("Выход из архива"),

    NOTE("Заметка"),
    NOTE_LIST("Список заметок архива "),
    NOTE_LIST_EMPTY("<заметок нет>"),
    NOTE_CREATE("Создать заметку"),
    NOTE_CREATED("Заметка создана"),
    NOTE_ENTER_TITLE("Введите название заметки:"),
    NOTE_ENTER_TEXT("Введите текст заметки:"),
    NOTE_ENTER_ANY_TEXT_FOR_EXIT("Нажмите Enter для выхода в список заметок:"),




    BYE("Работа завершена"),

    EXIT("Выход из программы"),

    BR("------------------------------------------------------")

}