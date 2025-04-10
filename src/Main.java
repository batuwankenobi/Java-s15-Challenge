import library.Book;
import library.Library;
import library.MemberRecord;
import people.Author;
import people.Librarian;
import people.Reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); // Kullanıcıdan giriş almak için Scanner nesnesi oluşturulur.

        // Kütüphane oluşturuluyor
        Library library = new Library();

        // Yazarlar oluşturuluyor
        Author author1 = new Author("J.K. Rowling");
        Author author2 = new Author("George Orwell");

        // Kitaplar oluşturuluyor ve yazarlara atanıyor
        Book book1 = new Book("Harry Potter", author1.getName());
        Book book2 = new Book("1984", author1.getName());
        Book book3 = new Book("Animal Farm", author2.getName());
        Book book4 = new Book("Anna Karanina1", author2.getName());
        Book book5 = new Book("Anna Karanina2", author2.getName());
        Book book6 = new Book("Harry Potter2", author1.getName());

        // Yazarlar yeni kitaplar ekliyor
        author1.newBook(book1);
        author1.newBook(book2);
        author2.newBook(book3);
        author2.newBook(book4);
        author2.newBook(book5);
        author1.newBook(book6);

        // Kitaplar kütüphaneye ekleniyor
        library.newBook(book1);
        library.newBook(book2);
        library.newBook(book3);
        library.newBook(book4);
        library.newBook(book5);
        library.newBook(book6);

        // Kütüphaneci oluşturuluyor
        Librarian librarian = new Librarian("Ahmet", "1234");

        // Üye oluşturuluyor ve iki kitap ödünç alması sağlanıyor
        MemberRecord memberRecord = new MemberRecord(1); // Üye kaydını oluşturuyoruz
        Reader reader = new Reader("Batuhan", memberRecord, new ArrayList<>(), new ArrayList<>(), 5); // Okuyucu oluşturuluyor
        library.lendBook(reader, book1); // Kitap ödünç veriliyor
        library.lendBook(reader, book2); // Diğer kitap ödünç veriliyor

        // Kullanıcı menüsü başlatılıyor
        while(true){
            System.out.println("\nKütüphane Yönetim Sistemine Hoşgeldiniz!"); // Menü başlığı
            System.out.println("1. Kütüphaneci Girişi");
            System.out.println("2. Okuyucu Girişi");
            System.out.println("3. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt(); // Kullanıcıdan seçenek alınır
            scanner.nextLine(); // Kullanıcının girdiği değeri temizler

            switch (choice) {
                case 1: // Kütüphaneci menüsüne yönlendirilir
                    librarianMenu(scanner, librarian, library);
                    break;
                case 2: // Okuyucu menüsüne yönlendirilir
                    readerMenu(scanner, reader, library);
                    break;
                case 3: // Çıkış yapar
                    System.out.println("Çıkış yapılıyor...");
                    return;
                default:
                    System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        }
    }

    // Kütüphaneci menüsü
    public static void librarianMenu(Scanner scanner, Librarian librarian, Library library) {
        System.out.print("Şifreyi giriniz: ");
        String password = scanner.nextLine(); // Kütüphaneci şifresi alınır
        if (!password.equals(librarian.getPassword())) {
            System.out.println("Yanlış şifre! Menüye geri dönülüyor...");
            return; // Eğer şifre yanlışsa geri döner
        }
        while (true) {
            // Kütüphaneciye özel işlem menüsü
            System.out.println("\nKütüphaneci Menüsü");
            System.out.println("1. Kitap Ara");
            System.out.println("2. Kitap Ödünç Ver");
            System.out.println("3. Kitap İade Al");
            System.out.println("4. Yeni Kitap Ekle");
            System.out.println("5. Kitap Bilgilerini Güncelle");
            System.out.println("6. Kitap Sil");
            System.out.println("7. Yazarın Tüm Kitaplarını Listele");
            System.out.println("8. Ana Menüye Dön");
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Kitap arama işlemi
                    System.out.print("Aramak istediğiniz kitabın adını giriniz: ");
                    String bookName = scanner.nextLine();
                    librarian.searchBook(library, bookName); // Kütüphaneci kitabı arar
                    break;
                case 2:
                    // Kitap ödünç verme işlemi
                    System.out.print("Okuyucunun adını girin: ");
                    String readerName = scanner.nextLine();
                    Reader reader = library.findReader(readerName); // Okuyucuyu bul
                    if (reader == null) {
                        System.out.println("Okuyucu bulunamadı.");
                        break;
                    }

                    System.out.print("Ödünç verilecek kitabın adını girin: ");
                    String bookToLendName = scanner.nextLine();
                    Book bookToLend = library.findBook(bookToLendName); // Kitabı bul
                    if (bookToLend == null) {
                        System.out.println("Kitap bulunamadı.");
                        break;
                    }

                    boolean success = librarian.issueBook(library, reader, bookToLend); // Kitap ödünç verilir
                    if (success) {
                        System.out.println("Kitap başarıyla ödünç verildi.");
                    } else {
                        System.out.println("Kitap ödünç verme işlemi başarısız oldu.");
                    }
                    break;
                case 3:
                    // Kitap iade alma işlemi
                    System.out.print("Okuyucunun adını girin: ");
                    String returnReaderName = scanner.nextLine();
                    Reader returnReader = library.findReader(returnReaderName);
                    if (returnReader == null) {
                        System.out.println("Okuyucu bulunamadı.");
                        break;
                    }

                    System.out.print("İade edilecek kitabın adını girin: ");
                    String returnBookName = scanner.nextLine();
                    Book returnBook = library.findBook(returnBookName);
                    if (returnBook == null) {
                        System.out.println("Kitap bulunamadı!");
                        break;
                    }

                    librarian.returnBook(library, returnReader, returnBook); // Kitap iade edilir
                    break;
                case 4:
                    // Yeni kitap ekleme işlemi
                    System.out.print("Yeni kitabın adını girin: ");
                    String newBookName = scanner.nextLine();
                    System.out.print("Yazarın adını girin: ");
                    String author = scanner.nextLine();
                    library.newBook(new Book(newBookName, author)); // Yeni kitap eklenir
                    System.out.println("Kitap başarıyla eklendi!");
                    break;
                case 5: // Kitap güncelleme işlemi
                    // Kitap bilgilerini güncelleme
                    System.out.print("Güncellenecek kitabın ID'sini girin: ");
                    int updateBookId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Yeni Kitap Adı: ");
                    String updateBookName = scanner.nextLine();
                    System.out.print("Yeni Yazar: ");
                    String newBookAuthor = scanner.nextLine();
                    System.out.print("Yeni Fiyat: ");
                    double newBookPrice = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Yeni Edisyon: ");
                    String newBookEdition = scanner.nextLine();
                    librarian.updateBook(library, updateBookId, updateBookName, newBookAuthor, newBookPrice, newBookEdition); // Kitap güncellenir
                    break;
                case 6: // Kitap silme işlemi
                    System.out.print("Silinecek kitabın ID'sini girin: ");
                    int deleteBookId = scanner.nextInt();
                    librarian.removeBook(library, deleteBookId); // Kitap silinir
                    break;
                case 7: // Yazarın kitaplarını listeleme
                    System.out.print("Yazarın adını girin: ");
                    String authorName = scanner.nextLine();
                    librarian.listBooksByAuthor(library, authorName); // Yazarın kitapları listelenir
                    break;
                case 8:
                    return; // Ana menüye geri dönülür
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    // Okuyucu menüsü
    public static void readerMenu(Scanner scanner, Reader reader, Library library) {
        while (true) {
            // Okuyucuya özel işlem menüsü
            System.out.println("\nOkuyucu Menüsü");
            System.out.println("1. Ödünç Aldığım Kitapları Göster");
            System.out.println("2. Satın Aldığım Kitapları Göster");
            System.out.println("3. Kitap Ödünç Al");
            System.out.println("4. Kitap İade Et");
            System.out.println("5. Ana Menüye Dön");
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt(); // Kullanıcıdan seçim alınır
            scanner.nextLine(); // Kullanıcının girdiği değeri temizler

            switch (choice) {
                case 1:
                    reader.showBarrowedBook(); // Okuyucunun ödünç aldığı kitapları göster
                    break;
                case 2:
                    reader.showPurchasedBook(); // Okuyucunun satın aldığı kitapları göster
                    break;
                case 3:
                    // Kitap ödünç alma işlemi
                    System.out.print("Ödünç almak istediğiniz kitabın adını girin: ");
                    String borrowBookName = scanner.nextLine();
                    Book bookToBorrow = library.findBook(borrowBookName); // Kitap nesnesi bulunur
                    if (bookToBorrow != null) {
                        reader.barrowBook(bookToBorrow); // Kitap ödünç alınır
                    } else {
                        System.out.println("Kitap bulunamadı!");
                    }
                    break;
                case 4:
                    // Kitap iade etme işlemi
                    System.out.print("İade edilecek kitabın adını girin: ");
                    String returnBookName = scanner.nextLine();
                    Book bookToReturn = library.findBook(returnBookName); // Kitap bulunur
                    if (bookToReturn != null) {
                        reader.returnBook(bookToReturn); // Kitap iade edilir
                    } else {
                        System.out.println("Kitap bulunamadı!");
                    }
                    break;
                case 5:
                    return; // Ana menüye dönülür
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}
