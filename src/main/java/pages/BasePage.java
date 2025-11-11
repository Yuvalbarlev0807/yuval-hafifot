package pages;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;

public abstract class BasePage {

    protected final Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public Response  gotoUrl(String url) {
        return page.navigate(url);
    }

    public void click( String locator){
        this.page.locator(locator).click();
    }

    public void fillTextField(String locator, String text){
        this.page.locator(locator).fill(text);
    }

}
