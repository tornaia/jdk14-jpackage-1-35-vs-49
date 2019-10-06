public class Service {

    public Service(OptionalService optionalService) {
    }

    public Service() {
        this(new OptionalService() {
        });
    }
}
