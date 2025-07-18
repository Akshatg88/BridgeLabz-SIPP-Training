public class LostAndFoundMain {
    public static void main(String[] args) {
        LostAndFoundSystem system = new LostAndFoundSystem();
        system.addItem("Bag", "Red Nike Backpack");
        system.addItem("Mobile", "Black Samsung Galaxy");
        system.addItem("Book", "Maths Textbook by R.D Sharma");
        system.addItem("Bag", "Blue Puma Bag");

        system.searchItem("Bag", "Nike");
        system.searchItem("Book", "science");
    }
}
