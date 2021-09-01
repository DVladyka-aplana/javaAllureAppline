import org.junit.Test;
import org.openqa.selenium.By;
import steps.*;

public class Ex3Test extends BaseSteps {
    @Test
    public void testInsurance() throws InterruptedException {
        MainSteps mainSteps=new MainSteps();
        mainSteps.checkCookieButton();
        mainSteps.stepSelectMainMenu("Страхование");
        mainSteps.stepSelectSubMenu("Все страховые программы");

        InsuranceSteps insuranceSteps=new InsuranceSteps();
        insuranceSteps.selectInCarousel("Страхование путешественников");

        TravelInsuranceSteps travelInsuranceSteps=new TravelInsuranceSteps();
        travelInsuranceSteps.checkHead((By.xpath("//*[contains(text(),'Страхование путешественников')][contains(@class,'kitt-heading')]")),10,"Страхование путешественников");
        travelInsuranceSteps.checkCookieButton();
        travelInsuranceSteps.stepClickButtonCreate();

        SetValuesTravelInsuranceSteps setValuesTravelInsuranceSteps=new SetValuesTravelInsuranceSteps();

        setValuesTravelInsuranceSteps.checkHead((By.xpath("//h2[contains(text(),'Страхование путешественников')]")),10,"Страхование путешественников");
        setValuesTravelInsuranceSteps.setRegionValue("Шенген и страны Совета Европы, кроме РФ");
        setValuesTravelInsuranceSteps.setSum("Минимальная");
        setValuesTravelInsuranceSteps.clickButtonNext("Оформить");

        setValuesTravelInsuranceSteps.setValueTo("ФамилияTo", "Ivanov");
        setValuesTravelInsuranceSteps.setValueTo("ИмяTo", "Ivan");
        setValuesTravelInsuranceSteps.setValueTo("ДрTo", "11.11.1991");

        setValuesTravelInsuranceSteps.setValueTo("ФамилияFrom", "Петров");
        setValuesTravelInsuranceSteps.setValueTo("ИмяFrom", "Петр");
        setValuesTravelInsuranceSteps.setValueTo("ОтчествоFrom", "Петрович");
        setValuesTravelInsuranceSteps.setValueTo("ДрFrom", "12.12.1990");
        setValuesTravelInsuranceSteps.chekFemale("Мужской");

        setValuesTravelInsuranceSteps.setValueTo("Паспорт серия", "1111");
        setValuesTravelInsuranceSteps.setValueTo("Паспорт номер", "1111111");
        setValuesTravelInsuranceSteps.setValueTo("Паспорт дата", "12.12.2011");
        setValuesTravelInsuranceSteps.setValueTo("Паспорт выдан", "МФЦ");

        setValuesTravelInsuranceSteps.checkValue("Ivanov","ФамилияTo");
        setValuesTravelInsuranceSteps.checkValue("Ivan","ИмяTo");
        setValuesTravelInsuranceSteps.checkValue("11.11.1991","ДрTo");
        setValuesTravelInsuranceSteps.checkValue("Петров","ФамилияFrom");
        setValuesTravelInsuranceSteps.checkValue("Петр","ИмяFrom");
        setValuesTravelInsuranceSteps.checkValue("Петрович","ОтчествоFrom");
        setValuesTravelInsuranceSteps.checkValue("12.12.1990","ДрFrom");
        setValuesTravelInsuranceSteps.checkValue("1111","Паспорт серия");
        setValuesTravelInsuranceSteps.checkValue("111111","Паспорт номер");
        setValuesTravelInsuranceSteps.checkValue("12.12.2011","Паспорт дата");
        setValuesTravelInsuranceSteps.checkValue("МФЦ","Паспорт выдан");

        setValuesTravelInsuranceSteps.clickButtonNext("Продолжить");

        setValuesTravelInsuranceSteps.checkErrorPage("При заполнении данных произошла ошибка");
        setValuesTravelInsuranceSteps.checkCellError("Поле не заполнено.","Мобильный телефон");
        setValuesTravelInsuranceSteps.checkCellError("Поле не заполнено.","Электронная почта");
        setValuesTravelInsuranceSteps.checkCellError("Поле не заполнено.","Повтор электронной почты");
    }
}
