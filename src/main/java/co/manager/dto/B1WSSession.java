package co.manager.dto;

/**
 * @author dbotero
 */
public class B1WSSession implements Comparable<B1WSSession>{
    private String sessionId;
    private String company;
    private long created;
    private long lastBorrowed;

    public B1WSSession(String sessionId, long created) {
        this.sessionId = sessionId;
        this.created = created;
    }

    public B1WSSession() {
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getLastBorrowed() {
        return lastBorrowed;
    }

    public void setLastBorrowed(long lastBorrowed) {
        this.lastBorrowed = lastBorrowed;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public int compareTo(B1WSSession o) {
        return Long.compare(o.lastBorrowed, lastBorrowed);
    }
}
