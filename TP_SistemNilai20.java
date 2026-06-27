import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TP_SistemNilai20 {
    static List<TP_Mahasiswa20> daftarMahasiswa = new ArrayList<>();
    static List<TP_MataKuliah20> daftarMataKuliah = new ArrayList<>();
    static List<TP_Nilai20> daftarNilai = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static final String LINE_MHS   = "+"+"-".repeat(14)+"+"+"-".repeat(22)+"+"+"-".repeat(17)+"+";
    static final String LINE_MK = "+"+"-".repeat(10)+"+"+"-".repeat(44)+"+"+"-".repeat(5)+"+";
    static final String LINE_NILAI = "+"+"-".repeat(14)+"+"+"-".repeat(22)+"+"+"-".repeat(44)+
    "+"+"-".repeat(5)+"+"+"-".repeat(8)+"+";

    public static void main(String[] args) {
        inputDataMahasiswa();
        inputDataMataKuliah();

        int pilih;
        do {
            tampilMenu();
            System.out.print("Pilih : ");
            pilih = Integer.parseInt(sc.nextLine().trim());
            System.out.println();

            switch (pilih) {
                case 1: inputNilai(); break;
                case 2: tampilNilai(); break;
                case 3: cariNilaiMahasiswa(); break;
                case 4: urutDataNilai(); break;
                case 5: System.out.println("Terima kasih, program selesai."); break;
                default: System.out.println("Pilihan tidak tersedia.");
            }
            System.out.println();
        } while (pilih != 5);
    }

    // ─── Input awal ───────────────────────────────────────────────────────────

    static void inputDataMahasiswa() {
        System.out.print("Masukkan jumlah mahasiswa : ");
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));
            System.out.print("  NIM  : ");  String nim  = sc.nextLine().trim();
            System.out.print("  Nama : ");  String nama = sc.nextLine().trim();
            System.out.print("  Telf : ");  String telf = sc.nextLine().trim();
            daftarMahasiswa.add(new TP_Mahasiswa20(nim, nama, telf));
        }
        System.out.println();
    }

    static void inputDataMataKuliah() {
        System.out.print("Masukkan jumlah mata kuliah : ");
        int n = Integer.parseInt(sc.nextLine().trim());
        for (int i = 0; i < n; i++) {
            System.out.println("\nData Mata Kuliah ke-" + (i + 1));
            System.out.print("  Kode        : ");  String kode   = sc.nextLine().trim();
            System.out.print("  Mata Kuliah : ");  String namaMK = sc.nextLine().trim();
            System.out.print("  SKS         : ");  int sks = Integer.parseInt(sc.nextLine().trim());
            daftarMataKuliah.add(new TP_MataKuliah20(kode, namaMK, sks));
        }
        System.out.println();
    }

    // ─── Menu ─────────────────────────────────────────────────────────────────

    static void tampilMenu() {
        System.out.println("=".repeat(52));
        System.out.println("   SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER");
        System.out.println("=".repeat(52));
        System.out.println("  1. Input Nilai");
        System.out.println("  2. Tampil Nilai");
        System.out.println("  3. Mencari Nilai Mahasiswa");
        System.out.println("  4. Urut Data Nilai");
        System.out.println("  5. Keluar");
        System.out.println("=".repeat(52));
    }

    // ─── Helper cetak tabel ───────────────────────────────────────────────────

    static void cetakDaftarMahasiswa() {
        System.out.println("\nDAFTAR MAHASISWA");
        System.out.println(LINE_MHS);
        System.out.printf("| %-12s | %-20s | %-15s |%n", "NIM", "Nama", "Telf");
        System.out.println(LINE_MHS);
        for (TP_Mahasiswa20 m : daftarMahasiswa) System.out.println(m);
        System.out.println(LINE_MHS);
    }

    static void cetakDaftarMataKuliah() {
        System.out.println("\nDAFTAR MATA KULIAH");
        System.out.println(LINE_MK);
        System.out.printf("| %-8s | %-42s | %-3s |%n", "Kode", "Mata Kuliah", "SKS");
        System.out.println(LINE_MK);
        for (TP_MataKuliah20 mk : daftarMataKuliah) System.out.println(mk);
        System.out.println(LINE_MK);
}

    static void cetakHeaderNilai(String judul) {
        System.out.println("\n" + judul);
        System.out.println(LINE_NILAI);
        System.out.printf("| %-12s | %-20s | %-42s | %-3s | %-6s |%n",
            "NIM", "Nama", "Mata Kuliah", "SKS", "Nilai");
        System.out.println(LINE_NILAI);
}

    // ─── Pencarian helper ─────────────────────────────────────────────────────

    static TP_Mahasiswa20 cariMahasiswa(String nim) {
        for (TP_Mahasiswa20 m : daftarMahasiswa)
            if (m.getNim().equalsIgnoreCase(nim)) return m;
        return null;
    }

    static TP_MataKuliah20 cariMataKuliah(String kode) {
        for (TP_MataKuliah20 mk : daftarMataKuliah)
            if (mk.getKode().equalsIgnoreCase(kode)) return mk;
        return null;
    }

    // ─── Fitur 1: Input Nilai ─────────────────────────────────────────────────

    static void inputNilai() {
        cetakDaftarMahasiswa();
        System.out.print("Pilih mahasiswa by NIM : ");
        String nim = sc.nextLine().trim();
        TP_Mahasiswa20 mhs = cariMahasiswa(nim);
        if (mhs == null) { System.out.println("NIM tidak ditemukan!"); return; }

        cetakDaftarMataKuliah();
        System.out.print("Pilih MK by kode : ");
        String kode = sc.nextLine().trim();
        TP_MataKuliah20 mk = cariMataKuliah(kode);
        if (mk == null) { System.out.println("Kode MK tidak ditemukan!"); return; }

        System.out.print("Nilai : ");
        double nilai = Double.parseDouble(sc.nextLine().trim());

        daftarNilai.add(new TP_Nilai20(mhs, mk, nilai));
        System.out.println("\n>> Data nilai berhasil ditambahkan!");
    }

    // ─── Fitur 2: Tampil Nilai ────────────────────────────────────────────────

    static void tampilNilai() {
        cetakHeaderNilai("DAFTAR NILAI MAHASISWA");
        if (daftarNilai.isEmpty()) {
            System.out.println("| " + String.format("%-83s", "  (belum ada data)") + "|");
        } else {
            for (TP_Nilai20 n : daftarNilai) System.out.println(n);
        }
        System.out.println(LINE_NILAI);
    }

    // ─── Fitur 3: Cari Nilai Mahasiswa ────────────────────────────────────────

    static void cariNilaiMahasiswa() {
        tampilNilai();
        System.out.print("\nMasukkan NIM mahasiswa yang dicari : ");
        String nim = sc.nextLine().trim();

        cetakHeaderNilai("HASIL PENCARIAN - NIM : " + nim);
        int totalSks = 0;
        boolean ada = false;
        for (TP_Nilai20 n : daftarNilai) {
            if (n.mahasiswa.getNim().equalsIgnoreCase(nim)) {
                System.out.println(n);
                totalSks += n.mataKuliah.getSks();
                ada = true;
            }
        }
        System.out.println(LINE_NILAI);
        if (!ada) System.out.println("Data mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        else System.out.println("Total SKS diambil : " + totalSks + " SKS");
    }

    // ─── Fitur 4: Urut Data Nilai ─────────────────────────────────────────────

    static void urutDataNilai() {
        List<TP_Nilai20> terurut = new ArrayList<>(daftarNilai);
        Collections.sort(terurut);
        cetakHeaderNilai("DAFTAR NILAI (Diurutkan Ascending)");
        for (TP_Nilai20 n : terurut) System.out.println(n);
        System.out.println(LINE_NILAI);
    }
}