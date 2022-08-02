package com.cdp.androidcicdgithubactions.menu;

import static org.junit.Assert.*;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;

public class MainActivityViewModelTest {
    private MainActivityViewModel mainActivityViewModel;
    private MainActivity mainActivity;

    @Before
    public void setUp(){
        mainActivityViewModel = new MainActivityViewModel();
    }

    @Test
    public void mainActivityViewModelNotNull() throws Exception{
        assertNotNull(mainActivityViewModel);
    }

    @Test
    public void validateData() throws Exception {
        mainActivityViewModel = new MainActivityViewModel();
        assertEquals(false,mainActivityViewModel.validateData("","2","Sumar"));
    }

    @Test
    public void suma() throws Exception {
        assertEquals(10,mainActivityViewModel.operationData(5,5,"Sumar"));
    }

    @Test
    public void resta() throws Exception {
        assertEquals(-1,mainActivityViewModel.operationData(6,5,"Restar"));
    }

    @Test
    public void multiplicar() throws Exception {
        assertEquals(9,mainActivityViewModel.operationData(3,3,"Multiplicar"));
    }

    @Test
    public void dividir() throws Exception {
        assertEquals(2,mainActivityViewModel.operationData(8,4,"Dividir"));
    }
}