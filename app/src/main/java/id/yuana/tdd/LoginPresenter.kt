package id.yuana.tdd

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Nov, Thu 14 2019 09:23
 **/
class LoginPresenter(val view: LoginView, val repository: UserRepository) {

    fun doLogin() {

        if (isValid()) {

            val request = mapOf(
                "email" to view.getEmail(),
                "password" to view.getPassword()
            )

            view.showLoading()

            repository.login(request, {
                view.showSuccess(it)
                view.dismissLoading()
            }, {
                view.showError()
                view.dismissLoading()
            })


        } else {
            view.showError()
        }

    }

    private fun isValid(): Boolean {
        return view.getEmail()?.isNotEmpty() ?: false && view.getPassword()?.isNotEmpty() ?: false
    }


}