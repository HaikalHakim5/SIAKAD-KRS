package siakad_;

public class MataKuliah {
    private String kodeMatkul;
    private String namaMk;
    private int sks;

    // Constructor
    public MataKuliah(String kodeMatkul, String namaMk, int sks) {
        setKodeMatkul(kodeMatkul);
        setNamaMk(namaMk);
        setSks(sks);
    }

    // Getter dan Setter dengan Validasi
    public String getKodeMatkul() {
        return kodeMatkul;
    }

    public void setKodeMatkul(String kodeMatkul) {
        if (kodeMatkul == null || kodeMatkul.trim().isEmpty()) {
            throw new IllegalArgumentException("Kode mata kuliah tidak boleh kosong!");
        }
        this.kodeMatkul = kodeMatkul;
    }

    public String getNamaMk() {
        return namaMk;
    }

    public void setNamaMk(String namaMk) {
        this.namaMk = namaMk;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        if (sks < 1 || sks > 6) {
            throw new IllegalArgumentException("SKS harus antara 1 - 6!");
        }
        this.sks = sks;
    }

    // Method info()
    public String info() {
        return kodeMatkul + " - " + namaMk + " (" + sks + " SKS)";
    }
}
