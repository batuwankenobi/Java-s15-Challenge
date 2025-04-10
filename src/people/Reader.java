package people;

import library.Book;
import library.MemberRecord;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person{
    private MemberRecord memberRecord; // Okuyucuya ait üye kaydını tutar
    private List<Book> barrowedBooks; // Ödünç alınan kitapların listesi
    private List<Book> purchasedBooks; // Satın alınan kitapların listesi
    private int maxBookLimit = 5; // Maksimum kitap ödünç alma limiti

    // Constructor - Okuyucu nesnesi oluşturulurken parametreler alır ve ilgili değişkenleri atar
    public Reader(String name, MemberRecord memberRecord, List<Book> barrowedBooks, List<Book> purchasedBooks, int maxBookLimit) {
        super(name); // Person sınıfının yapıcı metodunu çağırarak okuyucunun adını atar
        this.memberRecord = memberRecord; // Okuyucunun üye kaydını atar
        this.barrowedBooks = new ArrayList<>(); // Başlangıçta ödünç alınan kitaplar listesi boş olur
        this.purchasedBooks = new ArrayList<>(); // Başlangıçta satın alınan kitaplar listesi boş olur
        this.maxBookLimit = maxBookLimit; // Maksimum kitap limiti atanır
    }

    // Getter metodları
    public MemberRecord getMemberRecord() {
        return memberRecord; // Okuyucunun üye kaydını döndürür
    }

    public int getMaxBookLimit() {
        return maxBookLimit; // Maksimum kitap limitini döndürür
    }

    public List<Book> getBarrowedBooks() {
        return barrowedBooks; // Ödünç alınan kitapları döndürür
    }

    public List<Book> getPurchasedBooks() {
        return purchasedBooks; // Satın alınan kitapları döndürür
    }

    // Kitap ödünç alma işlemi
    public boolean barrowBook(Book book){
        if(barrowedBooks.size() < maxBookLimit){ // Eğer ödünç alınan kitap sayısı limitten azsa
            barrowedBooks.add(book); // Kitap ödünç alınanlar listesine eklenir
            System.out.println(book.getName() + " adlı kitabı ödünç aldınız.");
            return true;
        } else {
            System.out.println("Kitap limitine ulaştınız!"); // Limit aşılmışsa hata mesajı verir
            return false;
        }
    }

    // Ödünç alınan kitapları gösterir
    public void showBarrowedBook(){
        if(barrowedBooks.isEmpty()){ // Eğer ödünç alınan kitaplar boşsa
            System.out.println(getName() + " adlı okuyucu henüz kitap ödünç almamıştır.");
        } else {
            System.out.println(getName() + " adlı kullanıcının ödünç aldığı kitaplar:");
            for(Book book : barrowedBooks){ // Ödünç alınan kitapların isimlerini yazdırır
                System.out.println("- " + book.getName());
            }
        }
    }

    // Kitap satın alma işlemi
    public void purchaseBook(Book book) {
        if (purchasedBooks.size() < maxBookLimit) { // Eğer satın alınan kitap sayısı limitten azsa
            purchasedBooks.add(book); // Kitap satın alınanlar listesine eklenir
            System.out.println(getName() + " adlı kullanıcı " + book.getName() + " adlı kitabı satın aldı.");
        } else {
            System.out.println("Satın alınacak kitap limiti aşıldı."); // Limit aşılmışsa hata mesajı verir
        }
    }

    // Satın alınan kitapları gösterir
    public void showPurchasedBook(){
        if(purchasedBooks.isEmpty()){ // Eğer satın alınan kitaplar boşsa
            System.out.println(getName() + " adlı okuyucu henüz kitap satın almamıştır.");
        } else {
            System.out.println(getName() + " adlı okuyucunun satın aldığı kitaplar:");
            for(Book book : purchasedBooks){ // Satın alınan kitapların isimlerini yazdırır
                System.out.println("- " + book.getName());
            }
        }
    }

    // Kitap iade etme işlemi
    public void returnBook(Book book){
        barrowedBooks.remove(book); // Kitap ödünç alınanlar listesinden silinir
    }

    // Kullanıcının almış olduğu kitapları gösterir (hem ödünç hem de satın alınan)
    public void showBook(){
        System.out.println(getName() + " adlı okuyucunun almış olduğu kitaplar:");
        System.out.println("Ödünç aldığı kitaplar:");
        showBarrowedBook(); // Ödünç alınan kitapları gösterir
        System.out.println("Satın aldığı kitaplar:");
        showPurchasedBook(); // Satın alınan kitapları gösterir
        if(barrowedBooks.isEmpty() || purchasedBooks.isEmpty()){ // Eğer ödünç veya satın alınan kitaplar boşsa
            System.out.println(getName() + " adlı okuyucu henüz kitap almamıştır.");
        }
    }

    // `whoYouAre` metodu, Person sınıfından gelen soyut metodu implement eder
    @Override
    public void whoYouAre() {
        System.out.println("Ben bir okuyucuyum ve adım: " + getName()); // Okuyucuyu tanıtan bir mesaj yazdırır
    }
}
