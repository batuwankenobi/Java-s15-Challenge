package library; // Bu sınıf, 'library' adlı paketin içinde yer alır

import java.time.LocalDate; // Tarih işlemleri için LocalDate sınıfı import edilir

// Student sınıfı, MemberRecord sınıfından türetilmiştir (kalıtım - inheritance)
public class Student extends MemberRecord {

    // Öğrencinin bağlı olduğu bölüm bilgisi
    private String department;

    /**
     * Yapıcı metod (constructor)
     * Üye oluştururken tüm bilgileri alır ve üst sınıfa (MemberRecord) gönderir
     * department bilgisi ise bu sınıfa özel olarak atanır
     */
    public Student(int memberId, String type, LocalDate dateOfMembership, int noBooksIssued,
                   int maxBookLimit, String name, String address, String phoneNo, String department) {
        // Üst sınıfın (MemberRecord) constructor'ı çağrılır
        super(memberId, type, dateOfMembership, noBooksIssued, maxBookLimit, name, address, phoneNo);
        // Öğrencinin bölüm bilgisi atanır
        this.department = department;
    }

    // department alanı için getter (okuma) metodu
    public String getDepartment() {
        return department;
    }

    // department alanı için setter (değiştirme) metodu
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Üyenin bilgilerini yazdırmak için kullanılan toString metodu override edildi.
     * Üst sınıftaki toString() kullanıldıktan sonra, bölüm bilgisi de eklenir.
     */
    @Override
    public String toString() {
        return super.toString() + " Department: " + department;
    }
}
