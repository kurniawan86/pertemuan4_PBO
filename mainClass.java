public class mainClass {

    public static void main(String[] args) {
        modelMenu model = new modelMenu();

        // ===================== CREATE =====================
        System.out.println("===== TEST CREATE =====");
        boolean c1 = model.create("Nasi Goreng", 15000);
        boolean c2 = model.create("Mie Ayam", 12000);
        boolean c3 = model.create("Es Teh Manis", 5000);
        if (c1) {
            System.out.println("Tambah 'Nasi Goreng'  : Berhasil");
        } else {
            System.out.println("Tambah 'Nasi Goreng'  : Gagal");
        }
        if (c2) {
            System.out.println("Tambah 'Mie Ayam'     : Berhasil");
        } else {
            System.out.println("Tambah 'Mie Ayam'     : Gagal");
        }
        if (c3) {
            System.out.println("Tambah 'Es Teh Manis' : Berhasil");
        } else {
            System.out.println("Tambah 'Es Teh Manis' : Gagal");
        }
        System.out.println();

        // ===================== READ ALL =====================
        System.out.println("===== TEST READ ALL =====");
        for (domainMenu m : model.readAll()) {
            String tersedia;
            if (m.tersedia) {
                tersedia = "Ya";
            } else {
                tersedia = "Tidak";
            }
            String tglUpdate;
            if (m.tanggalUpdate != null) {
                tglUpdate = m.tanggalUpdate;
            } else {
                tglUpdate = "-";
            }
            System.out.println(m.idMenu + " | " + m.namaMenu + " | " + m.hargaMenu
                    + " | " + tersedia + " | " + m.tanggalCreate + " | " + tglUpdate);
        }
        System.out.println();

        // ===================== READ BY ID =====================
        System.out.println("===== TEST READ BY ID =====");
        int idx1 = model.readById(2);
        if (idx1 != -1) {
            System.out.println("readById(2)  -> index = " + idx1 + " | Menu: " + model.DB_menu.get(idx1).namaMenu);
        } else {
            System.out.println("readById(2)  -> index = " + idx1 + " (tidak ditemukan)");
        }
        int idx99 = model.readById(99);
        if (idx99 != -1) {
            System.out.println("readById(99) -> index = " + idx99 + " | Menu: " + model.DB_menu.get(idx99).namaMenu);
        } else {
            System.out.println("readById(99) -> index = " + idx99 + " (tidak ditemukan)");
        }
        System.out.println();

        // ===================== UPDATE =====================
        System.out.println("===== TEST UPDATE =====");
        boolean u1 = model.update(2, "Mie Bakso", 13000, true);
        boolean u2 = model.update(99, "Tidak Ada", 0, false);
        if (u1) {
            System.out.println("Update ID 2 (Mie Ayam -> Mie Bakso) : Berhasil");
        } else {
            System.out.println("Update ID 2 (Mie Ayam -> Mie Bakso) : Gagal");
        }
        if (u2) {
            System.out.println("Update ID 99 (tidak ada)             : Berhasil");
        } else {
            System.out.println("Update ID 99 (tidak ada)             : Gagal");
        }
        System.out.println();
        System.out.println("Data setelah update:");
        for (domainMenu m : model.readAll()) {
            String tersedia;
            if (m.tersedia) {
                tersedia = "Ya";
            } else {
                tersedia = "Tidak";
            }
            String tglUpdate;
            if (m.tanggalUpdate != null) {
                tglUpdate = m.tanggalUpdate;
            } else {
                tglUpdate = "-";
            }
            System.out.println(m.idMenu + " | " + m.namaMenu + " | " + m.hargaMenu
                    + " | " + tersedia + " | " + m.tanggalCreate + " | " + tglUpdate);
        }
        System.out.println();

        // ===================== DELETE =====================
        System.out.println("===== TEST DELETE =====");
        boolean d1 = model.delete(1);
        boolean d2 = model.delete(99);
        if (d1) {
            System.out.println("Delete ID 1  : Berhasil");
        } else {
            System.out.println("Delete ID 1  : Gagal");
        }
        if (d2) {
            System.out.println("Delete ID 99 : Berhasil");
        } else {
            System.out.println("Delete ID 99 : Gagal");
        }
        System.out.println();
        System.out.println("Data setelah delete:");
        for (domainMenu m : model.readAll()) {
            String tersedia;
            if (m.tersedia) {
                tersedia = "Ya";
            } else {
                tersedia = "Tidak";
            }
            String tglUpdate;
            if (m.tanggalUpdate != null) {
                tglUpdate = m.tanggalUpdate;
            } else {
                tglUpdate = "-";
            }
            System.out.println(m.idMenu + " | " + m.namaMenu + " | " + m.hargaMenu
                    + " | " + tersedia + " | " + m.tanggalCreate + " | " + tglUpdate);
        }
    }
}
