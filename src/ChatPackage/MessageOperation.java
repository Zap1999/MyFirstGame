package ChatPackage;

// Command interface
public interface MessageOperation {

    MessageCollection execute(MessageCollection e);
    OpType getType();

}
