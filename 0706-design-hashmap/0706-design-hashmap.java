class MyHashMap {
    Integer arr[];
    public MyHashMap() {
        arr = new Integer[1000000+1];
        // Arrays.fill(arr,-1);
    }
    
    public void put(int key, int value) {
        arr[key] = value;
    }
    
    public int get(int key) {
        if(arr[key]==null){
            return -1;
        }
        return arr[key];
    }
    
    public void remove(int key) {
        if(arr[key]!=null){
            arr[key] = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */