import java.util.ArrayList;

public class viewMenu {
    private final modelMenu model;

    public viewMenu(modelMenu model) {
        this.model = model;
    }

    public void tambahMenu(String namaMenu, int hargaMenu) {
        boolean berhasil = model.create(namaMenu, hargaMenu);
        if (berhasil) {
            System.out.println("Tambah menu '" + namaMenu + "' berhasil.");
        } else {
            System.out.println("Tambah menu '" + namaMenu + "' gagal.");
        }
    }

    public void tampilSemuaMenu() {
        ArrayList<domainMenu> daftarMenu = model.readAll();

        if (daftarMenu.isEmpty()) {
            System.out.println("Data menu masih kosong.");
            return;
        }

        System.out.println("ID | Nama Menu | Harga | Tersedia | Tanggal Create | Tanggal Update");
        for (domainMenu menu : daftarMenu) {
            System.out.println(formatMenu(menu));
        }
    }

    public void tampilMenuById(int idMenu) {
        int index = model.readById(idMenu);

        if (index == -1) {
            System.out.println("Menu dengan ID " + idMenu + " tidak ditemukan.");
            return;
        }

        domainMenu menu = model.DB_menu.get(index);
        System.out.println("Detail menu:");
        System.out.println("ID | Nama Menu | Harga | Tersedia | Tanggal Create | Tanggal Update");
        System.out.println(formatMenu(menu));
    }

    public void updateMenu(int idMenu, String namaBaru, int hargaBaru, boolean tersedia) {
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
                + menu.namaMenu + " | "
                + menu.hargaMenu + " | "
                + statusTersedia + " | "
                + menu.tanggalCreate + " | "
                + tanggalUpdate;
    }
}
