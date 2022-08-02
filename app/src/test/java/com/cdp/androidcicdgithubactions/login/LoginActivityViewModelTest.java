package com.cdp.androidcicdgithubactions.login;

import com.cdp.androidcicdgithubactions.menu.MainActivity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;

import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class LoginActivityViewModelTest{

    @Mock //Hacer mock de la clase que queremos
    private LoginActivityViewModel loginActivityViewModel;
    private LoginActivityNavigator loginActivityNavigator;

    @Before //Hacer antes de que ejecuten los test
    public void setup() throws Exception{
        loginActivityViewModel = new LoginActivityViewModel();
        loginActivityViewModel.setNavigator(loginActivityNavigator);
    }

    //Test que valida que retorne un true
    @Test
    public void shouldSuccessWithValidDataUserandPass() throws Exception{
        boolean validate = loginActivityViewModel.validateDataInput("d@gmail.com","123456");
        Assert.assertEquals(true,validate);
    }

    //Test que valida que retorne falso si se envía vacios los datos y ejecutar el método del snackbar
    @Test
    public void givenValidationUserandPassEmpty() throws Exception{
        boolean validate = loginActivityViewModel.validateDataInput("d@gmail.com","");
        //verify(this).onLoginError("","");
        Assert.assertEquals(false,validate);
    }

}