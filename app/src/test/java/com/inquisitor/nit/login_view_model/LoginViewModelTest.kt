package com.inquisitor.nit.login_view_model

import com.inquisitor.domain.usecase.LoginUseCase
import com.inquisitor.nit.MainCoroutineRule
import com.inquisitor.nit.TestCoroutineRule
import com.inquisitor.nit.navigation.NavigatorImpl
import com.inquisitor.nit.ui.login.LoginContract
import com.inquisitor.nit.ui.login.LoginViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val rule = MainCoroutineRule()

    @get:Rule
    val testRule = TestCoroutineRule()

    private val loginUseCase = mock<LoginUseCase>()

    private val loginStateFlow1 = MutableStateFlow(
        value = LoginContract(
            isLoading = false,
            result = null,
            errorMessage = null
        )
    )

    private val loginStateFlow2 = MutableStateFlow(
        value = LoginContract(
            isLoading = true,
            result = null,
            errorMessage = null
        )
    )

    private val loginStateFlow3 = MutableStateFlow(
        value = LoginContract(
            isLoading = false,
            result = "SUCCESS",
            errorMessage = null
        )
    )

    private val loginStateFlow4 = MutableStateFlow(
        value = LoginContract(
            isLoading = false,
            result = null,
            errorMessage = "ERROR"
        )
    )

    private lateinit var loginViewModel: LoginViewModel

    @Before
    fun setUp() {
        loginViewModel = LoginViewModel(
            navigator = NavigatorImpl(),
            loginUseCase = loginUseCase
        )
    }

    @Test
    fun `TestState(isLoading == false, result == null, errorMessage == null)`() {
//        runBlocking {
////            whenever(loginUseCase.login(onSuccess = {}, onError = {})).thenReturn(Unit)
//            Assert.assertEquals(
//                LoginState(isLoading = false, result = null, errorMessage = null),
//                loginViewModel.loginState.value
//            )
//        }

//        runBlocking {
//            loginViewModel.loginState.test {
//                Assert.assertEquals(loginStateFlow1.value, awaitItem())
//                cancelAndIgnoreRemainingEvents()
//            }
//        }

//        runBlocking {
//            flowOf(value = loginViewModel.loginState.value).test {
//                loginViewModel.login(username = "", password = "")
//                assertEquals(loginStateFlow2.value, awaitItem())
//                cancelAndIgnoreRemainingEvents()
//            }
//        }

//        testRule.runBlockingTest {
//            `when`(loginViewModel.login(username = "", password = ""))
//        }
//
//        testRule.pauseDispatcher()

        assertThat(loginViewModel.loginState.value, `is`(loginStateFlow1.value))

//        testRule.resumeDispatcher()
    }

    @Test
    fun `TestState(isLoading == true, result == null, errorMessage == null)`() {
        testRule.runBlockingTest {
            `when`(loginViewModel.login(username = "", password = ""))
        }
        testRule.resumeDispatcher()

        assertThat(loginViewModel.loginState.value, `is`(loginStateFlow2.value))

        testRule.resumeDispatcher()
    }

    @Test
    fun `Username and Password are incorrect`() {
        testRule.runBlockingTest {
            `when`(loginUseCase.login(username = "", password = ""))
        }
        testRule.pauseDispatcher()

        assertEquals(loginViewModel.loginState.value, loginStateFlow4.value)

        testRule.resumeDispatcher()
    }
}