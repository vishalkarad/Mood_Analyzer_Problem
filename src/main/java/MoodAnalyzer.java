public class MoodAnalyzer {
    public static void main(String[] args) {
        System.out.println("***************Welcome To Mood Analyzer***************");
    }
    // Method that return the mood
    public String moodAnalyzer(String mood) {
        if (mood.equals("I am in sad mood")) {
            return ("sad");
        } else if (mood.equals("I am in any mood")) {
            return ("happy");
        }
        return (mood);
    }
}
