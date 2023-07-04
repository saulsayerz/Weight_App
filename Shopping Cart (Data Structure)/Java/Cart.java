import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<String, Integer> cartItems;

    public Cart() {
        cartItems = new HashMap<>();
    }

    public void tambahProduk(String kodeProduk, int kuantitas) {
        if (cartItems.containsKey(kodeProduk)) {
            int currentQuantity = cartItems.get(kodeProduk);
            cartItems.put(kodeProduk, currentQuantity + kuantitas);
        } else {
            cartItems.put(kodeProduk, kuantitas);
        }
    }

    public void hapusProduk(String kodeProduk) {
        cartItems.remove(kodeProduk);
    }

    public void tampilkanCart() {
        for (Map.Entry<String, Integer> entry : cartItems.entrySet()) {
            String kodeProduk = entry.getKey();
            int kuantitas = entry.getValue();
            System.out.println(kodeProduk + " (" + kuantitas + ")");
        }
    }
}
