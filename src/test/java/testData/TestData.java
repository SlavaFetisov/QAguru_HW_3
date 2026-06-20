package testData;

import com.github.javafaker.Faker;
import static utils.RandomUtils.*;


public class TestData {

    Faker faker = new Faker();

    public String userEmail = faker.internet().emailAddress();
    public String currentAddress = faker.address().fullAddress();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userName = "%s %s".formatted(firstName,lastName);

    public String inCorrectEmail = faker.name().lastName();
    public String userNumber = getRandomPhone();
    public String genderWrapper =getRandomGender();
    public String yearOfBirth = String.valueOf(faker.number().numberBetween(1900,2026));
    public String monthOfBirth = getRandomMonth();
    public String dayOfBirth = String.valueOf(faker.number().numberBetween(1,28));
    public String subject = getRandomSubject();
    public String hobbiesReading = getRandomHobbies();
    public String nameOfFile = getRandomImage();

    public String state = getRandomState();
    public String city = getRandomCity(state);
    public String dateOfBirth = dayOfBirth+" "+monthOfBirth+","+yearOfBirth;


}