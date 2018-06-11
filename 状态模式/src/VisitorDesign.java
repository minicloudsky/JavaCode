import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

class NodeA implements Visitable {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class NodeB implements Visitable {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class NodeC implements Visitable {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

interface Visitable {
    public void accept(Visitor visitor);
}

interface Visitor {
    // 访问节点A
    public void visit(NodeA nodeA);

    // 访问节点B
    public void visit(NodeB nodeB);

    // 访问节点C
    public void visit(NodeC nodeC);

    // 访问节点集合
    public void visitCollection( Collection collection);
}

class VisitorA implements Visitor {
    public void visit(NodeA a) {
        System.out.println("执行 visitNodeA 方法!");;
    }

    public void visit(NodeB b) {
        System.out.println("执行 visitNodeB 方法!");
        ;
    }

    public void visit(NodeC c) {
        System.out.println("执行 visitNodeC 方法!");
    }

    public void visitCollection(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();
            if (o instanceof Visitable)
                ((Visitable) o).accept(this);
        }
    }
}

public class VisitorDesign {
    public static void main(String[] args) {
        System.out.println("15031210101      15软件工程1班               贾亚武");
        System.out.println();
        NodeA nodeA = new NodeA();
        NodeB nodeB = new NodeB();
        NodeC nodeC = new NodeC();
        // 访问单个对象
        VisitorA visitorA = new VisitorA();
        visitorA.visit(nodeA);
        visitorA.visit(nodeB);
        visitorA.visit(nodeC);
        // 访问集合
        List<Visitable> list = new ArrayList<Visitable>();
        list.add(nodeA);
        list.add(nodeB);
        list.add(nodeC);
        visitorA.visitCollection(list);

    }
}