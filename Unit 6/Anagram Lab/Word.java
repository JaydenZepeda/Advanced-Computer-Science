public class Word {
    private String originalWord;
    private String sortedWord;

    public Word(String originalWord) {
        this.originalWord = originalWord;
        sortedWord = sortWord();
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public void setOriginalWord(String originalWord) {
        this.originalWord = originalWord;
    }

    public String getSortedWord() {
        return sortedWord;
    }

    public void setSortedWord(String sortedWord) {
        this.sortedWord = sortedWord;
    }

    public String sortWord() {
        char[] arr = (originalWord.toLowerCase()).toCharArray();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            char temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return new String(arr);
    }
}
