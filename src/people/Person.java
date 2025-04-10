package people;

public abstract class Person {
    private String name;  // Kişinin adı

    // Yapıcı metot, kişinin adını alır ve atar
    public Person(String name) {
        this.name = name;
    }

    // Adı alır
    public String getName() {
        return name;
    }

    // Adı değiştirir
    public void setName(String name) {
        this.name = name;
    }

    // Soyut metot, her sınıf bu metodu kendi şekilde tanımlamalıdır
    public abstract void whoYouAre();
}
