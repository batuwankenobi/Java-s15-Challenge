package library; // Sınıf, 'library' isimli paket içinde yer alır

// StudyBooks sınıfı, Book sınıfından kalıtım (inheritance) alır.
// Yani bir StudyBook aynı zamanda bir Book'tur ama ekstra olarak "lesson" (ders) bilgisi içerir.
public class StudyBooks extends Book {

    // Bu sınıfa özgü olan özellik: kitabın ait olduğu ders
    private String lesson;

    /**
     * Constructor (yapıcı metod)
     * StudyBook nesnesi oluşturulurken isim, yazar ve ders bilgisi alır.
     * name ve author bilgisi üst sınıf Book'a gönderilir.
     */
    public StudyBooks(String name, String author, String lesson) {
        // Üst sınıf olan Book'un constructor'ı çağrılır
        super(name, author);
        // Ders bilgisi bu sınıfa ait olduğu için burada atanır
        this.lesson = lesson;
    }

    // lesson değişkeni için getter metodu (ders bilgisini döndürür)
    public String getLesson() {
        return lesson;
    }

    // lesson değişkeni için setter metodu (ders bilgisini değiştirir)
    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    /**
     * display() metodu override edilmiştir (üst sınıftaki display() üzerine yazılmıştır).
     * Hem üst sınıftaki kitap bilgileri, hem de bu sınıfa özel olan ders bilgisi gösterilir.
     */
    @Override
    public void display() {
        super.display(); // Üst sınıftaki display metodu çağrılır (örneğin isim ve yazar gösterilir)
        System.out.println("Lesson: " + lesson); // Ardından ders bilgisi yazdırılır
    }
}
