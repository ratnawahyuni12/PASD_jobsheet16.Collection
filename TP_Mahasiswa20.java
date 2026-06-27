public class TP_Mahasiswa20 {
    String nim;
    String nama;
    String telf;

    public TP_Mahasiswa20(String nim, String nama, String telf) {
        this.nim = nim;
        this.nama = nama;
        this.telf = telf;
    }

    public String getNim() { return nim; }
    public String getNama() { return nama; }
    public String getTelf() { return telf; }

    @Override
    public String toString() {
        return String.format("| %-12s | %-20s | %-15s |", nim, nama, telf);
    }
}