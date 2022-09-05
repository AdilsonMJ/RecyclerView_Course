package layout

data class User (
    val id: Long,
    val name: String,
    val lastName: String
){
    val fullName : String get() = "$name $lastName #$id"
}
