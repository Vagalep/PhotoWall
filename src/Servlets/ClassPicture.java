package Servlets;

public class ClassPicture {
	String uploader_id;
	String photo_name;
	String post_date;
	String post_time;

	ClassPicture(String uploader_id, String photo_name, String post_date, String post_time) {
		this.uploader_id = uploader_id;
		this.photo_name = photo_name;
		this.post_date = post_date;
		this.post_time = post_time;

	}

	@Override
	public String toString() {
		return "ClassPicture [uploader_id=" + uploader_id + ", photo_name=" + photo_name + ", post_date=" + post_date
				+ ", post_time=" + post_time + "]";
	}

	public String get_uploader() {
		return uploader_id;
	}

	public String get_photo_name() {
		return photo_name;
	}

	public String get_post_date() {
		return post_date;
	}

	public String get_post_time() {
		return post_time;
	}
}
