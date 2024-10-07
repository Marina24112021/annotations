package components;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OutPutResult {
    public void checkListIsNotEmpty(){
        $$("div [class='post post--small']").shouldBe(sizeGreaterThan(0));
    }
    public void shouldCorrectSearch(String outputStr){
        $("#ajax-load-more").$("div .post__title").shouldHave(text(outputStr));
    }
    public void ShouldDisplayCorrectArticle(String value){
        //$("#ajax-load-more").
        $("div .post__title").shouldHave(text(value));
    }
}
