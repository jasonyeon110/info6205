package ClassNotes.Jan29;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree <T>{

    public Node<T> root;

    public BinaryTree() {

    }

    public int size(){
        return size(root);
    }

    private int size(Node<T> node){
        if (node == null)
            return 0;
        return size(node.left) + 1 + size(node.right);
    }

    public int height(){
        return height(root);
    }

    private int height(Node<T> node){
        if(node == null){
            return 0;
        }

        int lHeight = height(node.left);
        int rHeight = height(node.right);

        return 1 + Math.max(lHeight, rHeight);
    }


    public void preOrder(Node<T> node){

        if(node != null){
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);

        }
    }

    public void levelOrder(){
        if(root == null){
            return;
        }

        Queue<T> queue = new LinkedList<>();
        queue.add((T) root);
        queue.add(null);

        while(queue.size() > 0){
            Node<T> node = (Node<T>) queue.remove();

            if(node != null){
                System.out.printf(node.data + ", ");
                if(node.left != null){
                    queue.add((T) node.left);
                }
                if(node.right != null){
                    queue.add((T) node.right);
                }
            } else{
                System.out.println("");
                if(queue.size() == 0){
                    break;
                }
                queue.add(null);
            }
        }

    }

    public void prinfLeftView(){
        if(root == null){
            return;
        }

        Queue<T> queue = new LinkedList<>();
        queue.add((T) root);
        queue.add(null);
        boolean bPrint = false;

        while(queue.size() > 0){
            Node<T> node = (Node<T>) queue.remove();

            if(node != null){
                if(bPrint == false){
                    System.out.printf(node.data + ", ");
                    bPrint = true;
                }

                if(node.left != null){
                    queue.add((T) node.left);
                }
                if(node.right != null){
                    queue.add((T) node.right);
                }
            } else{
                System.out.println("");
                if(queue.size() == 0){
                    break;
                }
                queue.add(null);
                bPrint = false;
            }
        }

    }

    public void printRightView(){
        if(root == null){
            return;
        }

        Queue<T> queue = new LinkedList<>();
        queue.add((T) root);
        queue.add(null);
        Node<T> lastVal = null;

        while(queue.size() > 0){
            Node<T> node = (Node<T>) queue.remove();
            if(node != null){
                lastVal = node;
                if(node.left != null){
                    queue.add((T) node.left);
                }
                if(node.right != null){
                    queue.add((T) node.right);
                }
            } else{
                System.out.println(lastVal.data);
                if(queue.size() == 0){
                    break;
                }
                queue.add(null);
            }
        }

    }


    public void printZigZag(){
        if(root == null){
            return;
        }

        Queue<T> queue = new LinkedList<>();
        queue.add((T) root);
        queue.add(null);
        boolean bPrint = true;
        Stack<Node<T>> stack = new Stack<>();

        while(queue.size() > 0){
            Node<T> node = (Node<T>) queue.remove();
            if(node != null){
                if(bPrint){
                    System.out.printf(node.data + ", ");

                } else{
                    stack.push(node);
                }
                if(node.left != null){
                    queue.add((T) node.left);
                }
                if(node.right != null){
                    queue.add((T) node.right);
                }
            } else{
               while(stack.size() != 0){
                   System.out.println(stack.pop().data + " ");
               }
                System.out.println("");
               bPrint = !bPrint;

               if (stack.size() == 0){
                   break;
               }
                queue.add(null);
            }
        }

    }

    public void printPerimeter(){
        Stack<Node<T>> stack = new Stack<>();
        printPerimeter(root, 0,0, stack);
        while(!stack.isEmpty()){
            System.out.printf(stack.pop().data + ", ");
        }
        System.out.println("");
    }

    private void printPerimeter(Node<T> node, int left, int right, Stack<Node<T>> stack){
        if(node != null){
            if(node.left == null && node.right ==null){
                System.out.printf(node.data + ", ");
            } else{
                if(right ==0){
                    System.out.printf(node.data + ", ");
                }else if(left == 0){
                    stack.push(node);
                }
            }

            printPerimeter(node.left, left +1, right, stack);
            printPerimeter(node.right, left, right +1 , stack);
        }
    }

    public boolean isSameTree(Node<T> node1, Node<T> node2){
        if(node1 == null && node2 == null){
            return true;
        }

        if(node1 == null || node2 == null){
            return false;
        }

        return (node1.data == node2.data) && isSameTree(node1.left, node2.left) && isSameTree(node1.right, node2.right);
    }

    public boolean isSubTree(Node<T> subTree, Node<T> tree){
        return isSameTree(subTree, tree) || isSameTree(subTree, tree.left) ||
                isSameTree(subTree, tree.right);
    }

}
