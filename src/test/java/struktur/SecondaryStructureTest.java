package struktur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SecondaryStructureTest {

    private CustomStack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new CustomStack<>();
    }

    // Skenario 5: Verifikasi filter provenance manual & konsistensi data[cite: 1, 7]
    @Test
    @DisplayName("Test Skenario 5: Validasi Invariant elemen data stack")
    void testProvenanceAndInvariantValidation() {
        stack.push("P026");
        stack.push("P027");
        assertTrue(stack.validateInvariant());
        assertEquals(2, stack.size());
    }

    // Skenario 6: Stack non-destruktif search[cite: 1, 6, 7]
    @Test
    @DisplayName("Test Skenario 6: Pencarian Stack bersifat non-destruktif")
    void testSearchPreserveDoesNotAlterStackOrder() {
        stack.push("Putusan 26");
        stack.push("Putusan 27");
        stack.push("Putusan 28");

        boolean found = stack.searchPreserve("Putusan 27");

        assertTrue(found, "Data harusnya ditemukan.");
        assertEquals(3, stack.size(), "Ukuran stack tidak boleh berubah.");
        assertEquals("Putusan 28", stack.pop(), "Elemen teratas harus tetap Putusan 28.");
        assertEquals("Putusan 27", stack.pop());
        assertEquals("Putusan 26", stack.pop());
        assertTrue(stack.validateInvariant());
    }

    // Skenario 7: Error handling data tidak valid[cite: 1, 7]
    @Test
    @DisplayName("Test Skenario 7: Input null melempar exception dan menjaga konsistensi")
    void testInvalidInputThrowsException() {
        stack.push("Putusan Valid");

        assertThrows(IllegalArgumentException.class, () -> {
            stack.push(null);
        }, "Memasukkan null harus melempar IllegalArgumentException");

        assertEquals(1, stack.size(), "Size harus tetap 1 setelah error.");
        assertEquals("Putusan Valid", stack.peek());
        assertTrue(stack.validateInvariant(), "Invariant harus tetap valid.");
    }
}