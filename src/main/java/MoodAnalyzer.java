import java.util.Objects;

class MoodAnalysisException extends Exception {
    enum MyException_Type{
        EMPTY,NULL,CLASS_NOT_FOUND,METHOD_NOT_FOUND;
    }
    MyException_Type type;
    MoodAnalysisException(MyException_Type type,String message) {
        super(message);
        this.type=type;
        System.out.println(message);
    }
}
public class MoodAnalyzer {
    private String message;
    public static void main(String[] args) {
        System.out.println("***************Welcome To Mood Analyzer***************");
        MoodAnalyzer moodAnalyzerObject=new MoodAnalyzer();
    }
    // Method that return the mood
    public String moodAnalyzer(String mood) throws MoodAnalysisException {
       try {
           if(message.length()==0){
               throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.EMPTY,"You entered empty,please enter valid mood");
           }
           if (message.contains("sad")) {
               return ("sad");
           } else if (message.contains("happy")) {
               return ("happy");
           }
       }catch (NullPointerException e){
           throw new MoodAnalysisException(MoodAnalysisException.MyException_Type.NULL,"You entered null,please enter valid mood");
       }
       return (mood);
    }
    // Default constructor
    public MoodAnalyzer() {
    }
    // Parameterized constructor
    public MoodAnalyzer(String message) {
        this.message=message;
    }
    // Check two object equals or not
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyzer that = (MoodAnalyzer) o;
        return Objects.equals(message, that.message);
    }
}
