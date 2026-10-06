class MyHashSet {
    private boolean[] demo;
    public MyHashSet() {
        demo = new boolean[1_000_001];
    }
    
    public void add(int key) {
        demo[key] = true;
    }
    
    public void remove(int key) {
        demo[key] = false;
    }
    
    public boolean contains(int key) {
        return demo[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */