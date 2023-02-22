package interceptorAssignment;

import java.util.List;

// Define the Dispatcher class
public class RentalDispatcher {
    private List<Interceptor> interceptors;

    public RentalDispatcher(List<Interceptor> interceptors) {
        this.interceptors = interceptors;
    }

    public void dispatch(RentalContext context) {
        for (Interceptor interceptor : interceptors) {
            interceptor.intercept(context);
        }
    }
}