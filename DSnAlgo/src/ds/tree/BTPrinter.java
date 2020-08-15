package ds.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * SOURCE : https://stackoverflow.com/questions/4965335/how-to-print-binary-tree-diagram
 */

public class BTPrinter {

    public static <T extends Comparable<?>> void printTree(BTNode root) {
        int maxLevel = BTPrinter.maxLevel(root);

        printBTNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printBTNodeInternal(List<BTNode> BTNodes, int level, int maxLevel) {
        if (BTNodes.isEmpty() || BTPrinter.isAllElementsNull(BTNodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTPrinter.printWhitespaces(firstSpaces);

        List<BTNode> newBTNodes = new ArrayList<BTNode>();
        for (BTNode BTNode : BTNodes) {
            if (BTNode != null) {
                System.out.print(BTNode.getData());
                newBTNodes.add(BTNode.getLeft());
                newBTNodes.add(BTNode.getRight());
            } else {
                newBTNodes.add(null);
                newBTNodes.add(null);
                System.out.print(" ");
            }

            BTPrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < BTNodes.size(); j++) {
                BTPrinter.printWhitespaces(firstSpaces - i);
                if (BTNodes.get(j) == null) {
                    BTPrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (BTNodes.get(j).getLeft() != null)
                    System.out.print("/");
                else
                    BTPrinter.printWhitespaces(1);

                BTPrinter.printWhitespaces(i + i - 1);

                if (BTNodes.get(j).getRight() != null)
                    System.out.print("\\");
                else
                    BTPrinter.printWhitespaces(1);

                BTPrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printBTNodeInternal(newBTNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(BTNode BTNode) {
        if (BTNode == null)
            return 0;

        return Math.max(BTPrinter.maxLevel(BTNode.getLeft()), BTPrinter.maxLevel(BTNode.getRight())) + 1;
    }

    private static  boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}


