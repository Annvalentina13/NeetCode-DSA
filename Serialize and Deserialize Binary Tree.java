import java.util.*;

public class Codec {

    // Serialize
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // Deserialize
    int index = 0;

    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        index = 0;
        return build(values);
    }

    private TreeNode build(String[] values) {

        if (values[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index]));
        index++;

        node.left = build(values);
        node.right = build(values);

        return node;
    }
}
