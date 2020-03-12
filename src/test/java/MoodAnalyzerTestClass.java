import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTestClass {

    @Test
    public void givenMeassage_WhenValid_ThenReturnMood() {
        MoodAnalyzer mood=new MoodAnalyzer("I am in sad mood");
        String reaction=mood.moodAnalyzer("");
        Assert.assertEquals("sad", reaction);
    }
    //TEST CASE TO CHECK HAPPY MOOD
    @Test
    public void givenMeassage_WhenInvalid_ThenReturnMood() {
        MoodAnalyzer mood=new MoodAnalyzer("I am in happy mood");
        String reaction=mood.moodAnalyzer("");
        Assert.assertEquals("happy",reaction);
    }
}
