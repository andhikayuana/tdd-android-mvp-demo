package id.yuana.tdd

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity(), LoginView {

    override fun showSuccess() {
        Toast.makeText(this, getString(R.string.msg_success_login), Toast.LENGTH_SHORT).show()
    }

    override fun showError() {
        Toast.makeText(this, getString(R.string.msg_error_login), Toast.LENGTH_SHORT).show()
    }

    override fun getPassword(): String = editText2.text.toString()

    override fun getEmail(): String = editText.text.toString()

    var loginPresenter: LoginPresenter? = null

    init {
        loginPresenter = LoginPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
    }


    private fun setupView() {
        button.setOnClickListener {
            loginPresenter?.doLogin()
        }
    }
}
