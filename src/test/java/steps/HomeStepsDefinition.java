package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class HomeStepsDefinition {

    public static WebDriver driver;

    @Given("I navigate to the HomePage")
    public void iNavigateToTheHomePage() {
       ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.add_argument("--no-sandbox");
        chromeOptions.add_argument("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get("http://localhost:8081/");
    }

    @When("Navigate to Products Customer Page")
    public void navigateToProductsCustomerPage() throws InterruptedException {
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[text()='Catalogue Customer']")).click();
    }

    @When("Navigate to Products Manager Page")
    public void navigate_to_products_manager_page() {
        driver.findElement(By.xpath("//a[text()='Catalogue Manager']")).click();
    }

    @Then("I should see {int} Products to Edit")
    public void i_should_see_products_to_edit(int numberOfProducts) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElements(By.xpath("//a[text()='Edit']")).size(),numberOfProducts);
        driver.quit();
    }

    @And("Create a new Product")
    public void createANewProduct() {
        driver.findElement(By.xpath("//button[text()='Create']")).click();
        driver.findElement(By.id("name")).sendKeys("Fahrenheit 451");
        driver.findElement(By.id("author")).sendKeys("Ray Bradbury");
        driver.findElement(By.id("description")).sendKeys("Guy Montag is a fireman. His job is to burn books, which are forbidden, being the source of all discord and unhappiness.");
        driver.findElement(By.id("price")).sendKeys("12");
        driver.findElement(By.id("imagePath")).sendKeys("https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1469704347i/17470674.jpg");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

    @Then("I should see the new Product")
    public void iShouldSeeTheNewProduct() {
        Assert.assertEquals(driver.findElements(By.xpath("//a[text()='Edit']")).size(),5);
        Assert.assertEquals(driver.findElements(By.xpath("//h5[text()='Fahrenheit 451']")).size(),1);
        driver.quit();
    }

    @And("Edit a created a Product")
    public void editACreatedAProduct() {

        driver.findElement(By.xpath("/html/body/div/div/div[last()]/div/a[1]")).click();
        driver.findElement(By.id("price")).clear();
        driver.findElement(By.id("price")).sendKeys("34");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

    @Then("I should see the new information of the new Product")
    public void iShouldSeeTheNewInformationOfTheNewProduct() {
        Assert.assertEquals(driver.findElements(By.xpath("//p[text()='34.0']")).size(),1);
        driver.quit();
    }

    @And("Delete a created a Product")
    public void deleteACreatedAProduct() {
        driver.findElement(By.xpath("/html/body/div/div/div[last()]/div/a[2]")).click();

    }

    @Then("I shouldn't the new information of the new Product")
    public void iShouldnTTheNewInformationOfTheNewProduct() {

        Assert.assertEquals(driver.findElements(By.xpath("//a[text()='Edit']")).size(),4);
        Assert.assertEquals(driver.findElements(By.xpath("//p[text()='34.0']")).size(),0);
        driver.quit();
    }

    @And("Book a product")
    public void bookAProduct() {
        driver.findElement(By.xpath("//a[@href='/newBooking/2']")).click();
        driver.findElement(By.id("deliveryDate")).sendKeys("26/12/2024");
        driver.findElement(By.id("deliveryTime")).sendKeys("13:37");
        driver.findElement(By.id("deliveryAddress")).sendKeys("Avenue 57");
        driver.findElement(By.xpath("//button[text()='Save']")).click();

    }

    @Then("I should see the new User Booking")
    public void iShouldSeeTheNewUserBooking() {
        boolean isGreater = false;
        if(driver.findElements(By.xpath("//a[text()='Edit']")).size() >= 4)
            isGreater= true;
        Assert.assertTrue( isGreater);

        driver.quit();
    }

    @Then("I should see {int} Products to Book")
    public void i_should_see_products_to_book(int numberOfProducts) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElements(By.xpath("//a[text()='Book']")).size(),numberOfProducts);
        driver.quit();
    }

    @When("Navigate to Booking Customer Page")
    public void navigateToBookingCustomerPage() {
        driver.findElement(By.xpath("//a[text()='Booking Customer']")).click();
    }

    @Then("I should see {int} Bookings to Book")
    public void iShouldSeeBookingsToBook(int numberOfBookings) {

        boolean isGreater = false;
        if(numberOfBookings >= 4)
            isGreater= true;
        Assert.assertTrue( isGreater);
        driver.quit();

    }

    @And("Edit a created a Booking of a product")
    public void editACreatedABookingOfAProduct() {
        driver.findElement(By.xpath("//a[@href='/editBooking/3']")).click();
        driver.findElement(By.id("deliveryAddress")).clear();
        driver.findElement(By.id("deliveryAddress")).sendKeys("avenue 78");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

    @Then("I should see the new information of the Booking")
    public void iShouldSeeTheNewInformationOfTheBooking() {
        Assert.assertEquals(driver.findElements(By.xpath("//p[text()='avenue 78']")).size(),1);
        driver.quit();
    }


    @And("Cancel the created Booking of a product")
    public void cancelTheCreatedBookingIfAproduct() {
        driver.findElement(By.xpath("//a[@href='/updateStatusBooking/3/4']")).click();
    }

    @Then("I should see the new status of the Booking")
    public void iShouldSeeTheNewStatusOfTheBooking() {
        boolean isGreater = false;
        if(driver.findElements(By.xpath("//a[text()='Edit']")).size() >= 4)
            isGreater= true;
        Assert.assertTrue( isGreater);
        driver.quit();
    }

    @When("Navigate to Booking Manager Page")
    public void navigateToBookingManagerPage() {
        driver.findElement(By.xpath("//a[text()='Booking Manager']")).click();

    }

    @Then("I should see {int} Bookings to Edit")
    public void iShouldSeeBookingsToEdit(int numberOfBookings) {
        boolean isGreater = false;
        if(numberOfBookings >= 4)
            isGreater= true;
        Assert.assertTrue( isGreater);
        driver.quit();
    }
    @And("Approve a Booking")
    public void approveABooking() {
        driver.findElement(By.xpath("//a[@href='/updateStatusBooking/1/3']")).click();
    }

    @And("Reject a Booking")
    public void rejectABooking() {
        driver.findElement(By.xpath("//a[@href='/updateStatusBooking/1/2']")).click();
    }
    @And("Close a Booking")
    public void closeABooking() {
        driver.findElement(By.xpath("//a[@href='/updateStatusBooking/1/3']")).click();
    }

    @Then("I should see the approve Status of the booking")
    public void iShouldSeeTheApproveStatusOfTheBooking() {
            Assert.assertEquals(driver.findElements(By.xpath("//p[text()='APPROVED']")).size(),1);
            driver.quit();
    }

    @Then("I should see the reject Status of the booking")
    public void iShouldSeeTheRejectStatusOfTheBooking() {
        Assert.assertEquals(driver.findElements(By.xpath("//p[text()='REJECTED']")).size(),1);
        driver.quit();
    }

    @Then("I should see the close Status of the booking")
    public void iShouldSeeTheCloseStatusOfTheBooking() {
        Assert.assertEquals(driver.findElements(By.xpath("//p[text()='IN_DELIERY']")).size(),1);
        driver.quit();
    }

    @When("Navigate to User Page")
    public void navigate_to_user_page() {
        driver.findElement(By.xpath("//a[text()='Users']")).click();
    }
    @Then("I should see {int} Users")
    public void i_should_see_users(int numberOfUsers) {
        Assert.assertEquals(driver.findElements(By.xpath("//a[text()='Edit']")).size(),numberOfUsers);
        driver.quit();
    }

    @And("Create a new User")
    public void createANewUser() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Create']")).click();
        driver.findElement(By.id("name")).sendKeys("Paolo");
        driver.findElement(By.id("address")).sendKeys("Street 19");
        driver.findElement(By.id("email")).sendKeys("Paolo_Italy@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("3108888987");
        driver.findElement(By.id("login")).sendKeys("Paolo335");
        driver.findElement(By.id("password")).sendKeys("Test434");
        driver.findElement(By.xpath("//button[text()='Save']")).click();

    }

    @Then("I should see the new User")
    public void iShouldSeeTheNewUser() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElements(By.xpath("//a[text()='Edit']")).size(),4);
        Assert.assertEquals(driver.findElements(By.xpath("//td[text()='Paolo']")).size(),1);

        driver.quit();

    }

    @When("Edit a created User")
    public void edit_a_created_user() {
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr[last()]/td[6]/a[1]")).click();
        driver.findElement(By.id("address")).clear();
        driver.findElement(By.id("address")).sendKeys("avenue 46");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }
    @Then("I should the new information of the User")
    public void i_should_the_new_information_of_the_user() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElements(By.xpath("//td[text()='avenue 46']")).size(),1);
        Thread.sleep(1000);
        driver.quit();
    }

    @When("Delete the created User")
    public void delete_the_created_user() {
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr[last()]/td[6]/a[2]")).click();
    }
    @Then("I shouldn't the new information of the User")
    public void i_shouldn_t_the_new_information_of_the_user() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElements(By.xpath("//a[text()='Edit']")).size(),3);
        Assert.assertEquals(driver.findElements(By.xpath("//td[text()='Paolo']")).size(),0);
        driver.quit();
    }

    @When("Navigate to Store Page")
    public void navigate_to_store_page() {
        driver.findElement(By.xpath("//a[text()='Store']")).click();
    }
    @Then("I should see {int} Stores")
    public void i_should_see_stores(int numberOfStores) {
        Assert.assertEquals(driver.findElements(By.xpath("//a[text()='Edit']")).size(),numberOfStores);
        driver.quit();
    }


    @And("Create a Store")
    public void createAStore() {
        driver.findElement(By.xpath("//button[text()='Create']")).click();

        WebElement selectElement = driver.findElement(By.id("product.id"));
        Select select = new Select(selectElement);
        select.selectByValue("4");
        driver.findElement(By.id("avaibleQty")).sendKeys("24");
        driver.findElement(By.id("bookedQty")).sendKeys("2");
        driver.findElement(By.id("soldQty")).sendKeys("7");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

    @Then("I should see the new Store")
    public void iShouldSeeTheNewStore() {
        Assert.assertEquals(driver.findElements(By.xpath("//a[text()='Edit']")).size(),4);
        Assert.assertEquals(driver.findElements(By.xpath("//td[text()='To Kill a Mockingbird']")).size(),1);
        driver.quit();
    }

    @And("Edit a created  Store")
    public void editACreatedStore() {

        driver.findElement(By.xpath("/html/body/div/table/tbody/tr[last()]/td[7]/a[1]")).click();
        driver.findElement(By.id("bookedQty")).clear();
        driver.findElement(By.id("bookedQty")).sendKeys("54");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
    }

    @Then("I should the new information of Store")
    public void iShouldTheNewInformationOfStore() {
        Assert.assertEquals(driver.findElements(By.xpath("//td[text()='54']")).size(),1);
        driver.quit();
    }

    @And("Delete the created Store")
    public void deleteTheCreatedStore() {
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr[last()]/td[7]/a[2]")).click();
    }

    @Then("I shouldn't the new information of the created Store")
    public void iShouldnTTheNewInformationOfTheCreatedStore() {
        Assert.assertEquals(driver.findElements(By.xpath("//a[text()='Edit']")).size(),3);
        Assert.assertEquals(driver.findElements(By.xpath("//td[text()='To Kill a Mockingbird']")).size(),0);
        driver.quit();
    }



}
