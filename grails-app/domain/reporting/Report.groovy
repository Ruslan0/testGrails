package reporting

class Report {
    String project
    Date workdate
    Integer hours
    String descriptoin
    static hasMany = [employer: Employer]

    static constraints = {
        project blank: false
        workdate blank: false
        hours blank: false, max: 24
        descriptoin blank: false
    }
}
