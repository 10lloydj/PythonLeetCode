class Solution {
    private List<String> result = new ArrayList<>();
    private String phoneDigits;
    private Map<Character, String> letters = Map.of(
        '2',
        "abc",
        '3',
        "def",
        '4',
        "ghi",
        '5',
        "jkl",
        '6',
        "mno",
        '7',
        "pqrs",
        '8',
        "tuv",
        '9',
        "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        phoneDigits = digits;
        int size = digits.length();

        // add the first digit values into a list,
        // the next value iterates over the list and adds its letter to every one
        bt(new StringBuilder(), 0);

        return result;
    }

    private void bt(StringBuilder path, int index) {
        if(path.length() == phoneDigits.length()) {
            result.add(path.toString());
            return;
        }

        String possibleLetters = letters.get(phoneDigits.charAt(index));

        for (char letter: possibleLetters.toCharArray()) {
            path.append(letter);
            bt(path, index + 1);
            // delete the last letter to move onto the next
            path.deleteCharAt(path.length() - 1);

            // doing this creates multiple recursions, so at the end all digits are used. Instead of actively creating new paths we can recursively generate them
        }
    }
}