package com.jgoramirez.problems.bts;

public class ValidateBTSSearchTree {
    public static void main(String[] args) {

        Solution solution = new Solution();

        TreeNode node1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(node1);

        System.out.println(solution.isValidBST(node1));

        TreeNode node2 = new TreeNode(5,
                new TreeNode(1), new TreeNode(4,
                    new TreeNode(3), new TreeNode(8)));
        System.out.println(node2);

        System.out.println(solution.isValidBST(node2));

    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidTree(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        // Si el nodo es nulo, es un BST válido
        if (node == null) {
            return true;
        }

        // Comprobar si el valor del nodo actual está dentro del rango permitido
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        // Validar recursivamente el subárbol izquierdo y derecho si existen
        // Actualizar el rango permitido para los nodos hijos
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    private boolean isValidTree(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isValidTree(node.left, min, node.val) && isValidTree(node.right, node.val, max);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "" + val + (left != null ? ", " + left : "") + (right != null ? ", " + right : "");
    }
}
