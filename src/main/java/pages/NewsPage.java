package pages;

import Utils.datagenerator.DataGenerator;
import Utils.helpers.NotWebMethods;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static Utils.helpers.NotWebMethods.textToLetters;
import static Utils.helpers.NotWebMethods.textToWordsList;
import static Utils.helpers.WebElementExtensions.getElement;
import static Utils.helpers.WebElementHelper.clickOnElement;
import static Utils.helpers.WebElementHelper.scrollToElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewsPage {

    private final SelenideElement acceptCookiesButton = $("#onetrust-accept-btn-handler");
    private final SelenideElement cnnBusinessContainer = $(By.xpath("//h2[@data-analytics='CNN Business_list-hierarchical-xs_']//ancestor::ul"));
    private final ElementsCollection businessHeaders = $$(By.xpath("//h2[@data-analytics='CNN Business_list-hierarchical-xs_']//ancestor::ul//h3"));

    public NewsPage open() {
        Selenide.open("");
        return this;
    }

    public void acceptCookies() {
        getElement(acceptCookiesButton);
        clickOnElement(acceptCookiesButton);
    }

    public void scrollToHeaders() {
        scrollToElement(cnnBusinessContainer);
        String file = Selenide.screenshot("BusinessHeaders_" + DataGenerator.generateNowDate("yyyy-MM-dd_HH_mm_ss"));
    }

    public List<String> getBusinessHeaders() {
        for (SelenideElement el : businessHeaders) {
            getElement(el);
        }
        return businessHeaders.texts();
    }

    public List<String> headersToWordsList(List<String> list) {
        return textToWordsList(list);
    }

    public List<String> headersToLetters(List<String> list) {
        return textToLetters(list);
    }

    public List<String> firstHeaderToLetterList() {
        return textToLetters(Collections.singletonList(businessHeaders.first().text().toLowerCase()));
    }

    public Set<String> findDuplicates(List<String> list) {
        return NotWebMethods.findDuplicates(list);
    }

    public String getFirstDuplicate(List<String> list) {
        return NotWebMethods.getFirstDuplicate(list);
    }

    public Map<String, List<Integer>> getDuplicatesWithIndexes(List<String> list) {
        return NotWebMethods.getDuplicatesWithIndexes(list);
    }

    public Map<String, Long> getDuplicatesCount(List<String> list) {
        return NotWebMethods.getDuplicatesCount(list);
    }

    public String getMostPopularElement(List<String> list) {
        return NotWebMethods.getMostPopularElement(list);
    }
}
