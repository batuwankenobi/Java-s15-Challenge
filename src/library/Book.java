package library; // Bu sınıf "library" adlı paketin içindedir.

import java.util.Date; // Java'nın yerleşik Date sınıfı, satın alma tarihi bilgisini tutmak için kullanılır.

public class Book {
    // --- ÖZELLİKLER (FIELD'LER) ---
    private int id;                     // Kitabın benzersiz kimlik numarası
    private String author;             // Kitabın yazarı
    private String name;               // Kitabın adı
    private double price;              // Kitabın fiyatı
    private String status;             // Kitabın durumu (örn. "Kütüphanede Mevcut" veya "Ödünç Alındı")
    private String edition;            // Kitabın baskı bilgisi
    private Date dateOfPurchase;       // Kitabın satın alınma tarihi

    // --- YAPIYICILAR (CONSTRUCTORS) ---

    // Sadece ad ve yazar bilgisi ile kitap oluşturmak için kullanılan basit yapıcı
    public Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    // Tüm özellikleriyle kitap oluşturmak için kullanılan yapıcı
    public Book(int id, String author, String name, double price, String status, String edition, Date dateOfPurchase) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.price = price;
        this.status = "Kütüphanede Mevcut"; // Bu satırda, status parametresi geçilmiş olsa da, doğrudan "Kütüphanede Mevcut" atanıyor.
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
    }

    // --- GETTER ve SETTER METOTLARI ---
    // Her biri bir özelliğe erişmek (get) veya onu değiştirmek (set) için kullanılır.

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEdition() {
        return this.edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Date getDateOfPurchase() {
        return this.dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    // --- EKSTRA METOTLAR ---

    // getTitle metodu, kitabın adını (başlık) döndürür.
    public String getTitle() {
        return this.getName();
    }

    // getOwner metodu, kitabın ödünç alınıp alınmadığına göre sahibini döndürür.
    public String getOwner() {
        // Eğer kitap ödünç alınmışsa "Ödünç Alınmış", aksi halde "Kütüphane" döner.
        return this.getStatus().equals("Ödünç Alındı") ? "Ödünç Alınmış" : "Kütüphane";
    }

    // Kitabın durumunu güncellemek için kullanılır.
    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    // Kitabın tüm bilgilerini konsola yazdırmak için kullanılır.
    public void display() {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
        System.out.println("Status: " + this.status);
        System.out.println("Edition: " + this.edition);
        System.out.println("Date of Purchase: " + this.dateOfPurchase);
    }
}
