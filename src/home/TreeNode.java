package home;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashSet;

public class TreeNode {

    public TreeNode left;
    public TreeNode rigth;
    //public TreeNode parent;
    public int data; //data = -1 = root
    public int size;
    public static HashSet<Integer> parents;


    TreeNode(){
        left = null;
        rigth = null;
        parents = new HashSet<Integer>();
    }

    public TreeNode(int d) {
        data = d;
        size = 1;
        parents = new HashSet<Integer>();
    }

    public void findParentsFromRoot(TreeNode from, int nodeToLook, int parent){

        if(from.data == nodeToLook){
            from.parents.add(parent);
            return;
        } else {
            if(from.left != null){
                from.parents.add(parent);
                findParentsFromRoot(from.left, nodeToLook, from.data);
            }
            if(from.rigth != null){
                from.parents.add(parent);
                findParentsFromRoot(from.rigth, nodeToLook, from.data);
            }
            if((from.left == null && from.rigth == null)) return;
        }
    }
}
