package strategy;

import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import operation.BalanceHandler;
import operation.Operation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FruitStrategyImplTest {
    private static Map<FruitTransaction.Operation, Operation> operationHashMap;
    private static FruitStrategyImpl fruitStrategy;
    private static FruitTransaction fruitTransaction;

    @Before
    public void before() throws Exception {
        operationHashMap = new HashMap<>();
        operationHashMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        fruitStrategy = new FruitStrategyImpl(operationHashMap);
        fruitTransaction = new FruitTransaction();
    }

    @Test
    public void getValidOperation_OK() {
        fruitTransaction.setOperation(FruitTransaction.Operation.BALANCE);
        Operation actual = fruitStrategy.proceed(fruitTransaction);
        FruitTransaction.Operation expected = FruitTransaction.Operation.BALANCE;
        Assert.assertEquals(expected, actual);
    }
}
