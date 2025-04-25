package org.howard.edu.lspfinal.question1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class ShoppingCartTest {
    @Test
    @DisplayName("Test for adding valid item")
    public void testAddItem() {
        ShoppingCart shoppingCart = new ShoppingCart();


        shoppingCart.addItem("Apple", 1.0);
        assertEquals(1.0, shoppingCart.getTotalCost());
        assertEquals(1, shoppingCart.getCartSize());


        shoppingCart.addItem("Banana", 0.5);
        assertEquals(1.5, shoppingCart.getTotalCost());
        assertEquals(2, shoppingCart.getCartSize());
    }


    @Test
    @DisplayName("Test for adding item with 0 price (expect exception)")
    public void testAddItemWithZeroPrice() {
        ShoppingCart shoppingCart = new ShoppingCart();


        try {
            shoppingCart.addItem("Apple", 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Price cannot be negative or zero.", e.getMessage());
        }
    }


    @Test
    @DisplayName("Test for adding item with negative price (expect exception)")
    public void testAddItemWithNegativePrice() {
        ShoppingCart shoppingCart = new ShoppingCart();


        try {
            shoppingCart.addItem("Apple", -1.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Price cannot be negative or zero.", e.getMessage());
        }
    }


    @Test
    @DisplayName("Test case for add invalid items")
    public void testAddInvalidItem() {
        ShoppingCart shoppingCart = new ShoppingCart();


        try {
            shoppingCart.addItem(null, 1.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Item name cannot be null or empty.", e.getMessage());
        }


        try {
            shoppingCart.addItem("", 1.0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Item name cannot be null or empty.", e.getMessage());
        }


        assertEquals(0.0, shoppingCart.getTotalCost());
        assertEquals(0, shoppingCart.getCartSize());
    }


    @Test
    @DisplayName("Test for applying \"SAVE10\"")
    public void testApplySave10() {
        ShoppingCart shoppingCart = new ShoppingCart();


        shoppingCart.addItem("Apple", 5.0);
        shoppingCart.addItem("Banana", 5.0);


        shoppingCart.applyDiscountCode("SAVE10");
        assertEquals(9, shoppingCart.getTotalCost());
    }


    @Test
    @DisplayName("Test for applying \"SAVE20\"")
    public void testApplySave20() {
        ShoppingCart shoppingCart = new ShoppingCart();


        shoppingCart.addItem("Apple", 5.0);
        shoppingCart.addItem("Banana", 5.0);


        shoppingCart.applyDiscountCode("SAVE20");
        assertEquals(8, shoppingCart.getTotalCost());
    }


    @Test
    @DisplayName("Test for applying invalid code (expect exception) ")
    public void testApplyInvalidDiscountCode() {
        ShoppingCart shoppingCart = new ShoppingCart();


        shoppingCart.addItem("Apple", 5.0);
        shoppingCart.addItem("Banana", 5.0);


        try {
            shoppingCart.applyDiscountCode("INVALID_CODE");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid discount code.", e.getMessage());
        }
    }


    @Test
    @DisplayName("Test total cost without discount")
    public void testTotalCostWithoutDiscount() {
        ShoppingCart shoppingCart = new ShoppingCart();


        shoppingCart.addItem("Apple", 5.0);
        shoppingCart.addItem("Banana", 5.0);


        assertEquals(10, shoppingCart.getTotalCost());
    }


    @Test
    @DisplayName("Test total cost with discount")
    public void testTotalCostWithDiscount() {
        ShoppingCart shoppingCart = new ShoppingCart();


        shoppingCart.addItem("Apple", 5.0);
        shoppingCart.addItem("Banana", 5.0);


        shoppingCart.applyDiscountCode("SAVE10");
        assertEquals(9, shoppingCart.getTotalCost());


        shoppingCart.applyDiscountCode("SAVE20");
        assertEquals(8, shoppingCart.getTotalCost());
    }




    @Test
    @DisplayName("Test total cost with empty cart")
    public void testGetTotalCostEmptyCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertEquals(0, shoppingCart.getTotalCost());
        assertEquals(0, shoppingCart.getCartSize());
    }


    @Test
    @DisplayName("Test case for remove item")
    public void testRemoveItem() {
        ShoppingCart shoppingCart = new ShoppingCart();


        shoppingCart.addItem("Apple", 5.0);
        shoppingCart.addItem("Banana", 5.0);


        assertEquals(10, shoppingCart.getTotalCost());
        assertEquals(2, shoppingCart.getCartSize());


        shoppingCart.removeItem("Apple");
        assertEquals(5, shoppingCart.getTotalCost());
        assertEquals(1, shoppingCart.getCartSize());


        shoppingCart.removeItem("NonExistentItem");
        assertEquals(5, shoppingCart.getTotalCost());
        assertEquals(1, shoppingCart.getCartSize());
    }


    @Test
    @DisplayName("Test case for get discount percentage")
    public void testGetDiscountPercentage() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertEquals(0, shoppingCart.getDiscountPercentage());


        shoppingCart.applyDiscountCode("SAVE10");
        assertEquals(10, shoppingCart.getDiscountPercentage());


        shoppingCart.applyDiscountCode("SAVE20");
        assertEquals(20, shoppingCart.getDiscountPercentage());
    }


    @Test
    @DisplayName("Test case for get cart size")
    public void testGetCartSize() {
        ShoppingCart shoppingCart = new ShoppingCart();
        assertEquals(0, shoppingCart.getCartSize());


        shoppingCart.addItem("Apple", 5.0);
        shoppingCart.addItem("Banana", 5.0);


        assertEquals(2, shoppingCart.getCartSize());


        shoppingCart.removeItem("Apple");
        assertEquals(1, shoppingCart.getCartSize());


        shoppingCart.removeItem("NonExistentItem");
        assertEquals(1, shoppingCart.getCartSize());


        shoppingCart.removeItem("Banana");
        assertEquals(0, shoppingCart.getCartSize());
    }
}
