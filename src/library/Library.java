package library;

// people paketinden Reader sınıfı import edilir.
import people.Reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Kütüphane sınıfı
public class Library {
    private List<Book> books; // Kütüphanedeki kitapların listesi
    private List<Reader> readers; // Kütüphaneye kayıtlı okuyucuların listesi
    private Map<Integer, Reader> barrowedBooksMap;
    // Ödünç alınan kitapların ID’sini ve hangi okuyucuda olduğunu tutan bir harita

    // Default constructor
    public Library() {
        this.books = new ArrayList<>(); // Kitap listesi oluşturuluyor
        this.readers = new ArrayList<>(); // Okuyucu listesi oluşturuluyor
        this.barrowedBooksMap = new HashMap<>(); // Ödünç alınan kitap haritası oluşturuluyor
    }

    // Kitap ve okuyucu listesi parametreli constructor
    public Library(List<Book> books, List<Reader> readers) {
        this.books = books;
        this.readers = readers;
        this.barrowedBooksMap = new HashMap<>();
    }

    // Getter: Kitap listesini döndürür
    public List<Book> getBooks() {
        return books;
    }

    // Getter: Okuyucu listesini döndürür
    public List<Reader> getReaders() {
        return readers;
    }

    // Yeni kitap ekleme
    public void newBook(Book book) {
        books.add(book);
    }

    // Kitap ödünç verme işlemi
    public boolean lendBook(Reader reader, Book book) {
        // Şartlar kontrol edilir:
        // 1. Kitap kütüphanede olmalı
        // 2. Kitap daha önce ödünç alınmamış olmalı
        // 3. Okuyucu, kitap sınırını aşmamış olmalı
        if (books.contains(book) && !barrowedBooksMap.containsKey(book.getId()) &&
                reader.getBarrowedBooks().size() < reader.getMaxBookLimit()) {

            barrowedBooksMap.put(book.getId(), reader); // Kitap, okuyucuya atanır
            book.updateStatus("Ödünç Alındı"); // Kitap durumu güncellenir
            reader.barrowBook(book); // Okuyucunun kitap listesine eklenir

            System.out.println(reader.getName() + " adlı okuyucu " + book.getName() + " adlı kitabı ödünç aldı.");
            return true;

        } else if (reader.getBarrowedBooks().size() >= reader.getMaxBookLimit()) {
            System.out.println(reader.getName() + " adlı okuyucu kitap limitine ulaştığı için ödünç alamıyor.");
            return false;

        } else if (barrowedBooksMap.containsKey(book.getId())) {
            System.out.println(book.getName() + " adlı kitap zaten ödünç alınmış.");
            return false;

        } else {
            System.out.println("Kitap kütüphanede bulunamadı.");
            return false;
        }
    }

    // Kitap iade etme işlemi
    public void takeBackBook(Reader reader, Book book) {
        // Kitap gerçekten bu okuyucuda mı?
        if (barrowedBooksMap.containsKey(book.getId()) && barrowedBooksMap.get(book.getId()).equals(reader)) {
            barrowedBooksMap.remove(book.getId()); // Kitap ödünç listesinden çıkarılır
            book.updateStatus("Kütüphanede Mevcut"); // Durumu güncellenir
            reader.returnBook(book); // Okuyucunun listesinden silinir
            System.out.println(reader.getName() + " adlı okuyucu " + book.getName() + " adlı kitabı iade etti.");
        } else {
            System.out.println(book.getName() + " adlı kitap " + reader.getName() + " tarafından ödünç alınmamış.");
        }
    }

    // Tüm kitapları listele
    public void showBook() {
        if (books.isEmpty()) {
            System.out.println("Kütüphanede hiç kitap bulunmamaktadır.");
        } else {
            System.out.println("Kütüphanedeki Kitaplar:");
            for (Book book : books) {
                book.display(); // Her kitabın bilgisi gösterilir
                System.out.println("---");
            }
        }
    }

    // Yeni okuyucu ekle
    public void addReader(Reader reader) {
        readers.add(reader);
    }

    // İsme göre okuyucu bul
    public Reader findReader(String readerName) {
        for (Reader reader : readers) {
            if (reader.getName().equalsIgnoreCase(readerName)) {
                return reader;
            }
        }
        return null; // Bulunamazsa null döner
    }

    // İsme göre kitap bul
    public Book findBook(String bookName) {
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null; // Bulunamazsa null döner
    }
}
