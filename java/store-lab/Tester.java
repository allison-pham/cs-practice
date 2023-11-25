public class Tester {
    public static void main (String[] args) {
        Store insert = new Store("file50.txt");
        System.out.println("Database before sorted: ");
        System.out.println();
        insert.displayStore();
        insert.doSort();
        System.out.println();
        System.out.println("Database after sorted by id: ");
        System.out.println();
        insert.displayStore();
    }
}