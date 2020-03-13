import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

    // Return message
    public static String moodAnalyzer(MoodAnalyzer message,String methodName) throws MoodAnalysisException {
        try {
            return (String)message.getClass().getMethod(methodName).invoke(message);
        } catch (Exception e) {
            //throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method neme");
        }
        return null;
    }
    // Return class object when class name improper with parameter
    public static Object getClassNameImproperWithParameter(String className,Class methodName,String mood) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            Constructor<?> construct = moodAnalyzer.getConstructor(methodName);
            return construct.newInstance(mood);
        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class neme");
        } catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method neme");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return(mood);
    }
    // Return class object with parameter constructor
    public static Object getParameterizConstructor(String className,Class methodName,String mood) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            Constructor<?> constructorMood = moodAnalyzer.getConstructor(methodName);
            return constructorMood.newInstance(mood);
        } catch (ClassNotFoundException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.CLASS_NOT_FOUND,"Please enter valid Class neme");
        } catch (NoSuchMethodException e){
            throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.METHOD_NOT_FOUND,"Please enter valid method neme");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return (mood);
    }
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

