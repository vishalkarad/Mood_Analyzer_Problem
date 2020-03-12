import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTestClass {
    //CREATE OBJECT OF MOODANALYZER CLASS
    MoodAnalyzer mood=new MoodAnalyzer();

    @Test
    public void givenMeassage_WhenValid_ThenReturnMood() {
        String reaction=mood.moodAnalyzer("I am in sad mood");
        Assert.assertEquals("sad", reaction);
    }

    //TEST CASE TO CHECK HAPPY MOOD
    @Test
    public void givenMeassage_whenInvalid_thenReturnMood() {
        String reaction=mood.moodAnalyzer("I am in any mood");
        Assert.assertEquals("happy",reaction);
    }
}
