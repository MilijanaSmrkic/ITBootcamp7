package banka;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Zadatak_1_0319 {

	/*
	 * Proveriti da li konstruktor public Account(String name, String number) dobro
	 * postavlja argumente, kao i da li get metode vraæaju odgovarajuæe vrednosti.
	 * Kada se napravi raèun, stanje treba da bude jednako 0.
	 * 
	 */
	public Account racun;

	@BeforeClass
	public void beforeMethod() {

		racun = new Account("ivana", "34354");

	}

	@Test
	public void testKonstruktor() {
		String ime = "ivana";
		String broj = "34354";

		Account racun = new Account(ime, broj);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(racun.getName(), ime);
		sa.assertEquals(racun.getNumber(), broj);
		sa.assertEquals(racun.getAmount(), 0d);

		sa.assertAll();

	}

	// Proveriti da li set metode dobro postavljaju odgovarajuæe vrednosti, kao i da
	// li get metode vraæaju odgovarajuæe vrednosti.

	@Test
	public void setMetode() {
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(racun.getAmount(), racun.setAmount(200.0));

	}
	// Proveriti da li je ispravan format ispisa jednog Account-a. Oèekivani format
	// ispisa: broj<tab>ime<tab>stanje. Stanje treba da bude zaokruženo na dve
	// decimale.

	@Test
	public void ispis() {
		String ispis = racun.getNumber() + " " + racun.getName() + " " + racun.getAmount();
		Assert.assertEquals(racun.toString(), ispis);

	}
	// Napraviti 100 000 naloga pomoæu konstruktora public Account(String name) i
	// proveriti da li se svi brojevi razlikuju.

	@Test
	public void testNumber() {
		Account[] racuni = new Account[100];
		for (int i = 0; i < racuni.length; i++) {
			racuni[i] = new Account("pera");

		}

		SoftAssert sa = new SoftAssert();
		for (int i = 0; i < racuni.length; i++) {
			String broj = racuni[i].getNumber();

			for (int j = i + 1; j < racuni.length; j++) {
				sa.assertNotEquals(broj, racuni[j].getNumber());

			}
		}
		sa.assertAll();
	}

}
