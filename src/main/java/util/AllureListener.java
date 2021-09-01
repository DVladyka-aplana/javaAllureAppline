package util;
import io.qameta.allure.junit4.AllureJunit4;
import steps.BaseSteps;
import org.junit.runner.notification.Failure;


/**
 * Created by 777 on 08.05.2017.
 */
public class AllureListener extends AllureJunit4 {

    @Override
    public void testFailure(Failure failure){
        BaseSteps.takeScreenshot();
        super.testFailure(failure);
    }
}