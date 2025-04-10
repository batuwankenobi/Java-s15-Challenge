package library; // Bu sınıfın 'library' adlı bir pakete ait olduğunu belirtir

import java.time.LocalDate; // LocalDate sınıfını içeri aktarır (tarih tutmak için)

public class MemberRecord {
    // Üyenin kimlik numarası
    private int memberId;

    // Üye tipi (Örneğin: "Öğrenci", "Akademisyen", vb.)
    private String type;

    // Üyenin kütüphaneye kayıt olduğu tarih
    private LocalDate dateOfMembership;

    // Şu an üye tarafından alınmış kitap sayısı
    private int noBooksIssued;

    // Üyenin alabileceği maksimum kitap sayısı
    private int maxBookLimit;

    // Üyenin adı
    private String name;

    // Üyenin adresi
    private String address;

    // Üyenin telefon numarası
    private String phoneNo;

    // Tam parametreli yapıcı metot: Üye oluştururken tüm bilgileri alır
    public MemberRecord(int memberId, String type, LocalDate dateOfMembership, int noBooksIssued, int maxBookLimit, String name, String address, String phoneNo) {
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.noBooksIssued = 0; // Her üyenin başta hiç kitabı yok
        this.maxBookLimit = maxBookLimit;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    // Sadece üye ID'sine göre oluşturulan ikinci bir yapıcı (kısa versiyon)
    public MemberRecord(int memberId) {
        this.memberId = memberId;
    }

    // Aşağıdaki metotlar, field'ları dışarıdan okumak (get) ve değiştirmek (set) için kullanılır.
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(LocalDate dateOfMembership) {
        this.dateOfMembership = dateOfMembership;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public void setNoBooksIssued(int noBooksIssued) {
        this.noBooksIssued = noBooksIssued;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public void setMaxBookLimit(int maxBookLimit) {
        this.maxBookLimit = maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    // Üyenin bilgilerini yazdırmak için kullanılır
    @Override
    public String toString() {
        return "Member ID: " + memberId + " Name: " + name + " Type: " + type +
                " Address: " + address + " Phone: " + phoneNo + " Books Issued: " + noBooksIssued;
    }

    // Üye kitap aldığında çalıştırılır
    public void incBookIssued(){
        if(noBooksIssued < maxBookLimit){
            noBooksIssued++; // kitap sayısı bir artırılır
        } else {
            System.out.println("Maksimum kitap limitine ulaştın!");
        }
    }

    // Üye kitap iade ettiğinde çalıştırılır
    public void decBookIssued(){
        if(noBooksIssued > 0){
            noBooksIssued--; // kitap sayısı bir azaltılır
        } else {
            System.out.println("İade edilecek kitap yok!");
        }
    }

    // Üye ceza ya da üyelik ücreti gibi bir ödeme yaptığında çalışır
    public void payBill(double amount){
        System.out.println(name + " İsimli kayıt için " + amount + " ödendi.");
    }
}
