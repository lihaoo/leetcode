package jianzhi.未解决;

public class 二叉搜索树与双向链表 {
    public TreeNode Convert(TreeNode pRootOfTree) {

    }

    // 递归
//    public TreeNode Convert(TreeNode pRootOfTree) {
//        if (pRootOfTree == null) {
//            return null;
//        }
//
//        if (pRootOfTree.left != null) {
//            TreeNode treeNode = Convert(pRootOfTree.left);
//            while (treeNode.right != null) {
//                treeNode = treeNode.right;
//            }
//            pRootOfTree.left = treeNode;
//            treeNode.right = pRootOfTree;
//        }
//        if (pRootOfTree.right != null) {
//            TreeNode treeNode = Convert(pRootOfTree.right);
//            pRootOfTree.right = treeNode;
//            treeNode.left = pRootOfTree;
//        }
//
//        while (pRootOfTree.left != null) {
//            pRootOfTree = pRootOfTree.left;
//        }
//
//        return pRootOfTree;
//    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
