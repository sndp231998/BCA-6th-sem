import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.util.Arrays;

public class SliceExample {
    public static void main(String[] args) {

        try {
            ByteBuffer bb1 = ByteBuffer.allocate(10);

            bb1.put((byte) 10);
            bb1.put((byte) 11);
            bb1.put((byte) 12);
            bb1.rewind();
            System.out.println("Original Data: " + Arrays.toString(bb1.array()));

            System.out.println("Position: " + bb1.position());
            System.out.println("Capacity: " + bb1.capacity());

            ByteBuffer bb2 = bb1.slice();
            System.out.println("Slice Data: " + Arrays.toString(bb2.array()));

            System.out.println("Position: " + bb2.position());
            System.out.println("Capacity: " + bb2.capacity());

        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        } catch (ReadOnlyBufferException e) {
            System.out.println(e);
        }
    }
}
