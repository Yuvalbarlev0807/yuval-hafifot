package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import selectors.ShoppingCartSelectors;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(Page page) {
        super(page);
    }

    public Locator getCartItemLocator() {
        return this.page.locator(ShoppingCartSelectors.ITEM_NAME);
    }

    public void removeAllItems() {
        Locator removeItemSelector = page.locator(ShoppingCartSelectors.REMOVE_ITEM);
        if (removeItemSelector.count() == 0) return;
        removeItemSelector.check();

        page.locator(ShoppingCartSelectors.UPDATE_CART).click();

        assertThat(page.getByText("your shopping cart is empty")).isVisible();
        assertThat(removeItemSelector).hasCount(0);
    }
}