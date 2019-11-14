package id.yuana.tdd

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner


/**
 * @author Yuana andhikayuana@gmail.com
 * @since Nov, Thu 14 2019 09:24
 */
@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {

    private lateinit var presenter: LoginPresenter

    @Mock
    lateinit var view: LoginView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = LoginPresenter(view)
    }

    @After
    fun tearDown() {
    }


    @Test
    fun failedLoginWithBlankEmailPassword() {

        `when`(view.getEmail()).thenReturn(null)
        `when`(view.getPassword()).thenReturn(null)

        presenter.doLogin()

        verify(view).showError()

    }

    @Test
    fun failedLoginWithNotValidEmailPassword() {

        val dummyEmail = "ismail@mail.com"
        val dummyPassword = "098098"

        `when`(view.getEmail()).thenReturn(dummyEmail)
        `when`(view.getEmail()).thenReturn(dummyPassword)

        presenter.doLogin()

        verify(view).showError()
    }

    @Test
    fun successLoginWithValidEmailPassword() {

        val dummyEmail = LoginPresenter.EMAIL
        val dummyPassword = LoginPresenter.PASWORD

        `when`(view.getEmail()).thenReturn(dummyEmail)
        `when`(view.getPassword()).thenReturn(dummyPassword)

        presenter.doLogin()

        verify(view).showSuccess()
    }
}