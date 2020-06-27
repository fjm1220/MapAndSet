//实现二叉搜索树
public class binarySearchTreeDemo {
    static class Node{
        int key;
        Node left;
        Node right;
        public Node(int key){
            this.key = key;
        }
    }
    private Node root = null;
    //查找
    public Node Find(int key){
    Node cur = root;
    //只要当前节点不为空就去查找
    //当要查找的值大于当前结点的值时就去该结点的右子树找
    //当要查找的值小于当前结点的值时就去该结点的左子树找
    while(cur != null){
        if(key > cur.key){
            cur = cur.right;
        }
        else if(key < cur.key){
            cur = cur.left;
        }
        else{
            return cur;
        }
    }
    return null;
    }
    //插入
    public boolean insert(int key){
        //如果该二叉树为空就直接插入
        //否则就先查找要插入的位置
        //注意在查找的过程中如果要插入的值已经存在就直接返回false插入失败
        if(root == null){
            root = new Node(key);
            return true;
        }
        //用parent来记录cur的父结点
        Node parent = null;
        Node cur = root;
        while(cur != null){
            if(key > cur.key){
                parent = cur;
                cur = cur.right;
            }
            else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }
            else{
                return false;
            }
        }
        if(key > parent.key){
            parent.right = new Node(key);
        }
        else{
            parent.left  = new Node(key);
        }
        return true;
    }
    //删除
    public boolean remove(int key){
        //先找到要删除的结点
        Node cur = root;
        Node parent = null;
        while(cur != null){
            if(key > cur.key){
                parent = cur;
                cur = cur.right;
            }
            else if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }
            else{
                //找到要删除的结点,cur为要删除的结点
                removeNode(parent,cur);
                return true;
            }
        }
        //不存在直接返回false
        return false;
    }
    private void removeNode(Node parent,Node cur){
        //1.当前结点的左子树为空
            //1.1当前结点为根结点
            //1.2当前结点为父结点的左子树
            //1.3当前结点为父结点的右子树
        if(cur.left == null){
            if(cur == root){
                root = cur.right;
            }
            else if(cur == parent.left){
                parent.left = cur.right;
            }
            else{
                parent.right = cur.right;
            }
        }
        //2.当前结点的右子树为空
        //也是有以上三种情况2.2 2.3 2.4
        else if(cur.right == null){
            if(cur == root){
                root = cur.left;
            }
            else if(cur == parent.left){
                parent.left = cur.left;
            }
            else{
                parent.right = cur.left;
            }
        }
        //3.当前节点的左右子树都不为空
        //利用替换法替换要删除的结点
        //找要删除结点cur的右子树中最小的元素或者左子树中最大的元素
        else{
            //这里找右子树中的最小元素进行替换
            Node goatParent = cur;
            Node goat = cur.right;
            while(goat.left != null){
                goatParent = goat;
                goat = goat.left;
            }
            cur.key = goat.key;
            if(goat == goatParent.left){
                goatParent.left = goat.right;
            }
            else{
                goatParent.right = goat.right;
            }
        }
    }
}
