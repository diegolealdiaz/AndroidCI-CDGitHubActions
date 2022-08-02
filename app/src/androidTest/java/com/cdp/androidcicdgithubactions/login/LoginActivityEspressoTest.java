package com.cdp.androidcicdgithubactions.login;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;
import android.content.Intent;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.cdp.androidcicdgithubactions.R;
import com.cdp.androidcicdgithubactions.login.LoginActivity;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityEspressoTest {
    @Rule
    public ActivityTestRule<LoginActivity> mLoginActivity = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void givenUserAndPassIsEmpty() {
        //mLoginActivity.launchActivity(new Intent());
        onView(ViewMatchers.withId(R.id.edt_username)).check(matches(isDisplayed())); //Verificar si el elemento esta disponible
        onView(withText("Inicio de Sesión")).check(matches(isDisplayed())); //Verificar si el elemento esta disponible
    }

    @Test
    public void validateTextControl(){
        onView(withId(R.id.textView)).check(matches(withText("Inicio de Sesión"))); //Valida que el View contenga el texto Inicio de Sesion
    }

    @Test
    public void validateElements(){
        //Espresso.pressBack();
        //onView(ViewMatchers.withId(R.id.spi_operation)).check(matches(withSpinnerText("Sumar"))); //Validar datos del spinner
        //hasSibling -> Valida que sean hermanos y este en el mismo nivel
        //hasDescendant -> Valida que contenga el elemento hijo
        //isDescendantOfA -> Valida que contenga el elemento padre
        //isClickable
        //withEffectiveVisibility(VISIBLE) -> Valida la visibilidad del elemento
        onView(withId(R.id.btn_login)).check(matches(isClickable())); //Valida que el boton se puedra dar click
        //onView(allOf(withHint(R.id.edt_username), isDescendantOfA(withId(R.id.login)))).check(matches(isDisplayed()));
    }

    @Test
    public void loginError() throws InterruptedException {
        onView(withId(R.id.edt_username)).perform(typeText("d@gmail.com")); //Escriba el texto
        onView(withId(R.id.edt_password)).perform(typeText("1234"),closeSoftKeyboard()); //Escriba el texto
        onView(withId(R.id.btn_login)).check(matches(isClickable())); //Valida que el boton se puedra dar click
        onView(withId(R.id.btn_login)).perform(click()); //Presione click
        Thread.sleep(3000);
        onView(withId(R.id.edt_password)).check(matches(hasErrorText("La contraseña debe ser superior a 5 digitos")));
        //onView(withText("La contraseña debe ser superior a 5 digitos")).check(matches(isDisplayed())); //Validar que el texto este disponible

    }
}