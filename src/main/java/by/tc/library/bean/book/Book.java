package by.tc.library.bean.book;

import java.util.Objects;

public class Book {
  private int id;
  private String id_pulb_office;
  private  String genres_id;
  private int prod_year;
  private float rating;
  private String b_name;
  private String b_isbn;
  private String author_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_pulb_office() {
        return id_pulb_office;
    }

    public void setId_pulb_office(String id_pulb_office) {
        this.id_pulb_office = id_pulb_office;
    }

    public String getGenres_id() {
        return genres_id;
    }

    public void setGenres_id(String genres_id) {
        this.genres_id = genres_id;
    }

    public int getProd_year() {
        return prod_year;
    }

    public void setProd_year(int prod_year) {
        this.prod_year = prod_year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_isbn() {
        return b_isbn;
    }

    public void setB_isbn(String b_isbn) {
        this.b_isbn = b_isbn;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && prod_year == book.prod_year && Float.compare(book.rating, rating) == 0 && id_pulb_office.equals(book.id_pulb_office) && genres_id.equals(book.genres_id) && b_name.equals(book.b_name) && b_isbn.equals(book.b_isbn) && author_id.equals(book.author_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_pulb_office, genres_id, prod_year, rating, b_name, b_isbn, author_id);
    }

    //select b_id,b_name,b_prod_year,b_rating,b_isbn,(select g_name from genres where books.genres_g_id = genres.g_id),(select a_name from authors where books.authors_a_id=authors.a_id)" +
    //            ",(select publishing_office_name from publishing_offices where books.b_id_publ = publishing_offices.id_publishing_office) from books"


    public Book(int id, String b_name,int prod_year, float rating, String b_isbn, String genres_id, String author_id,String id_pulb_office) {
        this.id = id;
        this.id_pulb_office = id_pulb_office;
        this.genres_id = genres_id;
        this.prod_year = prod_year;
        this.rating = rating;
        this.b_name = b_name;
        this.b_isbn = b_isbn;
        this.author_id = author_id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", id_pulb_office='" + id_pulb_office + '\'' +
                ", genres_id='" + genres_id + '\'' +
                ", prod_year=" + prod_year +
                ", rating=" + rating +
                ", b_name='" + b_name + '\'' +
                ", b_isbn='" + b_isbn + '\'' +
                ", author_id='" + author_id + '\'' +
                '}';
    }
}
