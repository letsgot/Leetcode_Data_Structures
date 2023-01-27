class Solution {
  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    Trie root = new Trie();
    for(int i = 0; i < words.length; i++) {
        if( words[i].length() > 0 )
            buildTrie(root, words[i]);
    }

    List<String> resultList = new ArrayList<String>();
    for(int i = 0; i < words.length; i++)
        if( search(root, words[i], 0, 0) )
            resultList.add(words[i]);
    return resultList;
}

public void buildTrie(Trie root, String word) {
    Trie current = root;
    for(int i = 0; i < word.length(); i++) {
        int index = word.charAt(i) - 'a';
        if( current.array[index] == null )
            current.array[index] = new Trie();
        current = current.array[index];
    }
    current.isWord = true;
}

// num represent the number of words that current word can be comprised of
public boolean search(Trie root, String word, int begin, int num) {
    Trie current = root;
    for(int i = begin; i < word.length(); i++) {
        int index = word.charAt(i) - 'a';
        if( current.array[index] == null )
            return false;
        current = current.array[index];
        if( current.isWord && search(root, word, i + 1, num + 1) ) 
            return true;
    }
    return num >= 1 && current.isWord;
}

class Trie {
    Trie array[] = new Trie[26];
    boolean isWord = false;
}
}