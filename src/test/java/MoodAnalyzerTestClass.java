import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTestClass {

    @Test
    public void givenMeassage_WhenValid_ThenReturnMood() throws MoodAnalysisException {
        MoodAnalyzer mood=new MoodAnalyzer("I am in sad mood");
        String reaction=mood.moodAnalyzer("");
        Assert.assertEquals("sad", reaction);
    }
    @Test
    public void givenMeassage_WhenInvalid_ThenReturnMood() throws MoodAnalysisException {
        MoodAnalyzer mood=new MoodAnalyzer("I am in happy mood");
        String reaction=mood.moodAnalyzer("");
        Assert.assertEquals("happy",reaction);
    }
    @Test
    public void givenNull_WhenInvalid_ThenReturn()  {
        MoodAnalyzer mood=new MoodAnalyzer(null);
        try {
            String reaction=mood.moodAnalyzer("");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NULL,e.type);
        }
    }
    @Test
    public void givenEmpty_WhenInvalid_ThenTrue()  {
        MoodAnalyzer mood=new MoodAnalyzer("");
        try {
            String reaction=mood.moodAnalyzer("");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.EMPTY,e.type);
        }
    }
}
