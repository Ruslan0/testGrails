package reporting

class Report {
    String name
    String city
    Date startDate
    Date endDate
    String purpose
    String notes
    String user

    static constraints = {
        name blank: false
        city blank: false
        startDate blank: false
        endDate blank: false
        purpose blank: false
        notes blank: false
        user display: false, nullable: true
    }
}
