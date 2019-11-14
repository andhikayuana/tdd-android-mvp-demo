package id.yuana.tdd

import id.yuana.tdd.UserRepository.Companion.AVATAR
import id.yuana.tdd.UserRepository.Companion.EMAIL
import id.yuana.tdd.UserRepository.Companion.NAME
import id.yuana.tdd.UserRepository.Companion.PASWORD
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

    @Mock
    lateinit var repository: UserRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = LoginPresenter(view, repository)
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

        val dummyEmail = EMAIL
        val dummyPassword = PASWORD

        `when`(view.getEmail()).thenReturn(dummyEmail)
        `when`(view.getPassword()).thenReturn(dummyPassword)

        val dummyUser = User(EMAIL, NAME, AVATAR)

        presenter.doLogin()

        verify(view).showSuccess(dummyUser)
    }
}