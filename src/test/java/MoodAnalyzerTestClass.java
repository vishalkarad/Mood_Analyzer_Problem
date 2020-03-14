import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerTestClass {

    @Test
    public void givenMeassage_WhenValid_ThenReturnMood() throws MoodAnalysisException {
        MoodAnalyzer mood=new MoodAnalyzer("I am in sad mood");
        String reaction=mood.moodAnalyzer();
        Assert.assertEquals("sad", reaction);
    }
    @Test
    public void givenMeassage_WhenInvalid_ThenReturnMood() throws MoodAnalysisException {
        MoodAnalyzer mood=new MoodAnalyzer("I am in happy mood");
        String reaction=mood.moodAnalyzer();
        Assert.assertEquals("happy",reaction);
    }
    @Test
    public void givenNull_WhenInvalid_ThenReturn()  {
        MoodAnalyzer mood=new MoodAnalyzer(null);
        try {
            String reaction=mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NULL,e.type);
        }
    }
    @Test
    public void givenEmpty_WhenInvalid_ThenTrue()  {
        MoodAnalyzer mood=new MoodAnalyzer("");
        try {
            String reaction=mood.moodAnalyzer();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.EMPTY,e.type);
        }
    }
    @Test
    public void givenMoodAnaliserDefaultCustructor_WhenProper_ThenReturnObject() {
        try{
            MoodAnalyzer mood = new MoodAnalyzer();
            MoodAnalyzer analyzemood = MoodAnalyserFactory.createMoodAnalyzer();
            boolean result = analyzemood.equals(mood);
            Assert.assertEquals(true,result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenClassName_WhenImproper_ThenThrowMoodAnalysisException() {
        try{
            MoodAnalyzer mood = new MoodAnalyzer();
         MoodAnalyserFactory.getConstructor("MoodAnalyze",String.class);
        }catch(MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,e.type);
        }
    }
    @Test
    public void givenConstructorName_WhenImproper_ThenThrowMoodAnalysisException() {
        try{
            MoodAnalyzer mood = new MoodAnalyzer();
            MoodAnalyserFactory.getConstructor("MoodAnalyzer",Integer.class);
        }catch(MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,e.type);
        }
    }
    @Test
    public void givenMoodAnaliserParameterCustructor_WhenProper_ThenReturnObject() {
        try{
            MoodAnalyzer mood = new MoodAnalyzer("i am in happy mood");
            Object returnMood=MoodAnalyserFactory.getParameterizConstructor("MoodAnalyzer",String.class,"i am in happy mood");
            boolean result = returnMood.equals(mood);
            Assert.assertEquals(true,result);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void givenClassNameWithParameter_WhenImproper_ThenThrowMoodAnalysisException() {
        try{
            MoodAnalyzer mood = new MoodAnalyzer("i am in happy mood");
            Object returnMood=MoodAnalyserFactory.getClassNameImproperWithParameter("MoodAnalyze",String.class,"i am in happy mood");
            boolean result=returnMood.equals(mood);
            Assert.assertEquals(true,result);
        }catch(MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,e.type);
        }
    }
    @Test
    public void givenConstructorWithParameter_WhenImproper_ThenThrowMethodNotFoundException() {
        try{
            MoodAnalyzer mood = new MoodAnalyzer("i am in happy mood");
            Object returnMood=MoodAnalyserFactory.getParameterizConstructor("MoodAnalyzer",Integer.class,"i am in happy mood");
            boolean result = returnMood.equals(mood);
        }catch(MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,e.type);
        }
    }
    @Test
    public void givenHappy_WhenProper_ThenReturnHappyMood() throws MoodAnalysisException {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer",String.class);
            Object instance = constructor.newInstance("i am in happy mood");
            String analyser = MoodAnalyserFactory.moodAnalyzer ( (MoodAnalyzer) instance ,"moodAnalyzer") ;
            Assert.assertEquals("happy",analyser);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenHappyMessage_WhenImproperMethod_ShouldThrowMoodAnalysisException() {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer",Integer.class);
            Object instance = constructor.newInstance("i am in happy mood");
            String analyser = MoodAnalyserFactory.moodAnalyzer ( (MoodAnalyzer) instance ,"moodAnalyzer") ;
            Assert.assertEquals("happy",analyser);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,e.type);
        }
    }
    @Test
    public void givenSetHappyMessageWithReflector_ShouldReturnHAPPY() throws MoodAnalysisException {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer",String.class);
            MoodAnalyzer moodAnalyze = MoodAnalyserFactory.createMoodAnalyzer();
            MoodAnalyserFactory.setFieldMoodAnalyser(moodAnalyze,"message","i am in happy mood");
            String analyser = MoodAnalyserFactory.moodAnalyzer ( (MoodAnalyzer)moodAnalyze ,"moodAnalyzer") ;
            Assert.assertEquals("happy",analyser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenSetField_WhenImproper_ThenThrowException() throws MoodAnalysisException {
        try {
            Constructor<?> constructor = MoodAnalyserFactory.getConstructor("MoodAnalyzer",String.class);
            MoodAnalyzer moodAnalyze = MoodAnalyserFactory.createMoodAnalyzer();
            MoodAnalyserFactory.setFieldMoodAnalyser(moodAnalyze,"messa","i am in happy mood");
            String analyser = MoodAnalyserFactory.moodAnalyzer ( (MoodAnalyzer)moodAnalyze ,"moodAnalyzer") ;
            //System.out.println("  analyser"+analyser);
            Assert.assertEquals("null",analyser);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.MyException_Type.NO_SUCH_FIELD,e.type);
        }
    }
}


