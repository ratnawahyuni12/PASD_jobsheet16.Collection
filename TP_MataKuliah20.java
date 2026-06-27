public class TP_MataKuliah20 {
    String kode;
    String namaMK;
    int sks;

    public TP_MataKuliah20(String kode, String namaMK, int sks) {
        this.kode = kode;
        this.namaMK = namaMK;
        this.sks = sks;
    }

    public String getKode() { return kode; }
    public String getNamaMK() { return namaMK; }
    public int getSks() { return sks; }

    @Override
    public String toString() {
        return String.format("| %-8s | %-42s | %-3d |", kode, namaMK, sks);
    }
}