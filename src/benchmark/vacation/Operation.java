package benchmark.vacation;

public abstract class Operation {

    public static boolean transactionalFutureEnabled;
    public static int numberOfTransactionalFuture;
    public static boolean parallelizeUpdateTables;
    public static boolean readOnly;
    public static boolean unsafe;
    public Integer futureAborts=0;
    public Integer futuresEarlyAborts =0;

    public abstract void doOperation();

}
