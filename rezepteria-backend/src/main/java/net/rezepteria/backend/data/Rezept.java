package net.rezepteria.backend.data;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Erstellt 13.11.18

public class Rezept {

	private static Logger logger = LoggerFactory.getLogger(Rezept.class);

	@NotNull
	private int id = -1;

	@NotNull
	@Size(min = 2, message = "Rezeptname braucht mindestens zwei Zeichen")
	private String name = "";

	@NotNull
	private String zutatenText = "";

	@NotNull
	private String zubereitungText = "";

	@Min(value = 1, message = "Mindestmenge für eine Person")
	private int zahlPersonen = 4;

	@NotNull
	private String quelle = "";

	@NotNull
	private String url = "";

	@NotNull
	private String anmerkung = "";

	@Min(value = 0, message = "Keine negative Zeit")
	private int zubereitungZeit = 0;

	@Min(value = 0, message = "Keine negative Zeit")
	private int warteZeit = 0;

	@Min(value = 0, message = "Bewertung von 1 - 5")
	@Max(value = 5, message = "Bewertung von 1 - 5")
	private double bewertung = 0;

	@Min(value = 0, message = "Schwierigkeit von 1 - 5")
	@Max(value = 5, message = "Schwierigkeit von 1 - 5")
	private double difficulty = 0;

	// Klassifizierung
	private Set<Category> category;
	private Set<Tag> tag;

	// Nutzung

	private Set<Bewirtung> bewirtung;
	private Date lastCooked;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZutatenText() {
		return zutatenText;
	}

	public void setZutatenText(String zutatenText) {
		this.zutatenText = zutatenText;
	}

	public String getZubereitungText() {
		return zubereitungText;
	}

	public void setZubereitungText(String zubereitungText) {
		this.zubereitungText = zubereitungText;
	}

	public Set<Category> getCategory() {
		return category;
	}

	public void setCategory(Set<Category> category) {
		this.category = category;
	}

	public int getZahlPersonen() {
		return zahlPersonen;
	}

	public void setZahlPersonen(int zahlPersonen) {
		this.zahlPersonen = zahlPersonen;
	}

	public String getQuelle() {
		return quelle;
	}

	public void setQuelle(String quelle) {
		this.quelle = quelle;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAnmerkung() {
		return anmerkung;
	}

	public void setAnmerkung(String anmerkung) {
		this.anmerkung = anmerkung;
	}

	public int getZubereitungZeit() {
		return zubereitungZeit;
	}

	public void setZubereitungZeit(int zubereitungZeit) {
		this.zubereitungZeit = zubereitungZeit;
	}

	public int getWarteZeit() {
		return warteZeit;
	}

	public void setWarteZeit(int warteZeit) {
		this.warteZeit = warteZeit;
	}

	public double getBewertung() {
		return bewertung;
	}

	public void setBewertung(double bewertung) {
		this.bewertung = bewertung;
	}

	public double getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}

	public Set<Tag> getTag() {
		return tag;
	}

	public void setTag(Set<Tag> tag) {
		this.tag = tag;
	}

	public boolean isNewRezept() {
		return getId() == -1;
	}

}
