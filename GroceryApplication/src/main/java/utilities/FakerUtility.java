package utilities;

import java.util.Date;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class FakerUtility {
	Faker faker=new Faker();
	public String generateName()
	{
		return faker.name().fullName();
	}
	public String generateAddress()
	{
		return faker.address().fullAddress();
	}
	public PhoneNumber generatePhoneNumber()
	{
		return faker.phoneNumber();
	}
	public String generateEmailAddress() {
		return faker.internet().emailAddress();
	}

	public Date generateRandomBIrthday() {
		return faker.date().birthday();
	}

	public String generateCreditCardNumber() {
		return faker.finance().creditCard();
	}

	public String generateCompanyName() {
		return faker.company().name();
	}
	public long generateRandomNumber()
	{	
		return faker.number().randomNumber();
	}

}
