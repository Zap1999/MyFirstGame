package ChatPackage;

import java.io.Serializable;
import java.util.ArrayList;

public class UpdateOperation implements MessageOperation, Serializable {

    public final OpType op = OpType.UPDATE;

    @Override
    public ArrayList execute(ArrayList c) {
        return c;
    }

    @Override
    public OpType getType() {
        return op;
    }

}
