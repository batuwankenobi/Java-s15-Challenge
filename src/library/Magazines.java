package library;

// Book sınıfından türetilen Magazines (Dergiler) sınıfı
public class Magazines extends Book {
    private String publisher; // Derginin yayıncısını tutan değişken

    // Constructor: Yeni bir dergi oluştururken adı, yazarı ve yayıncısı verilir
    public Magazines(String name, String author, String publisher) {
        super(name, author); // Book sınıfının constructor'ı çağrılır
        this.publisher = publisher; // Yayıncı atanır
    }

    // Yayıncıyı döndüren getter metodu
    public String getPublisher() {
        return publisher;
    }

    // Yayıncıyı güncelleyen setter metodu
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Kitap bilgilerini ve yayıncıyı ekrana yazdıran display metodu
    @Override
    public void display() {
        super.display(); // Book sınıfındaki display metodu çağrılır (örneğin isim, yazar, ID gibi)
        System.out.println("Publisher: " + publisher); // Ek olarak yayıncı bilgisi yazdırılır
    }
}
