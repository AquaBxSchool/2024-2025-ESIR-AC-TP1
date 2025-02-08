public class StackSizeTest {
    public static void recursiveMethod(int depth) {
        // Appel récursif pour mesurer la profondeur de la pile
        System.out.println("Current depth: " + depth);
        recursiveMethod(depth + 1);
    }

    public static void main(String[] args) {
        try {
            recursiveMethod(1);
        } catch (StackOverflowError e) {
            System.out.println("Stack overflow at depth: " + (e.getMessage() != null ? e.getMessage() : "unknown depth"));
        }
    }
}
