package pages;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import selectors.DigitalDownloadsPageSelectors;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class DigitalDownloadsPage extends BasePage {
    private final Locator digitalDownloadsOptions;

    public DigitalDownloadsPage(Page page) {
        super(page);
        this.digitalDownloadsOptions = page.locator(DigitalDownloadsPageSelectors.DOWNLOAD_OPTION_LIST);
    }

    public void addItemToCart(Locator itemLocator) {
        itemLocator.locator(DigitalDownloadsPageSelectors.ADD_ITEM_TO_CART).click();
    }

    public Locator getRandomBuyOption() {
        int numOfOptions = this.digitalDownloadsOptions.count();
        assertTrue(numOfOptions > 0, "No buy options found");
        int randomIndex = (int) Math.floor(Math.random() * numOfOptions);
        return this.digitalDownloadsOptions.nth(randomIndex);
    }

    public String getItemName(Locator itemLocator) {
        return itemLocator.locator(DigitalDownloadsPageSelectors.ITEM_NAME).innerText();
    }


}