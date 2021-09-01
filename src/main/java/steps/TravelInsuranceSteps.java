package steps;

import io.qameta.allure.Step;
import pages.MainPage;
import pages.TravelInsurancePage;

public class TravelInsuranceSteps extends BaseSteps{
    @Step("Нажать на кнопку: Оформить")
    public void stepClickButtonCreate(){
        new TravelInsurancePage().selectButtonCreate();
    }
}
