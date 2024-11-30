package ir.freeland.json.model;

public enum BookFormat {
    PAPERBACK("Paperback", "A book bound with flexible paper covers."),
    EBOOK("Ebook", "A digital version of a book, readable on electronic devices."),
    AUDIOBOOK("Audiobook", "A recorded version of a book, typically narrated.");

    private final String name;
    private final String description;

    BookFormat(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}