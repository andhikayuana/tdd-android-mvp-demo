package id.yuana.tdd

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Nov, Thu 14 2019 09:25
 **/
interface LoginView {
    fun getEmail(): String?
    fun getPassword(): String?
    fun showError()
    fun showSuccess()
}