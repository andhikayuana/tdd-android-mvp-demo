package id.yuana.tdd

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Nov, Thu 14 2019 15:11
 **/
open class UserRepository {

    companion object {
        const val EMAIL = "jarjit@mail.com"
        const val NAME = "Jarjit Singh"
        const val AVATAR = "https://i.pravatar.cc/150?u=jarjit@mail.com"
        const val PASWORD = "123456"
    }

    fun login(params: Map<String, String?>, success: (User) -> Unit, error: (Exception) -> Unit) {
        val email = params["email"]
        val password = params["password"]

        if (email == EMAIL && password == PASWORD) {
            success(User(EMAIL, NAME, AVATAR))
        } else {
            error(Exception("User not found or Input not valid"))
        }

    }

}