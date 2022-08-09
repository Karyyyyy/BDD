package ru.netology.test;

import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoneyTransferTest {
    @Test
    void Test1() {

        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        loginPage.validLogin(authInfo).validVerification(verificationCode);

        int amount = 1000;
        var cardInfo = DataHelper.getFirstCardInfo(amount);

        var dashboard = new DashboardPage();
        dashboard.changeCard(1).shouldMoneyInfo(cardInfo);
        int balanceFirstCard = dashboard.getCardBalance("0");
        int balanceSecondCard = dashboard.getCardBalance("1");

        assertEquals(balanceFirstCard, balanceFirstCard);
        assertEquals(balanceSecondCard, balanceSecondCard);
    }

    @Test
    void Test2() {

        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        loginPage.validLogin(authInfo).validVerification(verificationCode);

        int amount = 3000;
        var cardInfo = DataHelper.getSecondCardInfo(amount);

        var dashboard = new DashboardPage();
        dashboard.changeCard(0).shouldMoneyInfo(cardInfo);
        int balanceFirstCard = dashboard.getCardBalance("1");
        int balanceSecondCard = dashboard.getCardBalance("0");

        assertEquals(balanceFirstCard, balanceFirstCard);
        assertEquals(balanceSecondCard, balanceSecondCard);
    }
    @Test
    void Test3() {

        open("http://localhost:9999");
        var loginPage = new LoginPage();
        var authInfo = DataHelper.getAuthInfo();
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        loginPage.validLogin(authInfo).validVerification(verificationCode);

        int amount = 150000;
        var cardInfo = DataHelper.getSecondCardInfo(amount);

        var dashboard = new DashboardPage();
        dashboard.changeCard(0).shouldMoneyInfo(cardInfo);
        int balanceFirstCard = dashboard.getCardBalance("1");
        int balanceSecondCard = dashboard.getCardBalance("0");

        assertEquals(balanceFirstCard, balanceFirstCard);
        assertEquals(balanceSecondCard, balanceSecondCard);
    }
}
