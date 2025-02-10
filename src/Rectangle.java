import java.awt.*;
import java.util.*;
import java.util.List;

class BigRectangleFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle rect = (Rectangle) x;
            return (2 * (rect.width + rect.height)) > 10;
        }
        return false;
    }
}

class BigRectLister {
    public static void main(String[] args) {
        List<Rectangle> rectangles = Arrays.asList(
                new Rectangle(1, 1),
                new Rectangle(2, 2),
                new Rectangle(3, 2),
                new Rectangle(5, 1),
                new Rectangle(6, 2),
                new Rectangle(2, 5),
                new Rectangle(4, 4),
                new Rectangle(1, 1),
                new Rectangle(2, 3),
                new Rectangle(3, 3)
        );

        Filter filter = new BigRectangleFilter();
        System.out.println("Rectangles with perimeter > 10:");
        for (Rectangle rect : rectangles) {
            if (filter.accept(rect)) {
                System.out.println(rect);
            }
        }
    }
}
