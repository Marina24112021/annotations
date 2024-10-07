package components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PageObjectMethod {
    public void opendMainPage(){
        open("/");
    }
    public void setValueToSearch(String value){
        $("#heading-search").click();
        $(".heading-search__input").setValue(value).pressEnter();
    }
    public void getListOfMenuButtons(String key){
        $$("ul#menu-header-menu-1 li").find(text(key)).click();
    }
}
