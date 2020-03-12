import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTestClass {

    @Test
    public void givenMeassage_WhenValid_ThenReturnMood() {
        MoodAnalyzer mood=new MoodAnalyzer("I am in sad mood");
        String reaction=mood.moodAnalyzer("");
        Assert.assertEquals("sad", reaction);
    }
    @Test
    public void givenMeassage_WhenInvalid_ThenReturnMood() {
        MoodAnalyzer mood=new MoodAnalyzer("I am in happy mood");
        String reaction=mood.moodAnalyzer("");
        Assert.assertEquals("happy",reaction);
    }
    @Test
    public void givenNull_WhenInvalid_ThenReturnHappy() {
        MoodAnalyzer mood=new MoodAnalyzer();
        String reaction=mood.moodAnalyzer("");
        Assert.assertEquals("happy",reaction);
    }
}
