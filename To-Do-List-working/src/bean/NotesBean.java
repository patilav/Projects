package bean;

import java.sql.Blob;
import java.util.List;

public class NotesBean {
	
	
	private int notes_id;
	private String name;
	private Blob imagePath;
	private String text;
	private List<NotesBean> noteslist;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNotes_id() {
		return notes_id;
	}
	public void setNotes_id(int notes_id) {
		this.notes_id = notes_id;
	}
	public Blob getImagePath() {
		return imagePath;
	}
	public void setImagePath(Blob blob) {
		this.imagePath = blob;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<NotesBean> getNoteslist() {
		return noteslist;
	}
	public void setNoteslist(List<NotesBean> noteslist) {
		this.noteslist = noteslist;
	}

}
