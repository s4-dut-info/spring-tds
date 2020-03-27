package spring.vuejs.samples.classes;

public class User {
	private String name;
	private boolean connected;
	public User() {
		connected = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

}
