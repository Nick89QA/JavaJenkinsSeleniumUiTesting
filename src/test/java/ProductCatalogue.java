
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class ProductCatalogue {



    @FindBy(css = ".mb-3")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By productsBy = By.cssSelector(".mb-3");
    By addToCart = By.cssSelector(".card-body button:  last-of-type");
    By toastMessage = By.cssSelector(("#toast-container"));

//    public List<WebElement> getProductList() {
//        waitForElementToAppear(productsBy);
//        return products;
//    }

    public WebElement getProductByName(String productName) {
        WebElement prod = products.stream().filter(product -> product.
                findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public void addProductToCart(String productName) {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
//        waitForElementToAppear(toastMessage);
//        waitForElementToDisappear(spinner);
    }


}
