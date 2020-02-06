package home;

import com.sun.source.tree.Tree;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Trees {

    public static void main(String... args){
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(18);
        TreeNode n4 = new TreeNode(2);

        root.left = n1;
        root.rigth = n2;
        n2.rigth = n3;
        n1.rigth = n4;

        root.findParentsFromRoot(root,18, 0);
        HashSet<Integer> parentsN3 = new HashSet<>(TreeNode.parents);
        System.out.println(parentsN3.toString());
        TreeNode.parents.clear();
        root.findParentsFromRoot(root,45, 0);
        HashSet<Integer> parentsN4 = new HashSet<>(TreeNode.parents);
        System.out.println(parentsN4.toString());

        TreeSet<Integer> commons = new TreeSet<Integer>();
        for (Integer i: parentsN3) {
            if(parentsN4.contains(i)){
                commons.add(i);
            }
        }
        System.out.println(commons.toString());

        if(!commons.isEmpty())
            System.out.println(commons.first());
    }
}
