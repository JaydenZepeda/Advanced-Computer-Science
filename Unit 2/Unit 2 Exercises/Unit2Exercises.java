public class Unit2Exercises {
    public static String alarmClock(int day, boolean vacation) {
        if (day > 0 && day < 6) {
            if (vacation) {
                return "10:00";
            } else if (vacation == false) {
                return "7:00";
            }
        }
        if (day == 0 || day == 6) {
            if (vacation) {
                return "off";
            }
            return "10:00";
        }
        return "error";
    }

    public static boolean love6(int a, int b) {
        if (a == 6 || b == 6 || a + b == 6 || Math.abs(a - b) == 6) {
            return true;
        }
        return false;
    }

    public static int redTicket(int a, int b, int c) {
        if (a == 2 && b == 2 && c == 2) {
            return 10;
        } else if (a == b && a == c) {
            return 5;
        } else if (a != c && a != b) {
            return 1;
        }
        return 0;
    }

    public static String fizzString(String str) {
        if (str.length() == 1) {
            if (str.charAt(0) == 'f') {
                return "Fizz";
            } else if (str.charAt(0) == 'b') {
                return "Buzz";
            }
        }
        if (str.length() == 0) {
            return str;
        }
        if (str.charAt(str.length() - 1) == 'b' && str.charAt(0) == 'f') {
            return "FizzBuzz";
        } else if (str.charAt(0) == 'f') {
            return "Fizz";
        } else if (str.charAt(str.length() - 1) == 'b') {
            return "Buzz";
        }
        return str;

    }

    public static String doubleChar(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            newStr += str.charAt(i);
            newStr += str.charAt(i);
        }
        return newStr;
    }

    public static int countHi(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf("hi") >= 0) {
                str = str.substring(str.indexOf("hi") + 2);
                count++;
            }
        }
        return count;
    }

    public static boolean catDog(String str) {
        String catStr = str;
        String dogStr = str;
        int dogCount = 0;
        int catCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (dogStr.indexOf("dog") >= 0) {
                dogStr = str.substring(dogStr.indexOf("dog") + 3);
                dogCount++;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            if (catStr.indexOf("cat") >= 0) {
                catStr = str.substring(catStr.indexOf("cat") + 3);
                catCount++;
            }
        }
        if (dogCount == catCount) {
            return true;
        }
        return false;
    }

    public static String mixString(String a, String b) {
        String newStr = "";
        int maxLength = Math.max(a.length(), b.length());
        for (int i = 0; i < maxLength; i++) {
            if (i < a.length()) {
                newStr += a.charAt(i);
            }
            if (i < b.length()) {
                newStr += b.charAt(i);
            }
        }
        return newStr;

    }

    public static String repeatEnd(String str, int n) {
        String newStr = "";
        for (int i = 0; i < n; i++) {
            newStr += str.substring(str.length() - n);
        }
        return newStr;
    }

    public static boolean endOther(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
        if (a.length() == 0 && b.length() == 0) {
            return true;
        } else if (a.length() == 0 || b.length() == 0) {
            return true;
        }
        if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
            return true;
        }
        return false;
    }

    public static int countCode(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf("co") >= 0) {
                if (str.charAt(str.indexOf("co") + 3) == 'e') {
                    str = str.substring(str.indexOf("co") + 2);
                    count++;
                }
            }
        }
        return count;
    }

    public static int countEvens(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int bigDiff(int[] nums) {
        int lowest = nums[0];
        int highest = nums[0];
        for (int i = 0; i < nums.length; i++) {
            highest = Math.max(nums[i], highest);
            lowest = Math.min(lowest, nums[i]);
        }
        return highest - lowest;
    }

    public static int sum13(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) {
                if (i == nums.length - 1) {
                    total += 0;
                } else {
                    total -= nums[i + 1];
                }
            } else {
                total += nums[i];
            }
        }
        return total;
    }

    public static int[] fizzArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static boolean haveThree(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                if (i != nums.length - 1) {
                    if (nums[i + 1] == 3) {
                        return false;
                    }

                }
                count++;
            }
        }
        if (count == 3) {
            return true;
        }
        return false;

    }

    public static String[] fizzArray2(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i);
        }
        return arr;
    }

    public static int[] zeroFront(int[] nums) {
        int[] arr = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                arr[count] = 0;
                count++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                arr[count] = nums[i];
                count++;
            }

        }
        return arr;
    }

    public static String[] wordsWithout(String[] words, String target) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] == target) {
                count++;
            }
        }
        String[] arr = new String[words.length - count];
        int arrCount = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i] != target) {
                arr[arrCount] = words[i];
                arrCount++;
            }
        }
        return arr;
    }

    public static int scoresAverage(int[] scores) {
        int fhalf = 0;
        int fcount = 0;
        for (int i = 0; i < scores.length / 2; i++) {
            fhalf += scores[i];
            fcount++;
        }
        int shalf = 0;
        int scount = 0;
        for (int i = 0; i < scores.length / 2; i++) {
            shalf += scores[i + (scores.length / 2)];
            scount++;
        }
        int favg = fhalf / fcount;
        int savg = shalf / scount;
        if (favg > savg) {
            return favg;
        }
        return savg;
    }

    public static boolean scoresIncreasing(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            if (i != 0) {
                if (scores[i] < scores[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int scoresSpecial(int[] a, int[] b) {
        int anum = 0;
        int bnum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 10 == 0) {
                if (a[i] > anum) {
                    anum = a[i];
                }
            }
        }
        for (int i = 0; i < b.length; i++) {
            if (b[i] % 10 == 0) {
                if (b[i] > bnum) {
                    bnum = b[i];
                }
            }
        }
        return anum + bnum;
    }

    public static String firstTwo(String str) {
        if (str.length() == 1) {
            return str + "*";
        }
        if (str.length() == 0) {
            return str + "**";
        }
        return str.substring(0, 2);
    }

    public static double divide(int a, int b) {
        if (a > b) {
            if (b == 0) {
                return 0.0;
            }
            return (double) a / b;
        }
        if (a == 0) {
            return 0.0;
        }
        return (double) b / a;
    }
}
