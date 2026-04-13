public class Tester {
    public static void main(String[] args) {
        Word word1 = new Word("Earn");
        Word word2 = new Word("Near");

        System.out.println(word1.getSortedWord() + word2.getSortedWord());

        AnagramList list = new AnagramList();
        list.add(word1);
        list.add(word2);
        System.out.println(list.checkAnagram(word1, word2));
        System.out.println(list.searchAnagrams("aenr"));
    }
}
