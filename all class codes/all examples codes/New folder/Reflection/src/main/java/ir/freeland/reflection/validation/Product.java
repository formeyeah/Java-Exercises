package ir.freeland.reflection.validation;

public class Product {
    private String name;    
    private String category;
    private String madeIn;

    public Product(String name, String madeIn, String category) {
        this.name = name;
        this.madeIn = madeIn;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getMadeIn() {
        return madeIn;
    }

    public String getCategory() {
        return category;
    }
}