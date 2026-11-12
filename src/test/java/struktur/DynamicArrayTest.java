package struktur;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DynamicArrayTest {

    @Test
    void testAddResizeDanGet() {
        DynamicArray<String> arr = new DynamicArray<>(2);
        assertTrue(arr.isEmpty());

        arr.add("PUT-001");
        arr.add("PUT-002");
        arr.add("PUT-003"); // Memicu resize() otomatis

        assertEquals(3, arr.size());
        assertFalse(arr.isEmpty());
        assertEquals("PUT-001", arr.get(0));
        assertEquals("PUT-002", arr.get(1));
        assertEquals("PUT-003", arr.get(2));
        arr.validateInvariant();
    }

    @Test
    void testInsertDanSet() {
        DynamicArray<String> arr = new DynamicArray<>(2);
        arr.add("A");
        arr.add("C");
        arr.insert(1, "B"); // Menyisipkan di tengah
        arr.insert(3, "D"); // Menyisipkan di akhir + memicu resize

        assertEquals(4, arr.size());
        assertEquals("B", arr.get(1));
        assertEquals("D", arr.get(3));

        String lama = arr.set(1, "B-BARU");
        assertEquals("B", lama);
        assertEquals("B-BARU", arr.get(1));
        arr.validateInvariant();
    }

    @Test
    void testRemoveSearchDanClear() {
        DynamicArray<String> arr = new DynamicArray<>();
        arr.add("Sabu");
        arr.add("Ganja");
        arr.add("Ekstasi");

        assertEquals(1, arr.search("Ganja"));
        assertEquals(-1, arr.search("Heroin"));
        assertTrue(arr.contains("Sabu"));

        String dihapus = arr.remove(1);
        assertEquals("Ganja", dihapus);
        assertEquals(2, arr.size());
        assertEquals("Ekstasi", arr.get(1));
        assertFalse(arr.contains("Ganja"));
        arr.validateInvariant();

        arr.clear();
        assertEquals(0, arr.size());
        assertTrue(arr.isEmpty());
        arr.validateInvariant();
    }

    @Test
    void testKasusBatasException() {
        assertThrows(IllegalArgumentException.class, () -> new DynamicArray<>(0));
        assertThrows(IllegalArgumentException.class, () -> new DynamicArray<>(-5));

        DynamicArray<Integer> arr = new DynamicArray<>(2);
        assertThrows(IndexOutOfBoundsException.class, () -> arr.remove(0)); // Hapus saat kosong
        assertThrows(IndexOutOfBoundsException.class, () -> arr.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.set(0, 99));
        assertThrows(IndexOutOfBoundsException.class, () -> arr.insert(1, 10));
    }
}