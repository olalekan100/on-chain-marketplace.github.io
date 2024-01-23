
import java.util.HashMap;
import java.util.Map;

class User {
    String userId;
    Map<String, Shop> shops;

    public User(String userId) {
        this.userId = userId;
        this.shops = new HashMap<>();
    }
}

class Item {
    String itemId;
    String name;
    double price;
    boolean isListed;

    public Item(String itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.isListed = true;
    }
}

class Shop {
    String shopId;
    User owner;
    Map<String, Item> items;

    public Shop(String shopId, User owner) {
        this.shopId = shopId;
        this.owner = owner;
        this.items = new HashMap<>();
    }

    public void addItem(Item item) {
        items.put(item.itemId, item);
    }

    public void unlistItem(String itemId) {
        if (items.containsKey(itemId)) {
            items.get(itemId).isListed = false;
        }
    }

    public boolean purchaseItem(String itemId, User buyer) {
        if (items.containsKey(itemId) && items.get(itemId).isListed) {
            // Assume some logic for handling the purchase
            // For example, deducting the price from the buyer's account and adding it to the shop owner's profit
            // Also, generating a purchased item receipt
            return true;
        }
        return false;
    }
}

public class OnChainMarketplace {
    public static void main(String[] args) {
        // Sample usage
        User seller = new User("seller123");
        Shop shop = new Shop("shop1", seller);

        Item item1 = new Item("item1", "Laptop", 999.99);
        Item item2 = new Item("item2", "Smartphone", 499.99);

        shop.addItem(item1);
        shop.addItem(item2);

        // Unlist an item
        shop.unlistItem("item1");

        // User purchases an item
        User buyer = new User("buyer456");
        if (shop.purchaseItem("item2", buyer)) {
            System.out.println("Item purchased successfully!");
        } else {
            System.out.println("Failed to purchase item.");
        }
    }
}
 

/*  This implementation provides a basic structure for the on-chain marketplace 
with the specified functionality.
One may need to integrate this with the actual Sui blockchain API and add additional 
features based on specific requirements.

 */
