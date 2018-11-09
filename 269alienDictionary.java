class Solution {
    public String alienOrder(String[] words) {
        int n = countChar(words);
        Map<Character, List<Character>> orderMap = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String a = words[i];
            String b = words[i + 1];
            for (int j = 0; j < a.length() && j < b.length(); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    if (!orderMap.containsKey(a.charAt(j)))
                        orderMap.put(a.charAt(j), new LinkedList<>());
                    orderMap.get(a.charAt(j)).add(b.charAt(j));
                    break;
                }
                if (j == a.length() - 1 && j == b.length() - 1)
                    if (!orderMap.containsKey(a.charAt(j)))
                        orderMap.put(a.charAt(j), new LinkedList<>());
            }
        }
        Map<Character, Integer> indegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.put(c, 0);
            }
        }
        for (char key : orderMap.keySet()) {
            for (char c : orderMap.get(key)) {
                if (!indegree.containsKey(c))
                    indegree.put(c, 0);
                indegree.put(c, indegree.get(c) + 1);
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char key : indegree.keySet()) {
            if (indegree.get(key) == 0) 
                q.offer(key);
        }
        StringBuilder order = new StringBuilder();
        while (!q.isEmpty()) {
            char curr = q.poll();
            order.append(curr);
            if (!orderMap.containsKey(curr)) continue;
            List<Character> next = orderMap.get(curr);
            for (char c : next) {
                indegree.put(c, indegree.get(c) - 1);
                if (indegree.get(c) == 0)
                    q.offer(c);
            }
        }
        if (order.length() != n) return "";
        return order.toString();
    }
    private int countChar(String[] words) {
        Set<Character> charSet = new HashSet<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                charSet.add(c);
            }
        }
        return charSet.size();
    }
}
