package ChatPackage;

import java.io.Serializable;

public class UpdateOperation implements MessageOperation, Serializable {

    public final OpType op = OpType.UPDATE;

    @Override
    public MessageCollection execute(MessageCollection c) {
        return c;
    }

    @Override
    public OpType getType() {
        return op;
    }

}
