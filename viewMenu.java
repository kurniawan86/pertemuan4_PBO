import java.util.ArrayList;
import java.util.Scanner;

public class viewMenu {
    private final modelMenu model = new modelMenu();

    public viewMenu() {
      
    }

    public void tambahMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("masukkan nama menu: ");
        String namaMenu = scanner.nextLine();
        System.out.print("masukkan harga menu: ");
        int hargaMenu = scanner.nextInt();

        boolean berhasil = model.create(namaMenu, hargaMenu);
        if (berhasil) {
            System.out.println("Menu berhasil ditambahkan.");
        } else {
            System.out.println("Gagal menambahkan menu.");
        }
    }

    public void tampilSemuaMenu() {
        ArrayList<domainMenu> daftarMenu = model.readAll();

        if (daftarMenu.isEmpty()) {
            System.out.println("Data menu masih kosong.");
            return;
        }


        System.out.println("ID | Nama Menu \t\t\t| Harga \t| Tersedia | Tanggal Create \t| Tanggal Update");
        for (domainMenu menu : daftarMenu) {
            System.out.println(formatMenu(menu));
        }
    }

    public void tampilMenuById() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan ID menu yang ingin ditampilkan: ");
        int idMenu = scanner.nextInt();

        int index = model.readById(idMenu);

        if (index == -1) {
            System.out.println("Menu dengan ID " + idMenu + " tidak ditemukan.");
            return;
        }

        domainMenu menu = database.DB_menu.get(index);
        System.out.println("Detail menu:");
        System.out.println("ID | Nama Menu | Harga | Tersedia | Tanggal Create | Tanggal Update");
        System.out.println(formatMenu(menu));
    }

    public void updateMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan ID menu yang ingin diupdate: ");
        int idMenu = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan nama menu baru: ");
        String namaBaru = scanner.nextLine();
        System.out.print("Masukkan harga menu baru: ");
        int hargaBaru = scanner.nextInt();
        System.out.print("Apakah menu tersedia? (true/false): ");
        boolean tersedia = scanner.nextBoolean();
        boolean berhasil = model.update(idMenu, namaBaru, hargaBaru, tersedia);
        if (berhasil) {
            System.out.println("Update menu ID " + idMenu + " berhasil.");
        } else {
            System.out.println("Update menu ID " + idMenu + " gagal.");
        }
    }

    public void hapusMenu(int idMenu) {
        boolean berhasil = model.delete(idMenu);
        if (!berhasil) {
            System.out.println("Hapus menu ID " + idMenu + " gagal.");
        }
    }

    private String formatMenu(domainMenu menu) {
        String statusTersedia = menu.tersedia ? "Ya" : "Tidak";
        String tanggalUpdate = menu.tanggalUpdate != null ? menu.tanggalUpdate : "-";

        return menu.idMenu + " | "
                + menu.namaMenu + " \t\t\t| "
                + menu.hargaMenu + " \t| "
                + statusTersedia + " | "
                + menu.tanggalCreate + " \t| "
                + tanggalUpdate;
    }
}
