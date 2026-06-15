package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import testData.Country;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TourSearchPage {

    private final SelenideElement inputCountryName = $(".msf__item-input");
    private final SelenideElement buttonSearch = $(".msf__button-icon-wrap");
    private final ElementsCollection searchResults = $$(".search-filter-results__items .rd-result-filter-item");
    private final SelenideElement cityWrapper = $(".select-city-inner");
    private final SelenideElement modalAllCity = $(".tours__all-country");
    private final ElementsCollection setCity = $$("ul li");
    private final SelenideElement resultSelectCity = $("span.primary-form-select__selected-text");
    private final ElementsCollection resultResorts = $$("ul#ui-id-1 li:nth-child(3) " +
            "ul.catcomplete-category__inner li span.ui-menu-item_comment__title");


    public TourSearchPage openPage(){
        open("/");

        return this;
    }

    public TourSearchPage setCountryName(String country) {
        inputCountryName.setValue(country).pressEnter();

        return this;
    }

    public TourSearchPage submitButton(){
        buttonSearch.click();

        return this;
    }

    public void checkSearchResult(){
        searchResults.shouldBe(CollectionCondition.sizeGreaterThan(0));

    }

    public TourSearchPage setCityWrapper(){
        cityWrapper.click();

        return this;
    }

    public TourSearchPage checkModal(){
        modalAllCity.shouldBe(Condition.visible);

        return this;

    }

    public TourSearchPage setDepartureCity(String city){
        setCity.findBy(text(city)).click();

        return this;
    }

    public void checkResultSelectCity(String resultCity){
        resultSelectCity.shouldHave(text(resultCity));

    }

    public void checkResultResorts(List<String> expectedResorts){

        resultResorts.shouldHave(texts(expectedResorts));
    }
}

