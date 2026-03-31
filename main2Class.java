public class main2Class {
    public static void main(String[] args) {
        viewMenu view = new viewMenu();
        modelMenu model = new modelMenu();
        model.insertStaticData();


        view.tampilSemuaMenu();
    }
}
