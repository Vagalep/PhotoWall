package Servlets;

public class ClassUsers {
	String user_name;
	String photos_count;

	ClassUsers(String user_name, String photos_count) {
		this.user_name = user_name;
		this.photos_count = photos_count;
	}

	public String get_user_name() {
		return user_name;
	}

	public String get_photos_count() {
		return photos_count;
	}

	@Override
	public String toString() {
		return "ClassUsers [user_name=" + user_name + ", photos_count=" + photos_count + "]";
	}

}
