//	https://leetcode.com/problems/design-search-autocomplete-system/
//	
//	Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with a special character '#'). For each character they type except '#', you need to return the top 3 historical hot sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:
//	
//	The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
//	The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences have the same degree of hot, you need to use ASCII-code order (smaller one appears first).
//	If less than 3 hot sentences exist, then just return as many as you can.
//	When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
//	Your job is to implement the following functions:
//	
//	The constructor function:
//	
//	AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence has been typed. Your system should record these historical data.
//	
//			Now, the user wants to input a new sentence. The following function will provide the next character the user types:
//	
//	List<String> input(char c): The input c is the next character typed by the user. The character will only be lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as the part of sentence already typed.
//	
//	
//			Example:
//	Operation: AutocompleteSystem(["i love you", "island","ironman", "i love leetcode"], [5,3,2,2])
//	The system have already tracked down the following sentences and their corresponding times:
//			"i love you" : 5 times 
//	"island" : 3 times 
//	"ironman" : 2 times 
//	"i love leetcode" : 2 times
//	Now, the user begins another search:
//	
//	Operation: input('i')
//	Output: ["i love you", "island","i love leetcode"]
//	Explanation:
//	There are four sentences that have prefix "i". Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot sentences, so "ironman" will be ignored.
//	
//			Operation: input(' ')
//	Output: ["i love you","i love leetcode"]
//	Explanation:
//	There are only two sentences that have prefix "i ".
//	
//	Operation: input('a')
//	Output: []
//	Explanation:
//	There are no sentences that have prefix "i a".
//	
//	Operation: input('#')
//	Output: []
//	Explanation:
//	The user finished the input, the sentence "i a" should be saved as a historical sentence in system. And the following input will be counted as a new search.
//	
//			Note:
//	The input sentence will always start with a letter and end with '#', and only one blank space will exist between two words.
//	The number of complete sentences that to be searched won't exceed 100. The length of each sentence including those in the historical data won't exceed 100.
//	Please use double-quote instead of single-quote when you write test cases even for a character input.
//	Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are persisted across multiple test cases. Please see here for more details.
class AutocompleteSystem {

    TrieNode root;
	TrieNode currentRoot;
    StringBuilder sb;
    Map<String, Integer> map;
    
	public AutocompleteSystem(String[] sentences, int[] times) {
		root = new TrieNode();
        currentRoot = root;
        map = new HashMap<>();
        sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            addWord(sentences[i], times[i]);
        }
    }

    private void addWord(String word, int times) {
        map.put(word, map.getOrDefault(word, times - 1) + 1);
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int position = getPosition(c);
            TrieNode temp = current.getNodes()[position];
            if (temp == null) {
                current.getNodes()[position] = new TrieNode();
                temp = current.getNodes()[position];
            }
            temp.add(new SearchNode(map.get(word), word));
            current = temp;
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            String toAdd = sb.toString();
	        sb = new StringBuilder();
	        if (!toAdd.isEmpty()) {
	            addWord(toAdd, 1);
            }
	        currentRoot = root;
	        return new ArrayList<>();
        }
	    sb.append(c);
        int position = getPosition(c);
	    if (currentRoot == null) return new ArrayList<>();
	    currentRoot = currentRoot.getNodes()[position];
        if (currentRoot == null) return new ArrayList<>();
        return currentRoot.getHotSentences();
    }

    private int getPosition(char c) {
        return c == ' ' ? 26 : c - 'a';
    }

    class SearchNode {
        private final int times;
        private final String sentence;

        SearchNode(int times, String sentence) {
            this.times = times;
            this.sentence = sentence;
        }

        int getTimes() {
            return times;
        }

        String getSentence() {
            return sentence;
        }

	    @Override
	    public boolean equals(Object o) {
		    if (this == o) return true;
		    if (o == null || getClass() != o.getClass()) return false;
		    SearchNode that = (SearchNode) o;
		    return Objects.equals(sentence, that.sentence);
	    }

	    @Override
	    public int hashCode() {
		    return Objects.hash(sentence);
	    }
    }

    class TrieNode {

        private final TrieNode[] nodes = new TrieNode[27];
        private PriorityQueue<SearchNode> heap =
                new PriorityQueue<>(
                        ((o1, o2) ->
                                o1.getTimes() != o2.getTimes()
                                        ? o2.getTimes() - o1.getTimes()
                                        : o1.getSentence().compareTo(o2.getSentence())));

        public TrieNode[] getNodes() {
            return nodes;
        }

        public void add(SearchNode searchNode) {
            heap.remove(searchNode);
            heap.offer(searchNode);
        }

        public List<String> getHotSentences() {
            List<SearchNode> temp = new ArrayList<>();
            List<String> hots = new ArrayList<>();
            int count = 3;
            while (!heap.isEmpty() && count-- > 0) {
                SearchNode node = heap.poll();
                hots.add(node.getSentence());
                temp.add(node);
            }
            heap.addAll(temp);
            return hots;
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
