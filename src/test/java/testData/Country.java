package testData;

public enum Country{
    Turkey("Турция"),
    Egypt("Египет"),
    Thailand("Таиланд");

    private final String country;

    Country(String country){
        this.country = country;
    }

    public String getCountries(){
        return country;
    }
}
