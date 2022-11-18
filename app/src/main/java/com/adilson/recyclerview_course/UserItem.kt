package layout

data class UserItem (
    val id: String,
    val name: String,
    val lastName: String
){
    val fullName : String get() = "$name $lastName"
}
