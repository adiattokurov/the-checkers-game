package utils;

import checkersgame.pages.CheckerGameHomePage;
import checkersgame.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckersUtils extends BaseTest {
    private static CheckerGameHomePage checkerGameHomePage;
    private static WebElement [][] initializeBoard() {
        checkerGameHomePage = new CheckerGameHomePage(driver);
        List<WebElement> rows = checkerGameHomePage.rows;

        WebElement[][] board = new WebElement[8][8];
        for (int col = 0; col<8; col++) {
            for (int row = 0; row < 8; row++) {
                if ((row + col) % 2 == 0 && row < 3) {
                       board[row][col] = rows.get(row).findElements(By.cssSelector("img")).get(col); // Black pieces
                } else if ((row + col) % 2 == 0 && row > 4) {
                        board[row][col] = rows.get(row).findElements(By.cssSelector("img")).get(col); // White pieces
                } else {
                        board[row][col] = rows.get(row).findElements(By.cssSelector("img")).get(col); // Empty squares
                    }
                }
            }
        return board;
    }

    public static void makeMove(int fromRow, int fromCol, int toRow, int toCol ) {
        WebElement[][] board = initializeBoard();
        if(isRightMove(fromRow,fromCol,toRow,toCol)){
            board[fromRow][fromCol].click();
            board[toRow][toCol].click();
        }else {
            System.out.println("Not a legal move");
        }
    }

    public static boolean isRightMove(int fromRow, int fromCol, int toRow, int toCol )  {

        WebElement[][] board = initializeBoard();

        if (toRow < 0 || toRow >= 8 || toCol < 0 || toCol >= 8) {
            return false;
        }
        // Check if the destination square is not valid
        if (board[toRow][toCol].getAttribute("src").startsWith("black")) {
            return false;
        }
        // Check if the destination square is blocked
        if (board[toRow][toCol].getAttribute("src").startsWith("grey")) {
            return true;
        }

     return true;
    }
    public static void restartGame(){
        checkerGameHomePage.restartLink.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.textToBe(By.id("message"),"Select an orange piece to move." ));
    }

}


