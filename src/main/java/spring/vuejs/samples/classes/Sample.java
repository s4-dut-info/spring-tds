package spring.vuejs.samples.classes;

import java.util.ArrayList;
import java.util.List;

public class Sample {
	private String header;
	private String description;
	private String url;

	public Sample(String header, String description, String url) {
		super();
		this.header = header;
		this.description = description;
		this.url = url;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public static List<Sample> all() {
		List<Sample> all = new ArrayList<>();
		all.add(new Sample("Test", "Hello world", "/test"));
		all.add(new Sample("Methods", "Création de méthodes", "/samples/method"));
		all.add(new Sample("Computed", "Création de computed properties", "/samples/computed"));
		return all;
	}
}
