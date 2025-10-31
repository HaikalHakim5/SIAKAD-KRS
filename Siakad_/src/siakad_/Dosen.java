package siakad_;

public class Dosen {
    private String nidn;
    private String nama;
    private String prodi;
    private String status_dosen;

    public void setNidn (String nidn) {
        this.nidn = nidn;
    }
    public String getNidn () {
        return nidn;
    }

    public void setNama (String nama) {
        this.nama = nama;
    }
    public String getNama () {
        return nama;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
    public String getProdi () {
        return prodi;
    }

    public void setStatus_Dosen (String status_dosen) {
        this.status_dosen = status_dosen;
    }
    public String getStatus_Dosen () {
        return status_dosen;
    }

    // Constructor default
    public Dosen() {}

    // Constructor berparameter
    public Dosen(String nidn, String nama, String prodi, String status_dosen) {
        this.nidn = nidn;
        this.nama = nama;
        this.prodi = prodi;
        this.status_dosen = status_dosen;
    }

    // Method info()
    void info() {
        System.out.println("=== Data Dosen ===");
        System.out.println("NIDN          : " + nidn);
        System.out.println("Nama          : " + nama);
        System.out.println("Prodi         : " + prodi);
        System.out.println("Status Dosen  : " + status_dosen);
    }
}
