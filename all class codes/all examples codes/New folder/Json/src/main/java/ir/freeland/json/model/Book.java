package ir.freeland.json.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class Book {
	
	
    @JsonProperty("atitle") // Maps JSON property "title" to this field
    private String title;
    
    @JsonProperty("published") // Maps JSON property "published" to this field
    private int publishedYear;

    @JsonIgnore // This field will be ignored during serialization/deserialization
    private String internalNote;

    private String author;    
    private List<String> genres;
    private BookFormat bookFormat;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public BookFormat getBookFormat() {
		return bookFormat;
	}

	public void setBookFormat(BookFormat bookFormat) {
		this.bookFormat = bookFormat;
	}

	
	public String getInternalNote() {
		return internalNote;
	}

	public void setInternalNote(String internalNote) {
		this.internalNote = internalNote;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", publishedYear=" + publishedYear
				+ ", internalNote=" + internalNote + ", author=" + author
				+ ", genres=" + genres + ", bookFormat=" + bookFormat + "]";
	}
}