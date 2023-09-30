package checkersgame.pages;

import checkersgame.base.Base;
import checkersgame.base.PageUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageUrl(extention = "/checkers/")
public class CheckerGameHomePage extends Base {

    @FindBy(linkText = "Restart...")
    public WebElement restartLink;

    @FindBy(id = "message")
    public WebElement selectAnOrangePieceToMove;



    @FindBy(css = "[class='line']")
    public List<WebElement> rows;


    public void checkNewGameStarted(){
        //Select an orange piece to move.

    }

    public void clickRestartLink() {
        if(restartLink.isDisplayed()){
            restartLink.click();
        }
    }

    public void isMakeAMovePresent(){

    }

    public void makeFiveLegalMoveOrange(){

    }

   public CheckerGameHomePage(WebDriver driver){
        super(driver);
    }

}
