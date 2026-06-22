import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMahasiswa20 {
    List<Mahasiswa20> mahasiswas = new ArrayList<>();

    public void tambah(Mahasiswa20... mahasiswa) {
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    public void hapus(int index) {
        mahasiswas.remove(index);
    }

    public void update(int index, Mahasiswa20 mhs) {
        mahasiswas.set(index, mhs);
    }

    public void tampil() {
        mahasiswas.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }

    int linearSearch(String nim) {
        for (int i = 0; i < mahasiswas.size(); i++) {
            if (nim.equals(mahasiswas.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ListMahasiswa20 lm = new ListMahasiswa20();
        Mahasiswa20 m = new Mahasiswa20("201234", "Noureen", "021xx1");
        Mahasiswa20 m1 = new Mahasiswa20("201235", "Akhleema", "021xx2");
        Mahasiswa20 m2 = new Mahasiswa20("201236", "Shannum", "021xx3");

        // menambahkan objek mahasiswa
        lm.tambah(m, m1, m2);
        
        // menampilkan list mahasiswa
        lm.tampil();
        
        // update mahasiswa
        lm.update(lm.linearSearch("201235"), new Mahasiswa20("201235", "Akhleema Lela", "021xx2"));
        System.out.println("");
        lm.tampil();
    }
}