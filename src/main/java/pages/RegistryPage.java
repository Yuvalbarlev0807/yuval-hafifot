package pages;
import com.microsoft.playwright.Page;
import fixtures.RegistryData;
import selectors.RegistryPageSelectors;
import com.microsoft.playwright.options.AriaRole;


public class RegistryPage extends BasePage {
    public RegistryPage(Page page) {
        super(page);
    }

    public void FillRegistryData(RegistryData registryData) {
        this.page.getByRole((AriaRole.RADIO),
                new Page.GetByRoleOptions().setName(registryData.gender().toString())).check();

        this.fillTextField(RegistryPageSelectors.FIRST_NAME, registryData.FirstName());
        this.fillTextField(RegistryPageSelectors.LAST_NAME, registryData.LastName());
        this.fillTextField(RegistryPageSelectors.EMAIL, registryData.email());
        this.fillTextField(RegistryPageSelectors.PASSWORD, registryData.password());
        this.fillTextField(RegistryPageSelectors.CONFIRM_PASSWORD, registryData.confirmPassword());
    }
}