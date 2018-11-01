package thk.fae.urd.ort.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Kontaktdaten {

	@NotBlank
	private String vorname;

	@NotBlank
	private String nachname;

	@NotBlank
	@Email
	private String email;

	public String getVorname() {
		return this.vorname;
	}

	public void setVorname(final String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return this.nachname;
	}

	public void setNachname(final String nachname) {
		this.nachname = nachname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	@Override
	public boolean equals(final Object obj) {
		if ((null == obj) || (obj.getClass() != Kontaktdaten.class)) {
			return false;
		}
		final Kontaktdaten other = (Kontaktdaten) obj;
		return this.getVorname().equals(other.getVorname()) && this.getNachname().equals(other.getNachname())
				&& this.getEmail().equals(other.getEmail());
	}

}
