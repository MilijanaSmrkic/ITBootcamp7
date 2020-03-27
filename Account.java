package banka;

import java.util.Random;
import java.util.UUID;

public class Account {

	private String number;
	private String name;
	private Double amount;

	public Account(String name, String number) {
		this.number = number;
		this.name = name;
		this.amount = 0d; 
	}
	

	public Account(String name) {
		this(name, UUID.randomUUID().toString());
	}

	public String getNumber() {
		return number;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public double setAmount(Double amount) {
		  return this.amount = amount;
	}


	@Override
	public String toString() {
		return String.format("%s %s %.2f", number, name, amount);
	}
}
