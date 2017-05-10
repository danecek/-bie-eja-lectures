package jpql;

public class StatusCount {

    private Status status;
    private long count;

    public StatusCount() {
    }

    public StatusCount(Status status, long count) {
        this.status = status;
        this.count = count;
    }

    public Status getStatus() {
        return status;
    }

    public long getCount() {
        return count;
    }


    @Override
    public String toString() {
        return "{status=" + status + ": " + count + '}';
    }

}
