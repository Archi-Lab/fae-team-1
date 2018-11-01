package thk.fae.urd.ort.domain;

public class KontaktdatenTestHelper {

	public static Kontaktdaten createDummyKontaktdaten() {
		final Kontaktdaten kontaktdaten = new Kontaktdaten();
		kontaktdaten.setVorname("Max");
		kontaktdaten.setNachname("Mustermann");
		kontaktdaten.setEmail("Max.Mustermann@gmail.com");
		return kontaktdaten;
	}

}
