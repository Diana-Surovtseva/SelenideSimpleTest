package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public LoginPage() {
    }

    public void navigateTo() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        open("https://jira.hillel.it/secure/Dashboard.jspa");
    }

    public void enterUserName() {
        $(("#login-form-username")).setValue("webinar5");
    }

    public void setUserPassInput() {
        $(("#login-form-password")).setValue("webinar5");
    }

    public void clickLogBut() {
        $("#login").click();
    }

}