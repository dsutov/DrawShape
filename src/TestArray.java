public class TestArray {

    public static void main(String[] args) {
        String[] s = {"One", "Two", "Three", "Four"};

        int randomNum =  (int) (Math.random() * s.length);
        System.out.println("Random Output: " + s[randomNum]);
    }
}
