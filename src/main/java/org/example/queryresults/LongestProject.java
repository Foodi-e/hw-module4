package org.example.queryresults;

public class LongestProject {
    private long id;
    private long clientId;
    private int durationInMonths;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public int getDurationInMonths() {
        return durationInMonths;
    }

    public void setDurationInMonths(int durationInMonths) {
        this.durationInMonths = durationInMonths;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", durationInMonths=" + durationInMonths +
                '}';
    }
}
