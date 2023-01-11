
data class Note(val title: String, val text: String): MenuItem {
    override fun getItemTitle(): String {
        return this.title
    }
    override fun createText(): String {
        return "Создать заметку"
    }
}