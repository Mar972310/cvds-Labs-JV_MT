package hangman.model;

import hangman.model.Implementation.BonusScore;
import hangman.model.Implementation.OriginalScore;
import hangman.model.Implementation.PowerScore;
import org.junit.Assert;
import org.junit.Test;

public class GameScoreTest{

    @Test
    public void checkPositiveScore() {
        int expected = 100;
        OriginalScore score = new OriginalScore();
        int result = score.calculateScore(10,0);
        Assert.assertEquals(result, expected);

    }
    @Test
    public void checkIncorrectEntriesGreaterThanTen() {
        int expected = 0;
        OriginalScore score = new OriginalScore();
        int result = score.calculateScore(7,12);
        Assert.assertEquals(result, expected);
    }
    @Test
    public void verifyScoreIncorrectEntriesLessThanDoubleTheCorrectEntries() {
        int expected = 10;
        BonusScore score = new BonusScore();
        int result = score.calculateScore(7,12);
        Assert.assertEquals(result, expected);
    }
    @Test
    public void verifyMinimunScore() {
        int expected = 0;
        BonusScore score = new BonusScore();
        int result = score.calculateScore(5,10);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void givenPowerScoreShouldNotDoAnythingWhenScoreIsBetween1And500() {
        // Arrange
        PowerScore score = new PowerScore();
        int expected = 155;
        // Act
        int actual = score.calculateScore(3, 0);
        // Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void givenPowerScoreShouldBe500WhenScoreIsMoreThan500() {
        PowerScore score = new PowerScore();
        int expected = 500;
        int actual = score.calculateScore(6, 0);
        Assert.assertEquals(expected, actual);
    }
}

