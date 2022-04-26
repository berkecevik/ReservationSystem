public abstract class UcakRezervasyonSistemi {
    private int koltukSayisi;
    public int[] koltuklar;
    public boolean[] doluluk;

    public void setKoltukSayisi(int koltukAdedi) {
        this.koltukSayisi = koltukAdedi;
        createArrays();
    }

    private void createArrays() {
        this.koltuklar = new int[koltukSayisi];
        this.doluluk = new boolean[koltukSayisi];
        for (int k = 0; k < this.koltukSayisi; k++) {
            this.koltuklar[k] = k + 1;
            this.doluluk[k] =  false;
        }
    }

    public int getKoltukSayisi() {
        return this.koltukSayisi;
    }

    public boolean ekonomiDoluMu() {
        for (int i = 5; i < this.koltukSayisi; i++) {
            if (!doluluk[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean businessDoluMu() {
        for (int i = 0; i < 5; i++) {
            if (!doluluk[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean ucakDoluMu() {
        for (int i = 0; i < this.koltukSayisi; i++) {
            if (!doluluk[i]) {
                return false;
            }
        }
        return true;
    }

    abstract void rezervasyonAl();
}