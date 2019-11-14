package id.yuana.tdd

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Nov, Thu 14 2019 09:23
 **/
class LoginPresenter(val view: LoginView) {

    companion object {
        const val EMAIL = "jarjit@mail.com"
        const val PASWORD = "123456"
    }

    fun doLogin() {

        view.getPassword()

        if (isValid()) {

            if (view.getEmail().equals(EMAIL) && view.getPassword().equals(PASWORD)) {

                view.showSuccess()

            } else {
                view.showError()
            }

        } else {
            view.showError()
        }

    }

    private fun isValid(): Boolean {
        return view.getEmail()?.isNotEmpty() ?: false && view.getPassword()?.isNotEmpty() ?: false
    }


}