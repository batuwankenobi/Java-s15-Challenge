package library; // Bu sınıf "library" adlı pakete aittir.

public class Journals extends Book {
    private String topic; // Derginin konusu (örneğin: Bilim, Teknoloji, Sağlık, vb.)

    /**
     * Constructor (yapıcı) metot:
     * Dergi nesnesi oluşturmak için ad, yazar ve konu bilgisi alınır.
     * Üst sınıf olan Book'un constructor'ı çağrılarak name ve author atanır.
     * Ayrıca Journal'a özgü topic alanı atanır.
     */
    public Journals(String name, String author, String topic) {
        super(name, author); // Book sınıfının (üst sınıf) constructor'ı çağrılır
        this.topic = topic;
    }

    // Getter metodu: Derginin konusunu döndürür
    public String getTopic() {
        return topic;
    }

    // Setter metodu: Derginin konusunu günceller
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * display() metodu override edilmiştir.
     * Kitap bilgilerini yazdıran üst sınıfın display() metoduna ek olarak,
     * Journal'a özgü konu bilgisini de yazdırır.
     */
    @Override
    public void display() {
        super.display(); // Book sınıfındaki display() çağrılır
        System.out.println("Topic: " + topic); // Journal'a özgü ek bilgi
    }
}
