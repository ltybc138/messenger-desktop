package utils.logging;

public class ConsoleLogger implements Logger {

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
