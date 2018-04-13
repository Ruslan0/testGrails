package reporting

class Report {
    String project
    Date workdate
    Integer hours
    String descriptoin
    String login
    static hasMany = [employer: Employer]

    static constraints = {
        project blank: false
        workdate blank: false
        hours blank: false
        descriptoin blank: false
        login display: false, nullable: true
    }
}
