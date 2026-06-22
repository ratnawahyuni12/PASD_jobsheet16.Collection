import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

    int binarySearch(String nim) {
        Collections.sort(mahasiswas, Comparator.comparing(mhs -> mhs.nim));
        Mahasiswa20 target = new Mahasiswa20(nim, null, null);
        return Collections.binarySearch(mahasiswas, target, Comparator.comparing(mhs -> mhs.nim));
    }

    public void sortAscending() {
        Collections.sort(mahasiswas, Comparator.comparing(mhs -> mhs.nama));
    }

    public void sortDescending() {
        Collections.sort(mahasiswas, Comparator.comparing((Mahasiswa20 mhs) -> mhs.nama).reversed());
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
        lm.update(lm.binarySearch("201235"), new Mahasiswa20("201235", "Akhleema Lela", "021xx2"));
        System.out.println("");
        lm.tampil();

        System.out.println("\nSorting Ascending:");
        lm.sortAscending();
        lm.tampil();

        System.out.println("\nSorting Descending:");
        lm.sortDescending();
        lm.tampil();
    }
}