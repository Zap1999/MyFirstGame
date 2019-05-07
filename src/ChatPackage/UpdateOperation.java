package ChatPackage;

import java.io.Serializable;

public class UpdateOperation implements MessageOperation, Serializable {

    public final OpType op = OpType.UPDATE;

    @Override
    public void execute() {

    }

    @Override
    public OpType getType() {
        return op;
    }

}
