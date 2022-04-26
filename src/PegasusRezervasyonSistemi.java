import java.util.Scanner;
import java.util.Random;

public class PegasusRezervasyonSistemi extends UcakRezervasyonSistemi {
    public PegasusRezervasyonSistemi(int koltukSayisi) {
        if (koltukSayisi < 10) {
            System.out.println("Koltuk sayısı hatalı. Otomatik olarak 10 yapıldı");
            this.setKoltukSayisi(10);
        } else {
            this.setKoltukSayisi(koltukSayisi);
        }
    }

    @Override
    void rezervasyonAl() {
        System.out.println("\nPegasus Rezervasyon Sistemine hoşgeldiniz!");
        boolean ucakDoluMu = this.ucakDoluMu();
        if (!ucakDoluMu) {
            System.out.println("Business uçmak için 0'a basınız, ekonomi class uçmak için 1'e basınız:");
            Scanner input = new Scanner(System.in);
            int secilenSınıf = input.nextInt();
            if (secilenSınıf == 0) {
                boolean businessDoluMu = this.businessDoluMu();
                if (!businessDoluMu) {
                    System.out.println("Aşağıdaki boş koltuklardan birini seçiniz:");
                    for (int i = 0; i < 5; i++) {
                        if (!doluluk[i]) {
                            System.out.print(this.koltuklar[i] + " ");
                        }
                    }
                    System.out.println();
                    int secilenKoltuk = input.nextInt();
                    boolean error = true;
                    if (secilenKoltuk > 0 && secilenKoltuk <= 5 && (!doluluk[secilenKoltuk - 1])) {
                        error = false;
                    }
                    while (error) {
                        System.out.println("Yanlış koltuk numarası girildi, tekrar giriniz:");
                        secilenKoltuk = input.nextInt();
                        if (secilenKoltuk > 0 && secilenKoltuk <= 5 && (!doluluk[secilenKoltuk - 1])) {
                            error = false;
                        }
                    }
                    this.doluluk[secilenKoltuk - 1] = true;
                    System.out.println("Koltuk no: " + secilenKoltuk + " adınıza rezerve edildi!");
                    System.out.println("İyi uçuşlar!");
                } else {
                    System.out.println("Maalesef business koltuklarımız dolu! Rezervasyon alamıyoruz!");
                }
            } else if (secilenSınıf == 1) {
                boolean ekonomiDoluMu = this.ekonomiDoluMu();
                if (!ekonomiDoluMu) {
                    for (int i = 5; i < this.koltuklar.length; i++) {
                        if (!doluluk[i]) {
                        }
                    }
                    System.out.println();

                    int secilenKoltuk = new Random().nextInt((this.koltuklar.length + 1) - 5) + 5;
                    boolean error = true;
                    if (secilenKoltuk <= doluluk.length && secilenKoltuk > 5 && (!doluluk[secilenKoltuk - 1])) {
                        error = false;
                    }
                    while (error) {
                        secilenKoltuk = new Random().nextInt((this.koltuklar.length + 1) - 5) + 5;
                        if (secilenKoltuk <= doluluk.length && secilenKoltuk > 5 && (!doluluk[secilenKoltuk - 1])) {
                            error = false;
                        }
                    }
                    this.doluluk[secilenKoltuk - 1] = true;
                    System.out.println("Koltuk no: " + secilenKoltuk + " adınıza rezerve edildi!");
                    System.out.println("İyi uçuşlar!");
                } else {
                    System.out.println("Maalesef ekonomi class koltuklarımız dolu! Rezervasyon alamıyoruz!");
                }
            } else {
                System.out.println("Hatalı giriş yapıldı!");
            }
        } else {
            System.out.println("Maalesef uçak dolu rezervasyon alamıyoruz!");
        }
    }
}