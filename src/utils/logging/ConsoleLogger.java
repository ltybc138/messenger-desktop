package utils.logging;

public class ConsoleLogger implements Logger {
    public static volatile ConsoleLogger instance;

    private ConsoleLogger() {}

    public static ConsoleLogger getInstance() {
        ConsoleLogger localInstance = instance;
        if (localInstance == null) {
            synchronized (ConsoleLogger.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new ConsoleLogger();
                }
            }
        }
        return localInstance;
    }

    @Override
    public void log(String msg, LogType logType) {
        switch (logType) {
            case ACTION:
                System.out.println("#Action: " + msg);
                break;
            case INFO:
                System.err.println("#Info: " + msg);
                break;
            case MESSAGE:
                System.out.println("#Message: " + msg);
                break;
            case ERROR:
                System.err.println("#Error: " + msg);
                break;
            case EXCEPTION:
                System.err.println("#Exception: " + msg);
                break;
            default:
                System.out.println(msg);
        }
    }
}
