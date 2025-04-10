package util;

import people.Reader;  // Reader sınıfını import eder, çünkü her fatura bir okuyucuya ait olacaktır.
import java.util.Date;  // Fatura tarihi için Date sınıfını kullanır.

public class Bill {
    private Reader reader; // Faturanın ait olduğu okuyucuyu tutar
    private double amount; // Faturadaki tutar
    private Date issueDate; // Faturanın düzenlenme tarihi

    // Yapıcı metod (Constructor) - Reader nesnesi ve tutar ile fatura oluşturulurken çağrılır
    public Bill(Reader reader, double amount) {
        this.reader = reader; // Okuyucu nesnesini atar
        this.amount = amount; // Fatura tutarını atar
        this.issueDate = new Date(); // Fatura tarihi olarak şu anki tarih atanır
    }

    // Getter ve Setter metodları

    // Okuyucuyu döndüren getter metod
    public Reader getReader() {
        return reader;
    }

    // Okuyucuya yeni bir değer atayan setter metod
    public void setReader(Reader reader) {
        this.reader = reader;
    }

    // Fatura tutarını döndüren getter metod
    public double getAmount() {
        return amount;
    }

    // Fatura tutarını değiştiren setter metod
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Fatura tarihini döndüren getter metod
    public Date getIssueDate() {
        return issueDate;
    }

    // Fatura tarihini değiştiren setter metod
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    // Fatura detaylarını yazdıran metod
    public void displayBill() {
        System.out.println("Fatura Detayları:");  // Başlık yazdırılır
        System.out.println("Kullanıcı: " + reader.getName());  // Okuyucunun adı yazdırılır
        System.out.println("Tutar: " + amount + " TL");  // Fatura tutarı yazdırılır
        System.out.println("Fatura Tarihi: " + issueDate);  // Fatura tarihi yazdırılır
    }
}
