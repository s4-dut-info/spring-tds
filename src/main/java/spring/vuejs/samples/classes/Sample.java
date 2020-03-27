package spring.vuejs.samples.classes;

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
}
