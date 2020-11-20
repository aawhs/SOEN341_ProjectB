import java.util.ArrayList;
public class ErrorReporter implements IReportable{
    ArrayList<_Error> errors;

    @Override
    public void record(_Error e) {
        //TODO ADD ERROR TO LIST
        errors.add(e);
    }
}