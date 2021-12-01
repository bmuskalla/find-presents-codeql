package p;

public class JavaBook implements ChristmasPresent {
    private String title;

    public JavaBook(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "JavaBook{" +
                "title='" + title + '\'' +
                '}';
    }
}
