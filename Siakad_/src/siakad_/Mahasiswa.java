package siakad_;

import java.util.ArrayList;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String prodi;
    private double ipk;
    private int umur;
    private Dosen dosenWali;
    private ArrayList<MataKuliah> krs = new ArrayList<>();

    // === Getter Setter dengan validasi tambahan ===
    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getProdi() {
        return prodi;
    }

    public void setIpk(double ipk) {
        if (ipk < 0.0 || ipk > 4.0) {
            throw new IllegalArgumentException("IPK harus antara 0.0 - 4.0!");
        }
        this.ipk = ipk;
    }

    public double getIpk() {
        return ipk;
    }

    public void setUmur(int umur) {
        if (umur < 17) {
            throw new IllegalArgumentException("Umur minimal 17 tahun!");
        }
        this.umur = umur;
    }

    public int getUmur() {
        return umur;
    }

    public void setDosenWali(Dosen dosenWali) {
        this.dosenWali = dosenWali;
    }

    public Dosen getDosenWali() {
        return dosenWali;
    }

    // === Constructor ===
    public Mahasiswa(String nim, String nama, String prodi, Dosen dosenWali, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
        this.dosenWali = dosenWali;
        setIpk(ipk);
    }

    // === Fitur KRS ===
    public void tambahMataKuliah(MataKuliah mk) {
        for (MataKuliah m : krs) {
            if (m.getKodeMatkul().equalsIgnoreCase(mk.getKodeMatkul())) {
                System.out.println("Mata kuliah dengan kode " + mk.getKodeMatkul() + " sudah terdaftar!");
                return;
            }
        }
        int totalSks = hitungTotalSks() + mk.getSks();
        if (totalSks > 24) {
            System.out.println("Total SKS melebihi batas maksimal (24)!");
            return;
        }
        krs.add(mk);
        System.out.println("Mata kuliah berhasil ditambahkan!");
    }

    public void hapusMataKuliah(String kode) {
        for (MataKuliah m : krs) {
            if (m.getKodeMatkul().equalsIgnoreCase(kode)) {
                krs.remove(m);
                System.out.println("Mata kuliah " + kode + " berhasil dihapus.");
                return;
            }
        }
        System.out.println("Mata kuliah dengan kode " + kode + " tidak ditemukan.");
    }

    public void tampilKRS() {
        System.out.println("\n=== KRS Mahasiswa ===");
        System.out.println("Nama : " + nama);
        System.out.println("NIM  : " + nim);
        if (krs.isEmpty()) {
            System.out.println("Belum mengambil mata kuliah.");
            return;
        }
        int total = 0;
        for (MataKuliah m : krs) {
            System.out.println("- " + m.info());
            total += m.getSks();
        }
        System.out.println("Total SKS: " + total);
    }

    private int hitungTotalSks() {
        int total = 0;
        for (MataKuliah m : krs) total += m.getSks();
        return total;
    }

    // Menampilkan data mahasiswa lengkap
    void tampilData() {
        System.out.println("=== Data Mahasiswa ===");
        System.out.println("NIM         : " + nim);
        System.out.println("Nama        : " + nama);
        System.out.println("Prodi       : " + prodi);
        System.out.println("IPK         : " + ipk);
        if (dosenWali != null)
            System.out.println("Dosen Wali  : " + dosenWali.getNama());
        else
            System.out.println("Dosen Wali  : Belum ditentukan");
    }
}
