package checkersgame.tests;

import checkersgame.base.PageUrl;
import checkersgame.pages.CheckerGameHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import checkersgame.base.ConfigProperties;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static utils.CheckersUtils.makeMove;
import static utils.CheckersUtils.restartGame;

public class CheckersGameTest extends BaseTest {

    CheckerGameHomePage checkerGameHomePage;
    WebDriverWait wait;
    @BeforeMethod
    public void setUp() {

//     	Here I'm navigating to our Checkers Game website
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        checkerGameHomePage = new CheckerGameHomePage(driver);
        checkerGameHomePage.go();
    }

    @Test
    public void checkWebsiteIsUp() {
        // Here I'm check if the Website is up and running
        // I'm checking current url and title but, we can leave either one depending on the story requirements.
        Assert.assertEquals(driver.getCurrentUrl(), ConfigProperties.getProperties("baseUrl") +
                        checkerGameHomePage.getClass().getAnnotation(PageUrl.class).extention(),
                "Checkers game webpage is down");
        Assert.assertEquals(driver.getTitle(), ConfigProperties.getProperties("pageTitle"),
                "Checkers game webpage is down");

    }

    @Test
    public void makeFiveLegalMovesWithOrange() throws InterruptedException {
//        This is a hardcoded version because of time constraints I was not able to fully automate.
//        But here are some things to improve:
//        1. Ideally I wanted to cover a check for legal moves, for e.g.
//            a. If the move is valid within the board
//            b. If there is an empty space to make a move
//            c. If there is an opponent piece that can be taken
//        2. Further it can be automated by creating an algorithm which:
//            a. Reads the board
//            b. Finds the best possible move
//            c. Tries to win the game.

        wait.until(ExpectedConditions.textToBe(By.id("message"),"Select an orange piece to move." ));
        makeMove(5,1, 4,0);
        wait.until(ExpectedConditions.textToBe(By.id("message"),"Make a move."));
        makeMove(5,3, 4,4);
        wait.until(ExpectedConditions.textToBe(By.id("message"),"Make a move."));
        makeMove(6,2, 4,4);
        wait.until(ExpectedConditions.textToBe(By.id("message"),"Make a move."));
        makeMove(7,1, 6,2);
        wait.until(ExpectedConditions.textToBe(By.id("message"),"Make a move."));
        makeMove(6,2, 5,1);
        restartGame();
        wait.until(ExpectedConditions.textToBe(By.id("message"),"Select an orange piece to move." ));


    }




}
