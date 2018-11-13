package net.rezepteria.backend.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import net.rezepteria.backend.data.Availability;
import net.rezepteria.backend.data.Category;
import net.rezepteria.backend.data.Product;
import net.rezepteria.backend.data.Rezept;

public class MockDataGenerator {
	private static int nextCategoryId = 1;
	private static int nextProductId = 1;
	private static final Random random = new Random(1);
//	private static final String categoryNames[] = new String[] { "Children's books", "Best sellers", "Romance",
//			"Mystery", "Thriller", "Sci-fi", "Non-fiction", "Cookbooks" };

	private static final String categoryNames[] = new String[] { "Vorspeise", "Hauptgericht", "Nachspeise",
			"Grundrezept" };

	private static final String tagNames[] = new String[] { "Vorspeise", "Hauptgericht", "Nachspeise", "Grundrezept" };

	private static String[] word1 = new String[] { "The art of", "Mastering", "The secrets of", "Avoiding",
			"For fun and profit: ", "How to fail at", "10 important facts about", "The ultimate guide to", "Book of",
			"Surviving", "Encyclopedia of", "Very much", "Learning the basics of", "The cheap way to",
			"Being awesome at", "The life changer:", "The Vaadin way:", "Becoming one with", "Beginners guide to",
			"The complete visual guide to", "The mother of all references:" };

	private static String[] word2 = new String[] { "gardening", "living a healthy life", "designing tree houses",
			"home security", "intergalaxy travel", "meditation", "ice hockey", "children's education",
			"computer programming", "Vaadin TreeTable", "winter bathing", "playing the cello", "dummies",
			"rubber bands", "feeling down", "debugging", "running barefoot", "speaking to a big audience",
			"creating software", "giant needles", "elephants", "keeping your wife happy" };

	private static String[] wordrezept1 = new String[] { "Gebackene", "Gebratene", "Blaue", "Gesottene", "Pochierte",
			"Gekochte", "Grüne", "Gedämpfte", "Rohe", "Glasierte", "Frittierte", "Scharfe", "Süße", "Saure" };

	private static String[] wordrezept2 = new String[] { "Rüben", "Schnitzel", "Hühnerschenkel", "Blaubeeren", "Knödel",
			"Eier", "Wirsingblätter", "Schweinelendchen", "Rindersülze", "Blumenkohlröschen", "Quiche", "Bohnen",
			"Karotten", "Lauchstangen", "Forellen", "Tauben" };

	private static String[] wordZutaten = new String[] { "Eier", "Salz", "Zucker", "Mehl", "Zucchini", "Rotbarsch",
			"Thymian", "Sellerie", "Karotten", "Zwiebeln", "Schweineschulter", "Rinderbäckchen", "Porree",
			"Stangensellerie", "Chilli", "Honig", "Sojasauce" };

	private static String[] wordEinheiten = new String[] { "EL", "TL", "g", "ml", "Stück", "Bund" };

	private static String[] wordSchritte = new String[] { "Das Fleisch waschen und mit Salz und Pfeffer würzen.",
			"Das Suppengrün putzen und grob zerkleinern. Zwiebel hacken.",
			"Fleisch in einer Bratreine von allen Seiten anbraten, Suppengrün und Zwiebeln zugeben und mit braten.",
			"Mit der Hälfte der Brühe aufgießen, Lorbeer und Paprikapulver zugeben und bei 180 - 200° ca. 2 Std. im Backofen braten. Dabei nach und nach die restliche Brühe zugeben.",
			"Das Fleisch in Scheiben schneiden und mit Alufolie bedeckt warm halten. Den Bratensatz loskochen, passieren und mit angerührter Stärke binden und abschmecken." };

	private static String[] wordURL = new String[] {
			"https://www.chefkoch.de/rezepte/1291691234510903/Rote-Bete-Risotto.html",
			"https://www.chefkoch.de/rezepte/1519441257199667/Kalbsnierenbraten.html",
			"https://www.chefkoch.de/rezepte/1342761239096947/Filettopf.html" };

	private static int nextRezeptId;

	static List<Category> createCategories() {
		List<Category> categories = new ArrayList<Category>();
		for (String name : categoryNames) {
			Category c = createCategory(name);
			categories.add(c);
		}
		return categories;
	}

	static List<Product> createProducts(List<Category> categories) {
		List<Product> products = new ArrayList<Product>();
		for (int i = 0; i < 100; i++) {
			Product p = createProduct(categories);
			products.add(p);
		}
		return products;
	}

	static List<Rezept> createRezepte(List<Category> categories) {
		List<Rezept> rezepte = new ArrayList<Rezept>();
		for (int i = 0; i < 100; i++) {
			Rezept r = createRezept(categories);
			rezepte.add(r);
		}

		return rezepte;
	}

	private static Rezept createRezept(List<Category> categories) {
		Rezept r = new Rezept();
		r.setId(nextRezeptId++);

		r.setName(generateRezeptName());

		r.setZutatenText(generateRezeptZutaten(1, 10));
		r.setZubereitungText(generateRezeptZubereitung(1, 4));

		r.setZahlPersonen(random.nextInt(9) + 1);

		r.setQuelle("Maxen's Kochbuch");

		r.setUrl(selectRandom(wordURL));

		r.setBewertung(random.nextDouble() * 5.0);
		r.setDifficulty(random.nextDouble() * 5.0);

		r.setAnmerkung("Anmerkung");

		r.setCategory(getCategory(categories, 1, 3));
		return r;
	}

	private static Category createCategory(String name) {
		Category c = new Category();
		c.setId(nextCategoryId++);
		c.setName(name);
		return c;
	}

	private static Product createProduct(List<Category> categories) {
		Product p = new Product();
		p.setId(nextProductId++);
		p.setProductName(generateName());

		p.setPrice(new BigDecimal((random.nextInt(250) + 50) / 10.0));
		p.setAvailability(Availability.values()[random.nextInt(Availability.values().length)]);
		if (p.getAvailability() == Availability.AVAILABLE) {
			p.setStockCount(random.nextInt(523));
		}

		p.setCategory(getCategory(categories, 1, 2));
		return p;
	}

	private static Set<Category> getCategory(List<Category> categories, int min, int max) {
		int nr = random.nextInt(max) + min;
		HashSet<Category> productCategories = new HashSet<Category>();
		for (int i = 0; i < nr; i++) {
			productCategories.add(categories.get(random.nextInt(categories.size())));
		}

		return productCategories;
	}

	private static String generateName() {
		return word1[random.nextInt(word1.length)] + " " + word2[random.nextInt(word2.length)];
	}

	private static String generateRezeptName() {
		return wordrezept1[random.nextInt(wordrezept1.length)] + " " + wordrezept2[random.nextInt(wordrezept2.length)];
	}

	private static String selectRandom(String[] s) {
		return s[random.nextInt(s.length)];
	}

	private static String generateRezeptZutaten(int min, int max) {
		String zt = "";

		int nr = random.nextInt(max) + min;

		for (int i = 0; i < nr; i++) {

			String line = (random.nextInt(19) + 1) + " " + wordEinheiten[random.nextInt(wordEinheiten.length)] + " "
					+ wordZutaten[random.nextInt(wordZutaten.length)];

			zt += line + "\n";

		}
		return zt;
	}

	private static String generateRezeptZubereitung(int min, int max) {

		String zt = "";

		int nr = random.nextInt(max) + min;

		for (int i = 0; i < nr; i++) {

			String line = selectRandom(wordSchritte);

			zt += line + "\n";

		}
		return zt;
	}

}
