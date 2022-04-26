import java.util.Scanner;

public class THYRezervasyonSistemi extends UcakRezervasyonSistemi {
    public THYRezervasyonSistemi(int koltukAdedi) {
        if (koltukAdedi < 10) {
            System.out.println("Koltuk sayisi hatali. Otomatik olarak 10 yapildi");
            this.setKoltukSayisi(10);
        } else {
            this.setKoltukSayisi(koltukAdedi);
        }
    }

    @Override
    void rezervasyonAl() {
        System.out.println("\nTHY Rezervasyon Sistemine hosgeldiniz!");
        boolean ucakDoluMu = this.ucakDoluMu();
        if (!ucakDoluMu) {
            System.out.println("Business ucmak icin 0'a basiniz, ekonomi class ucmak icin 1'e basiniz:");
            Scanner input = new Scanner(System.in);
            int secilenSinif = input.nextInt();
            if (secilenSinif == 0) {
                boolean businessDoluMu = this.businessDoluMu();
                if (!businessDoluMu) {
                    System.out.println("Asagidaki bos koltuklardan birini seciniz:");
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
                        System.out.println("Yanlis koltuk numarasi girildi, tekrar giriniz:");
                        secilenKoltuk = input.nextInt();
                        if (secilenKoltuk > 0 && secilenKoltuk <= 5 && (!doluluk[secilenKoltuk - 1])) {
                            error = false;
                        }
                    }
                    this.doluluk[secilenKoltuk - 1] = true;
                    System.out.println("Koltuk no: " + secilenKoltuk + " adiniza rezerve edildi!");
                    System.out.println("iyi ucuslar!");
                } else {
                    System.out.println("Maalesef business koltuklarimiz dolu! Rezervasyon alamiyoruz!");
                }
            } else if (secilenSinif == 1) {
                boolean ekonomiDoluMu = this.ekonomiDoluMu();
                if (!ekonomiDoluMu) {
                    System.out.println("Asagidaki bos koltuklardan birini seciniz:");
                    for (int i = 5; i < this.koltuklar.length; i++) {
                        if (!doluluk[i]) {
                            System.out.print(this.koltuklar[i] + " ");
                        }
                    }
                    System.out.println();
                    int secilenKoltuk = input.nextInt();
                    boolean error = true;
                    if (secilenKoltuk <= doluluk.length && secilenKoltuk > 5 && (!doluluk[secilenKoltuk - 1])) {
                        error = false;
                    }
                    while (error) {
                        System.out.println("Yanlis koltuk numarasi girildi, tekrar giriniz:");
                        secilenKoltuk = input.nextInt();
                        if (secilenKoltuk <= doluluk.length && secilenKoltuk > 5 && (!doluluk[secilenKoltuk - 1])) {
                            error = false;
                        }
                    }
                    this.doluluk[secilenKoltuk - 1] = true;
                    System.out.println("Koltuk no: " + secilenKoltuk + " adiniza rezerve edildi!");
                    System.out.println("iyi ucuslar!");
                } else {
                    System.out.println("Maalesef ekonomi class koltuklarimiz dolu! Rezervasyon alamiyoruz!");
                }
            } else {
                System.out.println("Hatali giris yapildi!");
            }
        } else {
            System.out.println("Maalesef ucak dolu rezervasyon alamiyoruz!");
        }
    }
}