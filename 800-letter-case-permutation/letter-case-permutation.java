class Solution {
    public void req(List<String> lst, int ind, StringBuilder str)
    {
        while (ind < str.length() && !Character.isAlphabetic(str.charAt(ind)))
            ind++;

        if (ind < str.length()) {
            str.setCharAt(ind, Character.toUpperCase(str.charAt(ind)));
            req(lst, ind + 1, str);
            str.setCharAt(ind, Character.toLowerCase(str.charAt(ind)));
            req(lst, ind + 1, str);
        }
        else
            lst.add(str.toString());
    }
    public List<String> letterCasePermutation(String s) {
        List<String> lst = new ArrayList<>();
        req(lst, 0, new StringBuilder(s));
        return lst;
    }
}