import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class modelMenu {

    int getLastId() {
        if (database.DB_menu.isEmpty()) {
            return 0;
        }
        return database.DB_menu.get(database.DB_menu.size() - 1).idMenu;
    }

    boolean create(String namaMenu, int hargaMenu) {
        int idBaru = getLastId() + 1;
        database.DB_menu.add(new domainMenu(idBaru, namaMenu, hargaMenu));
        return true;
    }

    ArrayList<domainMenu> readAll() {
        return database.DB_menu;
    }

    int readById(int idMenu) {
        for (int i = 0; i < database.DB_menu.size(); i++) {
            if (database.DB_menu.get(i).idMenu == idMenu) {
                return i;
            }
        }
        return -1;
    }

    boolean update(int idMenu, String namaBaru, int hargaBaru, boolean tersedia) {
        int index = readById(idMenu);
        if (index == -1) {
            return false;
        }
        domainMenu menu = database.DB_menu.get(index);
        menu.namaMenu = namaBaru;
        menu.hargaMenu = hargaBaru;
        menu.tersedia = tersedia;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        menu.tanggalUpdate = LocalDateTime.now().format(format);
        return true;
    }

    public boolean delete(int idMenu) {
        int index = readById(idMenu);
        if (index == -1) {
            System.out.println("Gagal hapus: Menu dengan ID " + idMenu + " tidak ditemukan.");
            return false;
        }
        database.DB_menu.remove(index);
        System.out.println("Menu ID " + idMenu + " berhasil dihapus.");
        return true;
    }

    void insertStaticData() {
        create("Nasi Goreng", 15000);
        create("Mie Ayam", 12000);
        create("Sate Ayam", 20000);
    }
}