public class TP_Nilai20 implements Comparable<TP_Nilai20> {
    TP_Mahasiswa20 mahasiswa;
    TP_MataKuliah20 mataKuliah;
    double nilai;

    public TP_Nilai20(TP_Mahasiswa20 mahasiswa, TP_MataKuliah20 mataKuliah, double nilai) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.nilai = nilai;
    }

    @Override
    public int compareTo(TP_Nilai20 o) {
        return Double.compare(this.nilai, o.nilai);
    }

    @Override
    public String toString() {
        return String.format("| %-12s | %-20s | %-42s | %-3d | %-6.2f |",
                mahasiswa.getNim(), mahasiswa.getNama(),
                mataKuliah.getNamaMK(), mataKuliah.getSks(), nilai);
    }
}