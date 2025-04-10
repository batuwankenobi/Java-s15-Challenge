package people; // Sınıf 'people' paketinde yer alır

import library.Book; // Kitapları temsil eden Book sınıfı içe aktarılır

import java.util.ArrayList; // Dinamik dizi yapısı (liste) için import edilir
import java.util.List;      // List arabirimi kullanılır

// Author sınıfı, Person sınıfından kalıtım alır (bir Author aynı zamanda bir Person'dur)
public class Author extends Person {

    // Yazarın yazdığı kitapları tutmak için bir liste
    private List<Book> books;

    /**
     * Yapıcı metod (constructor)
     * Sadece isim alır ve kitap listesi boş olarak başlatılır.
     */
    public Author(String name) {
        super(name);              // Person sınıfının constructor'ı çağrılır
        this.books = new ArrayList<>(); // Kitap listesi oluşturulur
    }

    /**
     * newBook metodu:
     * Yazara yeni bir kitap eklemek için kullanılır.
     */
    public void newBook(Book book) {
        this.books.add(book); // Kitap listeye eklenir
    }

    /**
     * showBooks metodu:
     * Yazarın kitaplarını ekrana yazdırır.
     * Eğer kitap listesi boşsa, uygun mesaj gösterilir.
     */
    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println(getName() + " adlı yazarın kitabı bulunmamaktadır.");
        } else {
            System.out.println(getName() + " adlı yazarın kitapları:");
            for (Book book : books) {
                System.out.println("- " + book.getName()); // Her kitap ismi listelenir
            }
        }
    }

    /**
     * whoYouAre metodu:
     * Person sınıfında tanımlı soyut metodu override eder.
     * Yazarı tanıtmak için kullanılır.
     */
    @Override
    public void whoYouAre() {
        System.out.println("Ben bir yazarım ve adım: " + getName());
    }
}
