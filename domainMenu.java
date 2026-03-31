import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class domainMenu {
    int idMenu;
    String namaMenu;
    int hargaMenu;
    boolean tersedia;
    String tanggalCreate;
    String tanggalUpdate;

    public domainMenu (int idMenu, String nama, int harga) {
        this.idMenu = idMenu;
        this.namaMenu = nama;
        this.hargaMenu = harga;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.tanggalCreate = LocalDateTime.now().format(format);
        this.tersedia = true;
    }
}
