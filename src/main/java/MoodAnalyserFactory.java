import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    // Return class object
    public static Constructor<?> getConstructor(String className,Class methodName) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            return moodAnalyzer.getConstructor(methodName);
        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class neme");
        } catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method neme");
        }
    }
    // Return constructor instance
    public static MoodAnalyzer createMoodAnalyzer() throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName("MoodAnalyzer");
            Constructor<?> moodConstructor = moodAnalyzer.getConstructor();
            Object instance = moodConstructor.newInstance();
            return (MoodAnalyzer) instance;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class neme");
        }
        return null;
    }
}

