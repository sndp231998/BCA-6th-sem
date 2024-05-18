import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.util.Arrays;

public class DublicateBuffer {
    public static void main(String[] args) {

        try {
            ByteBuffer bb1 = ByteBuffer.allocate(10);
            bb1.put((byte) 10);
            bb1.put((byte) 20);
            bb1.put((byte) 30);
            bb1.rewind();
           byte[] arr=bb1.array();
            System.out.println("Original ByteBuffer: " + Arrays.toString(arr));

            // Duplicate
            ByteBuffer bb2 = bb1.duplicate();

            // Printing duplicate copy of bytebuffer
            System.out.println("Duplicate: " + Arrays.toString(bb2.array()));

        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
        } catch (ReadOnlyBufferException e) {
            System.out.println(e);
        }
    }
}
