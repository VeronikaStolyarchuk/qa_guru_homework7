package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.TourSearchPage;
import testData.Country;

import java.util.List;
import java.util.stream.Stream;

public class TourPackageWebTest extends BaseTest {

    TourSearchPage tourSearchPage = new TourSearchPage();

    @ValueSource(strings = {
            "Турция", "Египет", "Таиланд"
    })
    @ParameterizedTest(name = "Для поискового запроса {0} должен отдавать не пустой список карточек")
    void searchResultsNotBeEmpty(String country){
        tourSearchPage
                .openPage()
                .setCountryName(country)
                .submitButton()
                .checkSearchResult();
    }

    @CsvSource(value = {
            "Екатеринбург, Екатеринбурга",
            "Омск, Омска"
    })
    @ParameterizedTest(name = "При выборе города {0} должен обновиться город вылета {1}")
    void selectCityWrapperShouldBeResultDepartureCity(String city, String resultCity){
        tourSearchPage
                .openPage()
                .setCityWrapper()
                .checkModal()
                .setDepartureCity(city)
                .checkResultSelectCity(resultCity);

    }

    static Stream<Arguments> selectCountryShouldBeDisplayCorrectResorts(){
        return Stream.of(
                Arguments.of(
                        Country.Turkey,
                        List.of("Аланья", "Белек", "Кемер", "Сиде", "Анталья", "Бодрум",
                                "Кушадасы", "Мармарис", "Стамбул", "Фетхие")
                ),
                Arguments.of(
                        Country.Egypt,
                        List.of("Хургада", "Шарм-эль-шейх", "Дахаб", "Макади", "Сафага",
                                "Сома Бей", "Таба", "Эль Гуна")
                ),
                Arguments.of(
                        Country.Thailand,
                        List.of("Паттайя", "Пхукет", "Бангкок", "Као Лак", "Самуи")
                )

        );
    }

    @MethodSource
    @ParameterizedTest(name = "При выборе страны {0} должен обновиться список популярных курортов {1}")
    void selectCountryShouldBeDisplayCorrectResorts(Country country, List<String> expectedResorts){
        tourSearchPage.openPage()
                .setCountryName(country.getCountries())
                .checkResultResorts(expectedResorts);

    }
}
