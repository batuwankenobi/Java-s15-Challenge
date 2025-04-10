package people;

import library.Book;
import library.Library;
import util.Bill;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Librarian extends Person{
    private List<Bill> bills = new ArrayList<>();  // Kütüphaneciye ait faturaların listesi
    private String password;  // Kütüphanecinin şifresi

    // Kütüphaneci sınıfının yapıcı metodu, ad ve şifre parametreleri alır
    public Librarian(String name, String password) {
        super(name);  // Person sınıfındaki adı alarak başlatır
        this.password = password;  // Kütüphanecinin şifresini atar
    }

    // Kütüphanecinin şifresini alır
    public String getPassword(){
        return password;
    }

    // Kütüphanecisinin şifresini değiştirir
    public void setPassword(String password){
        this.password = password;
    }

    // Kitap arama fonksiyonu, kütüphanedeki kitaplar arasında istenilen kitabı arar
    public void searchBook(Library library, String bookName){
        System.out.println("Kütüphanede " + bookName + " adlı kitabı arıyorum.");
        boolean arama = false;  // Kitap bulundu mu kontrolü
        for(Book book : library.getBooks()){  // Tüm kitaplar arasında arama yapar
            if(book.getName().equalsIgnoreCase(bookName)){  // Kitap ismi eşleşiyorsa
                System.out.println(bookName + " adlı kitap bulundu.");
                arama = true;  // Kitap bulundu
                break;
            }
        }
        if(!arama){  // Kitap bulunamadıysa
            System.out.println(bookName + " adlı kitap kütüphanede bulunamadı.");
        }
    }

    // Üye doğrulama fonksiyonu, verilen üye ID'sine göre kütüphanedeki üyeleri kontrol eder
    public boolean verifyMember(Library library, int memberId){
        System.out.println("Üye ID: " + memberId + " doğrulanıyor.");
        for(Reader reader : library.getReaders()){  // Kütüphanedeki her okuyucuyu kontrol eder
            if(reader.getName().equalsIgnoreCase(String.valueOf(memberId))){  // Eğer üye ismi eşleşirse
                System.out.println("Okuyucu bulundu: " + reader.getName());
                return true;
            }
        }
        System.out.println("Okuyucu bulunamadı.");
        return false;  // Okuyucu bulunamazsa false döner
    }

    // Kitap ödünç verme fonksiyonu, verilen okuyucuya ve kitaba göre ödünç verme işlemi yapar
    public boolean issueBook(Library library, Reader reader, Book book){
        System.out.println(reader.getName() + " adlı kullanıcıya " + book.getName() + " adlı kitabı ödünç veriyorum.");
        return library.lendBook(reader, book);  // Kütüphanedeki lendBook fonksiyonunu çağırır
    }

    // Kitap gecikme cezası hesaplama fonksiyonu
    public double calculateFine(Book book){
        double gunlukGecikmeFiyat = 1.5;  // Günlük gecikme ücreti
        LocalDate today = LocalDate.now();  // Bugünün tarihi
        LocalDate borrowDate = book.getDateOfPurchase().toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();  // Kitabın alınış tarihi
        long overdueDays = ChronoUnit.DAYS.between(borrowDate, today) - 14;  // 14 günlük süreyi çıkartarak gecikme hesaplanır
        if (overdueDays > 0) {
            double totalFine = overdueDays * gunlukGecikmeFiyat;  // Gecikme cezası hesaplanır
            System.out.println("Toplam gecikme cezası: " + totalFine + " TL (" + overdueDays + " gün gecikme)");
            return totalFine;
        } else {
            System.out.println("Gecikme bulunmamaktadır.");
            return 0.0;  // Gecikme yoksa 0 TL ceza
        }
    }

    // Fatura oluşturma fonksiyonu, okurun borcunu hesaplar ve faturayı oluşturur
    public void createBill(Reader reader, double amount){
        Bill bill = new Bill(reader, amount);  // Yeni fatura oluşturulur
        bills.add(bill);  // Fatura listesine eklenir
        System.out.println(reader.getName() + " adlı kullanıcı için fatura oluşturuldu: " + amount + " TL");
        bill.displayBill();  // Fatura ekrana yazdırılır
    }

    // Kitap geri alma fonksiyonu, verilen okuyucudan kitap geri alınır
    public void returnBook(Library library, Reader reader, Book book){
        System.out.println(reader.getName() + " adlı kullanıcıdan " + book.getName() + " adlı kitabı geri alıyorum.");
        library.takeBackBook(reader, book);  // Kütüphanedeki takeBackBook fonksiyonu çağrılır
    }

    // Kitap bilgilerini güncelleme fonksiyonu, kitaba ait yeni bilgileri kütüphanedeki kitaplara işler
    public void updateBook(Library library, int bookId, String newName, String newAuthor, double newPrice, String newEdition) {
        Book bookToUpdate = null;
        for (Book book : library.getBooks()) {  // Kütüphanedeki kitapları arar
            if (book.getId() == bookId) {  // Kitap ID'sine göre bulur
                bookToUpdate = book;
                break;
            }
        }

        if (bookToUpdate != null) {  // Kitap bulunmuşsa
            bookToUpdate.setName(newName);  // Kitap adı güncellenir
            bookToUpdate.setAuthor(newAuthor);  // Yazar adı güncellenir
            bookToUpdate.setPrice(newPrice);  // Fiyat güncellenir
            bookToUpdate.setEdition(newEdition);  // Yayınevi güncellenir
            System.out.println("Kitap bilgileri güncellendi.");
        } else {
            System.out.println("Kitap bulunamadı!");  // Kitap bulunmazsa hata mesajı
        }
    }

    // Kitap silme fonksiyonu, belirli bir kitap kütüphaneden silinir
    public void removeBook(Library library, int bookId) {
        Book bookToRemove = null;
        for (Book book : library.getBooks()) {  // Kütüphanedeki kitapları arar
            if (book.getId() == bookId) {  // Kitap ID'sine göre bulur
                bookToRemove = book;
                break;
            }
        }

        if (bookToRemove != null) {  // Kitap bulunmuşsa
            library.getBooks().remove(bookToRemove);  // Kitap kütüphaneden silinir
            System.out.println("Kitap silindi.");
        } else {
            System.out.println("Kitap bulunamadı!");  // Kitap bulunmazsa hata mesajı
        }
    }

    // Yazara ait kitapları listeleme fonksiyonu
    public void listBooksByAuthor(Library library, String authorName) {
        List<Book> booksByAuthor = new ArrayList<>();  // Yazara ait kitapları tutacak liste
        for (Book book : library.getBooks()) {  // Kütüphanedeki her kitabı kontrol eder
            if (book.getAuthor().equalsIgnoreCase(authorName)) {  // Yazar adı eşleşiyorsa
                booksByAuthor.add(book);  // Kitap listeye eklenir
            }
        }

        if (!booksByAuthor.isEmpty()) {  // Eğer kitaplar varsa
            System.out.println(authorName + " adlı yazarın kitapları:");
            for (Book book : booksByAuthor) {  // Her kitabı ekrana yazdırır
                book.display();
                System.out.println("---");
            }
        } else {
            System.out.println(authorName + " adlı yazarın kitabı bulunamadı!");  // Yazarın kitabı yoksa mesaj verir
        }
    }

    // Person sınıfından gelen, kütüphanecinin kendisini tanıttığı metot
    @Override
    public void whoYouAre() {
        System.out.println("Ben bir kütüphaneciym ve adım: " + getName());
    }
}
