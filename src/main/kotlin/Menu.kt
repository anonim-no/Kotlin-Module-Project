
// принимает заголовок для вывода, текст пункта создания и список элементов
class Menu<T: MenuItem>(private val title: String, private val createText: String, private val listItems: List<T>) {

    // показывает меню (архивов или заметок) и возвращаем выбранный пользователем пункт меню
    fun showMenu(): Int {

        // выводим меню
        println("---")
        println(title)



        if (listItems.size>0) {
            listItems.forEachIndexed { index, t -> println("${index + 1}. ${t.getItemTitle()}") }
        } else {
            println("<список пустой>")
        }
        println("${listItems.size+1}. Выход")

        // просим пользователя ввести номер меню
        while (true) {
            val selectedNumber = UserInput().selectMenu()
            if (selectedNumber>=0 && selectedNumber<=listItems.size+1) {
                return selectedNumber
            } else {
                println("Неверно выбран пункт меню, выберете из предложеных");
            }
        }
    }


}

