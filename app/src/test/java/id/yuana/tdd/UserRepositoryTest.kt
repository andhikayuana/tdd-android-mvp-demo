package id.yuana.tdd

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Nov, Thu 14 2019 16:54
 */
@RunWith(MockitoJUnitRunner::class)
class UserRepositoryTest {

    private lateinit var repository: UserRepository

    @Mock
    lateinit var user: User

    @Mock
    lateinit var exception: Exception

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = UserRepository()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun failedLogin() {

//        val dummyRequest = mapOf(
//            "email" to null,
//            "password" to null
//        )


//        val success = argumentCaptor<(User) -> Unit>()
//        val error = argumentCaptor<(Exception) -> Unit>()
//
//        repository.login(
//            dummyRequest,
//            success.capture(),
//            error.capture()
//        )
    }
}