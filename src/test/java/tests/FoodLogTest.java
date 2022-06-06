package tests;


import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;


@Log4j2
public class FoodLogTest extends BaseTest {

    @Test(description = "Trying to create custom food and then delete it")
    public void creatingCustomFoodAndDelete() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.createCustomFoodItem("Cukar", "200", "grams", "100");
        foodPage.validateResultAfterAddingCustom("100");
        foodPage.deleteFromFoodLog();
        foodPage.validateResultAfterDeleteCustom("—");

    }

    @Test(description = "Trying to add to the food log and then delete")
    public void addedAndDeletedFromTheFoodLog() {
        loginPage.openPage();                                            //Открываем окно логина
        loginPage.login(user, password);                                 //Вводим данные для входа
        dashBoardPage.addFoodButton();                                   // Переходим на страницу журнала еды
        foodPage.addFoodBySearch("cheese", "3", "kg"); // Поиск и введение данных о порции еды
        foodPage.addToFoodLog();                                         // Добовляем в журнал еды
        foodPage.validateResultAfterAdding("10167");           // Проверяем наличие еды в журнале по количеству каллорий
        foodPage.deleteFromFoodLog();                                    // Удаляем изжурнала еды
        foodPage.validateResultAfterDelete("—");               // Проверяем отсутвие в журнале еды

    }

    @Test(description = "Trying to add to the food log by browse and then delete")
    public void addFoodByBrowse() {
        loginPage.openPage();
        loginPage.login(user, password);
        dashBoardPage.addFoodButton();
        foodPage.addFoodByBrowse();
        foodPage.chooseTypeOfFood("Fish");
        foodPage.chooseTypeOf("FinFish");
        foodPage.chooseKindOf("Barracuda");
        foodPage.choosePortion("400", "grams");
        foodPage.addToFoodLog();
        foodPage.validateResultAfterAddingByBrowse("844");
        foodPage.deleteFromFoodLog();
        foodPage.validateResultAfterDeleteByBrowse("—");

    }

}
