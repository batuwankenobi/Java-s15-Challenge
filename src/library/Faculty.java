package library; // Bu sınıf "library" adlı paketin içinde yer alıyor.

import java.time.LocalDate; // Üyelik tarihi için Java 8 ile gelen modern tarih sınıfı kullanılıyor.

/**
 * Faculty sınıfı, öğretim görevlisi üyeleri temsil eder ve MemberRecord sınıfından kalıtım alır.
 */
public class Faculty extends MemberRecord {
    private String department; // Öğretim görevlisinin bağlı olduğu bölüm (örn: Bilgisayar Mühendisliği)

    /**
     * Yapıcı (constructor) metot. Faculty sınıfından bir nesne oluştururken tüm bilgileri alır.
     * Üst sınıfın constructor'ına da uygun parametrelerle veri gönderilir.
     */
    public Faculty(int memberId, String type, LocalDate dateOfMembership, int noBooksIssued,
                   int maxBookLimit, String name, String address, String phoneNo, String department) {
        // Üst sınıf (MemberRecord) constructor'ı çağrılır
        super(memberId, type, dateOfMembership, noBooksIssued, maxBookLimit, name, address, phoneNo);
        this.department = department; // Kendi özel alanı atanır
    }

    // Getter: Bölüm bilgisini döner
    public String getDepartment() {
        return department;
    }

    // Setter: Bölüm bilgisini günceller
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * toString metodu, nesnenin string temsilini döner.
     * Üst sınıfın toString metoduna ek olarak bölüm bilgisini de dahil eder.
     */
    @Override
    public String toString() {
        return super.toString() + " Department: " + department;
    }
}
