package org.example;

public class Recursion {
    class Node{
        int value;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }

    private Node root;

    public boolean insert(int value){
        Node newnode = new Node(value);
        if (root == null){
            root = newnode;
        }
        Node temp = root;

        while (true){
            if (newnode.value == temp.value){
                return false;
            }
            if (newnode.value < temp.value){
                if (temp.left == null){
                    temp.left = newnode;
                    return true;
                }
                temp = temp.left;
            }
            else {
                if (temp.right == null){
                    temp.right = newnode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contain(int value){
        if (root == null){
            return false;
        }

        Node temp = root;

        while (temp != null){
            if (value < temp.value){
                temp = temp.left;
            }
            else if (value > temp.value){
                temp = temp.right;
            }
            else {
                return true;
            }
        }
        return false;
    }

    //recursive contain method

    public boolean rContain(Node currentnode , int value){
        if (currentnode == null){
            return false;
        }
        if (value == currentnode.value){
            return true;
        }
        if (value < currentnode.value){
            return rContain(currentnode.left , value);
        }
        else {
            return rContain(currentnode.right , value);
        }
    }

    public boolean rContain(int value){
        return rContain(root , value);
    }

    //recursive insert method

    public Node rInsert(Node currentnode , int value){
        if (currentnode == null){
            return new Node(value);
        }
        if (value < currentnode.value){
            currentnode.left = rInsert(currentnode.left , value);
        }
        else if (value > currentnode.value){
            currentnode.right = rInsert(currentnode.right , value);
        }

        return currentnode;

    }

    public void rInsert(int value){
        rInsert(root , value);

    }

    //recursive delete method goes here

    public void rDelete(int value){
        rDelete(root, value);
    }

    private Node rDelete(Node currentNode, int value) {
        if (currentNode == null){
            return null;
        }
        if (value < currentNode.value){
            currentNode.left = rDelete(currentNode.left , value);
        } else if (value > currentNode.value) {
            currentNode.right = rDelete(currentNode.right , value);
        }
        else {
            if (currentNode.left == null && currentNode.right == null){
                return null;
            }
            if (currentNode.left == null){
                currentNode = currentNode.right;
            }
            if (currentNode.right == null){
                currentNode = currentNode.left;
            }
            else {
                int minvalue = minvalue(currentNode.right);
                currentNode.value = minvalue;
                currentNode.right = rDelete(currentNode.right , minvalue);
            }
        }
        return currentNode;
    }

    private int minvalue(Node currentNode) {
        while (currentNode != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }


}
