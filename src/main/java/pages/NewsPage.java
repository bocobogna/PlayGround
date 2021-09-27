package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NewsPage {

    private SelenideElement acceptCookiesButton = $("#onetrust-accept-btn-handler");
    private SelenideElement cnnBusinessHeader = $("h2[data-analytics='CNN Business_list-hierarchical-xs_']");
    private ElementsCollection businessHeaders = $$(By.xpath("//h2[@data-analytics='CNN Business_list-hierarchical-xs_']//ancestor::ul//h3"));

    public NewsPage open() {
        Selenide.open("");
        return this;
    }

    public void acceptCookies() {
        acceptCookiesButton
                .shouldBe(visible)
                .click();
    }

    public void scrollToHeaders() {
        cnnBusinessHeader
                .scrollTo()
                .shouldBe(visible);
        String file = Selenide.screenshot("BusinessHeaders_" + Utils.DataGenerator.generateNowDate("yyyy-MM-dd_HH_mm_ss"));
    }

    public List<String> getBusinessHeaders() {
        scrollToHeaders();
        return businessHeaders.texts();
    }

    public List<String> headersToWordsList(List<String> list) {
        scrollToHeaders();
        String words = list.toString().toLowerCase();
        words = words.replaceAll("[!,?.$&%]", "");
        return Arrays.asList(words.split(" "));
    }

    public List<String> headersToLetters(List<String> list) {
        scrollToHeaders();
        String letters = list.toString();
        letters = letters.replaceAll("\\W", "");
        letters = letters.replaceAll(" ", "");
        List<String> listToReturn = Arrays.asList(letters.split(""));
        listToReturn.removeAll(Arrays.asList(" ", "", null));
        return listToReturn;
    }

    public List<String> firstHeaderToLetterList() {
        scrollToHeaders();
        String text = businessHeaders.first().text().toLowerCase();
        text = text.replace(" ", "");
        return Arrays.asList(text.split(""));
    }

    public Set<String> findDuplicates(List<String> list) {
        return list
                .stream()
                .filter(x -> Collections.frequency(list, x) > 1)
                .collect(Collectors.toSet());
    }

    public String getFirstDuplicate(List<String> list) {
        HashSet<String> set = new HashSet<>();
        int min = -1;
        for (int i = list.size() - 1; i >= 0; i--)
            if (set.contains(list.get(i)))
                min = i;
            else
                set.add(list.get(i));
        return min == -1 ? "No duplicates" : list.get(min);
    }

    public Map<String, List<Integer>> getDuplicatesWithIndexes(List<String> list) {
        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.groupingBy(list::get))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<String, Long> getDuplicatesCount(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(el -> el.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public String getMostPopularElement(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).get();
    }
}
