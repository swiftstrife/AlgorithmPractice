package com.interviews.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode
{
    TreeNode left;
    TreeNode right;
    int data;

    /**
     * TreeNode constructor (single data point).
     * @param data
     */
    public TreeNode(int data)
    {
        this.data = data;
    }

    /**
     * TreeNode constructor (multiple data points).
     * @param data
     */
    public TreeNode(int[] data)
    {
        if (data.length > 0)
        {
            this.data = data[0];
        }

        for (int i = 1; i < data.length; i++) {
            this.insert(data[i]);
        }
    }

    /**
     * Inserts data at first available space (non-sorted).
     * @param data
     */
    public void insert(int data)
    {
        TreeNode temp = this;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);

        while (!q.isEmpty())
        {
            TreeNode node = q.poll();
            if (node.left == null)
            {
                node.left = new TreeNode(data);
                break;
            } else {
                    q.add(node.left);
                }
            if (node.right == null)
            {
                node.right = new TreeNode(data);
                break;
            } else {
                q.add(node.right);
            }
        }
    }

    /**
     * Prints the root along with all its children (level order traversal).
     */
    public void printTree()
    {
        double spacing = Math.pow(2, (double)this.getDepth());
        TreeNode root = this;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty())
        {
            int size = q.size();
            System.out.print(getSpace(spacing * 0.75));
            for (int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();
                System.out.print(node.data + getSpace(spacing));

                if (node.left != null)
                {
                    q.add(node.left);
                }

                if (node.right != null)
                {
                    q.add(node.right);
                }
            }

            System.out.print("\n");
            spacing = spacing / 2;
        }
    }

    private String getSpace(double amount)
    {
        String spacing = "";
        for (double i = 0; i < amount; i++)
            spacing += " ";

        return spacing;
    }

    public int getDepth()
    {
        if (this == null)
            return 0;

        TreeNode root = this;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty())
        {
            int size = q.size();
            for (int i = 0; i < size; i++)
            {
                TreeNode node = q.poll();
                if (node.left != null)
                {
                    q.add(node.left);
                }

                if (node.right != null)
                {
                    q.add(node.right);
                }
            }

            depth++;
        }

        return depth;
    }


}