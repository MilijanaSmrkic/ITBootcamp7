package banka;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Zadatak_2_0319 {

	/*
	 * Potrebno je napraviti test za ispravnost klase Bank. Za sve testove potrebno
	 * je napraviti jedinstvenu banku koja se na poèetku testa resetuje. Smatrati da
	 * ova banka ne može da ima nalog kod kojeg je stanje negativno. Ako se na
	 * osnovu testova naðe neka greška u kodu potrebno je da se popravi originalni
	 * kod.
	 */
	Bank mobi;

	@BeforeTest
	public void banka() {
		mobi = new Bank();
		mobi.reset();
	}
	// Potrebno je ispitati da li adekvatno radi otvaranje naloga, tako što æe se
	// ubaciti 5 naloga i zatim ispitati da li se ti nalozi mogu dohvatiti.

	@Test
	public void otvaranjeNaloga() {

		Account a1 = mobi.openAccount("marko");
		Account a2 = mobi.openAccount("pera");
		Account a3 = mobi.openAccount("ana");
		Account a4 = mobi.openAccount("jovana");
		Account a5 = mobi.openAccount("marija");

		SoftAssert sa = new SoftAssert();

		sa.assertEquals(mobi.getAccount(a1.getNumber()).getName(), "marko");

		sa.assertEquals(mobi.getAccount(a2.getNumber()).getName(), "pera");
		sa.assertEquals(mobi.getAccount(a3.getNumber()).getName(), "ana");
		sa.assertEquals(mobi.getAccount(a4.getNumber()).getName(), "jovana");
		sa.assertEquals(mobi.getAccount(a5.getNumber()).getName(), "marija");
		sa.assertAll();

	}
	// Proveriti da li dobro radi metoda za uplatu novca.

	@Test
	public void metodaZaUplatu() {
		Account a1 = mobi.openAccount("marko");
		mobi.payInMoney(a1.getNumber(), 200.0);
		Assert.assertEquals(a1.getAmount(), 200d);

	}
	// Proveriti da li dobro radi metoda za transfer novca.

	@Test
	public void testTransfer() {
		Account a1 = mobi.openAccount("Ivana");
		Account a2 = mobi.openAccount("milica");

		a1.setAmount(10000.0);
		mobi.transferMoney(a1.getNumber(), a2.getNumber(), 1000.0);

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(a1.getAmount(), 9000d);
		sa.assertEquals(a2.getAmount(), 1000d);
		sa.assertAll();

	}
	// Proveriti da li dobro radi metoda za raèunanje ukupnog novca u banci
	// (getSumMoney).

	@Test

	public void testUkNovac() {
		Account a1 = mobi.openAccount("Ivana");
		Account a2 = mobi.openAccount("milica");
		a1.setAmount(10000.0);
		a2.setAmount(50000d);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(mobi.getSumMoney(), 60000d);

	}

}
