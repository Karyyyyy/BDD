package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import lombok.val;

import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
        // к сожалению, разработчики не дали нам удобного селектора, поэтому так
        private ElementsCollection cards = $$(".list__item div");
        private final String balanceStart = "баланс: ";
        private final String balanceFinish = " р.";
        private ElementsCollection heading = $$("[data-test-id='action-deposit']");



        public TransferMoneyPage changeCard(int id) {
            heading.get(id).click();
            return new TransferMoneyPage();
        }

        public int getCardBalance(String id) {
            var text = cards.get(Integer.parseInt(id)).text();
            return extractBalance(text);
        }

        private int extractBalance(String text) {
            var start = text.indexOf(balanceStart);
            var finish = text.indexOf(balanceFinish);
            var value = text.substring(start + balanceStart.length(), finish);
            return Integer.parseInt(value);
        }
}