package com.yifeng.algorithm.searching;

import java.util.NoSuchElementException;


public class RedBlackBST<K extends Comparable<K>, V>{
	private static final boolean RED   = false;
    private static final boolean BLACK = true;
    
    
    private Entry<K, V> root;
    private int size;
    
    static final boolean valEquals(Object o1, Object o2) {
        return (o1==null ? o2==null : o1.equals(o2));
    }
    
    public RedBlackBST() {
    	this.size = 0;
    	this.root = null;
    }
    
    static final class Entry<K,V> implements MapEntry<K,V> {
        K key;
        V value;
        Entry<K,V> left;
        Entry<K,V> right;
        Entry<K,V> parent;
        boolean color = BLACK;
        
        Entry(K key, V value, Entry<K,V> parent, boolean color) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.color  = color;
            left = null;
            right= null;
        }
        
        public K getKey() {return key;}
        public V getValue() {return value;}
        
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o){
            if (!(o instanceof Entry))
                return false;
            Entry<?,?> e = (Entry<?,?>)o;
            return valEquals(key,e.getKey()) && valEquals(value,e.getValue());
        }

        public int hashCode() {
            int keyHash = (key==null ? 0 : key.hashCode());
            int valueHash = (value==null ? 0 : value.hashCode());
            return keyHash ^ valueHash;
        }
    }
    
    public final Entry<K, V> getFirst() {
    	Entry<K,V> q = root;
    	if(q != null) {
    		while(q.left != null) {
    			q = q.left;
    		}
    	}
    	return q;
    }
    public final MapEntry<K, V> getLast(){
    	Entry<K,V> q = root;
    	if(q != null) {
    		while(q.right != null) {
    			q = q.right;
    		}
    	}
    	return q;
    }
    
	public void put(K key, V value) {
		if(key == null) throw new NullPointerException();
		Entry<K, V> node = root;
		Entry<K, V> parent = null;
		
		if(root == null) {
			root = new Entry<K, V>(key, value, parent, BLACK);
			size++;
			return;
		}
		
		while(node != null) {
			parent = node;
			if(node.key == key) {
				node.value = value;return;
			}else if(node.key.compareTo(key) < 0) {
				node = node.right;
			}else {
				node = node.left;
			}
		}
		if(parent.key.compareTo(key) > 0) {
			parent.left = new Entry<K, V>(key, value, parent, RED);
			adjust(parent.left);
		} else {
			parent.right = new Entry<K, V>(key, value, parent, RED);
			adjust(parent.right);
		}
		size++;
	}
	
	private Entry<K, V> anotherChild(Entry<K, V> father, Entry<K, V> child) {
		if(father.left == child) return father.right;
		else return father.left;
	}
	
	private void flipColor(Entry<K, V> node) {
		if(node.color==RED) node.color = BLACK;
		else node.color = RED;
	}
	
	private void leftRotate(Entry<K, V> p) {
		Entry<K,V> right = p.right;
		p.right = right.left;
		if(p.right != null) {
			p.right.parent = p;
		}
		right.parent = p.parent;
		if(right.parent == null) {
			this.root = right;
		} else if(p == p.parent.left) {
			p.parent.left = right;
		} else {
			p.parent.right = right;
		}
		right.left = p;
		p.parent = right;
	}
	private void rightRotate(Entry<K, V> p) {
		Entry<K,V> left = p.left;
		p.left = left.right;
		if(p.left != null) {
			p.left.parent = p;
		}
		left.parent = p.parent;
		if(left.parent == null) {
			this.root = left;
		} else if(p == p.parent.left) {
			p.parent.left = left;
		} else {
			p.parent.right = left;
		}
		left.right = p;
		p.parent = left;
	}
	
	private void adjust(Entry<K, V> node) {
		if(node.parent == null) {node.color = BLACK; return;}
		if(node.parent.color == BLACK) {return;}
		Entry<K, V> gFather = node.parent.parent;
		Entry<K, V> uncle 	= anotherChild(gFather, node.parent);
		if(uncle != null && uncle.color == RED) {
			flipColor(uncle);
			flipColor(gFather);
			flipColor(node.parent);
			adjust(gFather);
		} else if (valEquals(gFather.right, uncle)){
			if(valEquals(node.parent.right, node)) {
				node = node.parent;
				leftRotate(node);
			}
			flipColor(gFather);
			flipColor(node.parent);
			rightRotate(gFather);
		} else {
			if(valEquals(node.parent.left, node)) {
				node = node.parent;
				rightRotate(node);
			}
			flipColor(gFather);
			flipColor(node.parent);
			leftRotate(gFather);
		}
	}
	
	public int height() {
		return height(root);
	}
	private int height(Entry<K, V> node) {
		if(node == null) {
			return 0;
		} else {
			return Math.max(height(node.left), height(node.right)) + 1;
		}
	}
	
	private void transplant(Entry<K, V> u, Entry<K, V> v) {
		if(u.parent == null) {
			this.root = v;
		}
		else if(u == u.parent.left) {
			u.parent.left = v;
		}
		else {
			u.parent.right = v;
		}
		if(v != null)
			v.parent = u.parent;
	}
	private Entry<K, V> treeMinimum(Entry<K, V> node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
	public void delete(K key) {
		delete(key, root);
	}
	private void delete(K key, Entry<K, V> node) {
		if(node == null) {
			throw new NoSuchElementException();
		} else if(key == node.key) {
			delete(node);
		} else if(key.compareTo(node.key) < 0) {
			delete(key, node.left);
		} else {
			delete(key, node.right);
		}
	}
	
	public void delete(Entry<K, V> rnode) {
		Entry<K, V> node = rnode;
		Entry<K, V> x;
		boolean oldColor = node.color;
		
		if(rnode.left == null) {
			x = rnode.right;
			transplant(rnode, x);
		} else if(rnode.right == null) {
			x = rnode.left;
			transplant(rnode, x);
		} else {
			node = treeMinimum(rnode.right);
			oldColor = node.color;
			x = node.right;
			
			if(node.parent == rnode) {
				x.parent = node;
			}
			else{
				transplant(node, node.right);
				node.right = rnode.right;
				node.right.parent = node;
			}
			transplant(rnode, node);
			node.left = rnode.left;
			node.left.parent = node;
			node.color = rnode.color;
		}
		if(oldColor == BLACK)
			deleteAdjust(x);
	}
	
	private void deleteAdjust(Entry<K, V> x) {
		if(x == null) return;
		while(x != this.root && x.color == BLACK) {
			if(x == x.parent.left) {
				Entry<K, V> sibling = x.parent.right;
				if(sibling.color == RED) {
					flipColor(sibling);
					flipColor(x.parent);
					leftRotate(x.parent);
					sibling = x.parent.right;
				}
				if(sibling.left.color == BLACK &&sibling.right.color== BLACK) {
					sibling.color = RED;
					x = x.parent;
				}
				else {
					if(sibling.right.color == BLACK) {
						flipColor(sibling.left);
						flipColor(sibling);
						rightRotate(sibling);
						sibling = x.parent.right;
					}
					sibling.color = x.parent.color;
					x.parent.color= BLACK;
					flipColor(sibling.right);
					leftRotate(x.parent);
					x = this.root;
				}
			}
			else {
				Entry<K, V> sibling = x.parent.left;
				if(sibling.color == RED) {
					flipColor(x.parent);
					flipColor(sibling);
					rightRotate(x.parent);
					sibling = x.parent.left;
				}
				if(sibling.right.color ==BLACK && sibling.left.color ==BLACK) {
					sibling.color = RED;
					x = x.parent;
				}
				else {
					if(sibling.left.color == BLACK) {
						flipColor(sibling);
						flipColor(sibling.right);
						leftRotate(sibling);
					}
					sibling.color = x.parent.color;
					x.parent.color = BLACK;
					flipColor(sibling.left);
					rightRotate(x.parent);
					x = this.root;
				}
			}
		}
		x.color = BLACK;
	}
	public V get(K key) {
		return get(key, root);
	}
	
	private V get(K key, Entry<K, V> node){
		if(node == null) {
			throw new NoSuchElementException("the given key doesn't exist");
		}
		else if(key.compareTo(node.key) < 0) {
			return get(key, node.left);
		}
		else if(key.compareTo(node.key) > 0) {
			return get(key, node.right);
		}
		else {
			return node.getValue();
		}
	}
	
	public boolean containsKey(K key) {
		return containsKey(key, root);
	}
	
	private boolean containsKey(K key, Entry<K, V> node) {
		if(node == null) {
			return false;
		} else if(node.key.compareTo(key)==0) {
			return true;
		} else if(node.key.compareTo(key)>0) {
			return containsKey(key, node.left);
		} else {
			return containsKey(key, node.right);
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}


}
