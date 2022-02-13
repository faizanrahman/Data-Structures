public class Main {

    public static void main(String[] args) {
	// write your code here
        var list = new LinkedList();

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);

        list.removeLast();

        System.out.println(list.contains(30));
    }
}
