package ChatPackage;

import java.util.ArrayList;

// Command interface
public interface MessageOperation {

    ArrayList execute(ArrayList e);
    OpType getType();

}
