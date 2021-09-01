package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps extends BaseSteps{
    @Step("На главной панели нажать кнопку: {0}")
    public void stepSelectMainMenu(String menuItem){
        new MainPage().selectMenuItem(menuItem);
    }
    @Step("В дочернем окне нажать на: {0}")
    public void stepSelectSubMenu(String menuItem){
        new MainPage().menuSubItem(menuItem);
    }

}
